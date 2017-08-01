package com.seanshubin.hello.web;

import java.util.HashMap;
import java.util.Map;

public class DomainDispatchMappings implements DispatchMappings {
    private final Handler defaultHandler = new NotFoundHandler();
    private final Map<String, Handler> handlers;

    public DomainDispatchMappings() {
        handlers = new HashMap<>();
        handlers.put("/hello", new HelloHandler());
        handlers.put("/add", new AddHandler());
    }

    @Override
    public Handler lookupByPath(String path) {
        return handlers.getOrDefault(path, defaultHandler);
    }
}
