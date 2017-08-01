package com.seanshubin.hello.web;

import java.util.Optional;

class Dispatcher implements Handler {
    private final DispatchMappings dispatchMappings;
    private final Handler defaultHandler;

    public Dispatcher(DispatchMappings dispatchMappings, Handler defaultHandler) {
        this.dispatchMappings = dispatchMappings;
        this.defaultHandler = defaultHandler;
    }

    @Override
    public ResponseValue handle(RequestValue request) {
        Optional<Handler> handlerOptional = dispatchMappings.lookupByPath(request.path);
        ResponseValue responseValue = handlerOptional.
                map(handler -> handler.handle(request)).
                orElse(defaultHandler.handle(request));
        return responseValue;
    }
}
