package com.seanshubin.hello.web;

public class Request {
    private final String command;
    private final String target;

    public Request(String command, String target) {
        this.command = command;
        this.target = target;
    }

    public String command() {
        return command;
    }

    public String target() {
        return target;
    }
}
