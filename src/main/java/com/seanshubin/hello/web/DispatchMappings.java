package com.seanshubin.hello.web;

import java.util.Optional;

public interface DispatchMappings {
    Optional<Handler> lookupByPath(String path);
}
