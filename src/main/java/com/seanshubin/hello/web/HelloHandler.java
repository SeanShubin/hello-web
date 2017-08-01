package com.seanshubin.hello.web;

import javax.servlet.http.HttpServletResponse;

public class HelloHandler implements Handler {
    @Override
    public ResponseValue handle(RequestValue request) {
        String target = request.singleQueryParameter("target");
        String responseText = String.format("Hello, %s!", target);
        return ResponseValue.plainTextUtf8(HttpServletResponse.SC_OK, responseText);
    }
}
