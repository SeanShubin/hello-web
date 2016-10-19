package com.seanshubin.hello.web;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class DispatchHandler implements Handler {
    private Map<String, Function<Request, String>> commandMap;

    public DispatchHandler() {
        commandMap = new HashMap<>();
        commandMap.put("hello", this::sayHello);
        commandMap.put("length", this::displayLength);
    }

    public String handle(Request request) {
        return commandMap.get(request.command()).apply(request);
    }

    private String displayLength(Request request) {
        return String.format("length: %d", request.target().length());
    }

    private String sayHello(Request request) {
        return String.format("Hello, %s!", request.target());
    }
}
