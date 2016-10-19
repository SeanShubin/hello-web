package com.seanshubin.hello.web;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RequestValue {
    public final String method;
    public final String path;
    public final String query;
    public final List<NameValue> headers;

    public RequestValue(String method, String path, String query, List<NameValue> headers) {
        this.method = method;
        this.path = path;
        this.query = query;
        this.headers = Collections.unmodifiableList(new ArrayList<>(headers));
    }
}
