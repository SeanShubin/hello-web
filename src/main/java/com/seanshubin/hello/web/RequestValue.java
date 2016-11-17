package com.seanshubin.hello.web;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

class RequestValue {
    final String method;
    final String path;
    final String query;
    final List<Header> headers;

    RequestValue(String method, String path, String query, List<Header> headers) {
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

    String singleQueryParameter(String name) {
        String[] pairs = query.split("&");
        List<String> matches = new ArrayList<>();
        for (String pair : pairs) {
            String[] keyValue = pair.split("=");
            String key = keyValue[0];
            if (name.equals(key)) {
                String value = keyValue[1];
                matches.add(value);
            }
        }
        if (matches.size() == 1) {
            return matches.get(0);
        } else {
            throw new RuntimeException(String.format("Expected exactly one parameter matching '%s', got %d", name, matches.size()));
        }
    }
}
