package com.seanshubin.hello.web;

import java.util.HashMap;
import java.util.Map;

public class SampleDispatchMappings implements DispatchMappings {
    private final Map<String, Handler> handlers;

    public SampleDispatchMappings(HelloHandlerMarker helloHandler, AddHandlerMarker addHandler) {
        handlers = new HashMap<>();
        handlers.put("/hello", helloHandler);
        handlers.put("/add", addHandler);
    }

    @Override
    public Handler lookupByPath(String path) {
        return handlers.get(path);
    }
}
