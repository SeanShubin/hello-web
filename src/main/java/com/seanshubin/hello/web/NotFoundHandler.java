package com.seanshubin.hello.web;

import javax.servlet.http.HttpServletResponse;

public class NotFoundHandler implements Handler {
    @Override
    public ResponseValue handle(RequestValue request) {
        String message = String.format("Unable to handle request at path '%s'", request.path);
        ResponseValue responseValue = ResponseValue.plainTextUtf8(HttpServletResponse.SC_NOT_FOUND, message);
        return responseValue;
    }
}
