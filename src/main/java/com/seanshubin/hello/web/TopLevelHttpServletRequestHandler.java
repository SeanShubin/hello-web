package com.seanshubin.hello.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

class TopLevelHttpServletRequestHandler implements HttpServletRequestHandler {
    private final Handler delegate;

    TopLevelHttpServletRequestHandler(Handler delegate) {
        this.delegate = delegate;
    }

    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        // Make everything easy to test with value objects
        // Once you can transform between the Servlet specific request and response to value objects
        // Both the test and code are easier to write because they can share the same value objects
        // Alternatively, you could fake/stub/mock the request and response for test, using the real ones throughout the production code
        // Either way will work, so choose what is more comprehensible and/or practical for your situation
        RequestValue request = HttpServletRequestTransformer.transformRequest(httpServletRequest);
        ResponseValue response = delegate.handle(request);
        HttpServletResponseTransformer.transformResponse(response, httpServletResponse);
    }
}
