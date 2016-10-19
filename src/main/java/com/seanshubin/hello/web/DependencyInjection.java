package com.seanshubin.hello.web;

import javax.servlet.ServletConfig;

public class DependencyInjection {
    private ServletConfig servletConfig;

    public DependencyInjection(ServletConfig servletConfig) {
        this.servletConfig = servletConfig;
    }

    private Handler dispatcher;

    public synchronized Handler dispatcher() {
        if (dispatcher == null) {
            dispatcher = new DispatchHandler();
        }
        return dispatcher;
    }

    private HttpServletRequestHandler httpServletRequestHandler;

    public synchronized HttpServletRequestHandler httpServletRequestHandler() {
        if (httpServletRequestHandler == null) {
            httpServletRequestHandler = new TopLevelHttpServletRequestHandler(dispatcher());
        }
        return httpServletRequestHandler;
    }
}
