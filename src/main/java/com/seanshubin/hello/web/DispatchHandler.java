package com.seanshubin.hello.web;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class DispatchHandler implements Handler {
    private Map<String, Function<String, String>> commandMap;

    public DispatchHandler() {
        commandMap = new HashMap<>();
        commandMap.put("/hello", this::sayHello);
        commandMap.put("/length", this::displayLength);
    }

    @Override
    public ResponseValue handle(RequestValue request) {
        String target = request.singleQueryParameter("target");
        String result = lookupCommand(request.path).apply(target);
        return ResponseValue.plainTextUtf8(result);
    }

    private String displayLength(String target) {
        return String.format("length: %d", target.length());
    }

    private String sayHello(String target) {
        return String.format("Hello, %s!", target);
    }

    private Function<String, String> lookupCommand(String key) {
        if (commandMap.containsKey(key)) {
            return commandMap.get(key);
        } else {
            throw new RuntimeException(String.format("Key not found: %s", key));
        }
    }
}
