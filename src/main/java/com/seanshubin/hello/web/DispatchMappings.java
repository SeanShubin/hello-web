package com.seanshubin.hello.web;

public interface DispatchMappings {
    Handler lookupByPath(String path);
}
