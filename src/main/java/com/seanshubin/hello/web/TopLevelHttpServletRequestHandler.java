package com.seanshubin.hello.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TopLevelHttpServletRequestHandler implements HttpServletRequestHandler {
    private final Handler delegate;

    public TopLevelHttpServletRequestHandler(Handler delegate) {
        this.delegate = delegate;
    }

    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        Request request = HttpServletTransformer.transformRequest(httpServletRequest);
        String response = delegate.handle(request);
        HttpServletTransformer.transformResponse(response, httpServletResponse);
    }
}
