package com.seanshubin.hello.web;

import javax.servlet.http.HttpServletResponse;
import java.util.function.Function;

class Dispatcher implements Handler {
    private final DispatchMappings dispatchMappings;

    public Dispatcher(DispatchMappings dispatchMappings) {
        this.dispatchMappings = dispatchMappings;
    }

    @Override
    public ResponseValue handle(RequestValue request) {
        Handler handler = dispatchMappings.lookupByPath(request.path);
        final ResponseValue responseValue;
        if (handler == null) {
            String message = String.format("Unable to handle request at path '%s'", request.path);
            responseValue = ResponseValue.plainTextUtf8(HttpServletResponse.SC_NOT_FOUND, message);
        } else {
            responseValue = handler.handle(request);
        }
        return responseValue;
    }
}
