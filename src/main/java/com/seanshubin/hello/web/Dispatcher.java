package com.seanshubin.hello.web;

class Dispatcher implements Handler {
    private final DispatchMappings dispatchMappings;

    public Dispatcher(DispatchMappings dispatchMappings) {
        this.dispatchMappings = dispatchMappings;
    }

    @Override
    public ResponseValue handle(RequestValue request) {
        Handler handler = dispatchMappings.lookupByPath(request.path);
        ResponseValue responseValue = handler.handle(request);
        return responseValue;
    }
}
