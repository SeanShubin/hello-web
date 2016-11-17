package com.seanshubin.hello.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

class TopLevelHttpServletRequestHandler implements HttpServletRequestHandler {
    private final Handler delegate;

    TopLevelHttpServletRequestHandler(Handler delegate) {
        this.delegate = delegate;
    }

    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        RequestValue request = HttpServletRequestTransformer.transformRequest(httpServletRequest);
        ResponseValue response = delegate.handle(request);
        HttpServletResponseTransformer.transformResponse(response, httpServletResponse);
    }
}
