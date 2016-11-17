package com.seanshubin.hello.web;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

class EntryPointServlet extends HttpServlet {
    private static DependencyInjection dependencyInjection;

    @Override
    public void init(ServletConfig config) throws ServletException {
        dependencyInjection = new DependencyInjection(config);
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        dependencyInjection.httpServletRequestHandler.handle(request, response);
    }
}
