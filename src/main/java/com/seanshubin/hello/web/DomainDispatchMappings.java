package com.seanshubin.hello.web;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class DomainDispatchMappings implements DispatchMappings {
    private final Map<String, Handler> handlers;

    public DomainDispatchMappings() {
        handlers = new HashMap<>();
        handlers.put("/hello", new HelloHandler());
        handlers.put("/add", new AddHandler());
    }

    @Override
    public Optional<Handler> lookupByPath(String path) {
        return Optional.ofNullable(handlers.get(path));
    }
}
