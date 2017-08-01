package com.seanshubin.hello.web;

import javax.servlet.ServletConfig;

class DependencyInjection {
    DependencyInjection(ServletConfig servletConfig) {
        // ServletConfig is not needed right now.
        // I only left this in to demonstrate how this information
        // would be passed along from EntryPointServlet if it was needed.
        // Taking care of this now also ensures EntryPointServlet never has a reason to change, which means one less thing that can go wrong.
    }

    // Should these be lazy?
    // Easy enough to implement, but not needed yet.
    // Don't assume you need complexity until you can measure the cost of living without that complexity.
    private final DispatchMappings dispatchMappings = new DomainDispatchMappings();
    private final Handler dispatcher = new Dispatcher(dispatchMappings);
    final HttpServletRequestHandler httpServletRequestHandler = new TopLevelHttpServletRequestHandler(dispatcher);
}
