package com.seanshubin.hello.web;

import javax.servlet.ServletConfig;

class DependencyInjection {
    DependencyInjection(ServletConfig servletConfig) {
        // Servlet config not needed right now,
        // I only left this in to demonstrate how this information
        // would be passed along from the EntryPointServlet if it was needed.
    }

    final Handler dispatcher = new DispatchHandler();
    final HttpServletRequestHandler httpServletRequestHandler = new TopLevelHttpServletRequestHandler(dispatcher);
}
