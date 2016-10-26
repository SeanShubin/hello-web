package com.seanshubin.hello.web;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

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

    @Override
    public String toString() {
        return "RequestValue{" +
                "method='" + method + '\'' +
                ", path='" + path + '\'' +
                ", query='" + query + '\'' +
                ", headers=" + headers +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RequestValue that = (RequestValue) o;
        return Objects.equals(method, that.method) &&
                Objects.equals(path, that.path) &&
                Objects.equals(query, that.query) &&
                Objects.equals(headers, that.headers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(method, path, query, headers);
    }
}
