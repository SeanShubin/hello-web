package com.seanshubin.hello.web;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

class DispatchHandler implements Handler {
    private Map<String, Function<String, String>> commandMap;

    DispatchHandler() {
        commandMap = new HashMap<>();
        commandMap.put("/hello", this::sayHello);
        commandMap.put("/length", this::displayLength);
    }

    @Override
    public ResponseValue handle(RequestValue request) {
        Function<String, String> command = commandMap.get(request.path);
        if (command == null) {
            return ResponseValue.plainTextUtf8(HttpServletResponse.SC_NOT_FOUND, request.toString());
        } else {
            String target = request.singleQueryParameter("target");
            String result = command.apply(target);
            return ResponseValue.plainTextUtf8(HttpServletResponse.SC_OK, result);
        }
    }

    private String displayLength(String target) {
        return String.format("length: %d", target.length());
    }

    private String sayHello(String target) {
        return String.format("Hello, %s!", target);
    }
}
