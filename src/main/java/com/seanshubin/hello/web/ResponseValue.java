package com.seanshubin.hello.web;

import java.util.List;
import java.util.Objects;

public class ResponseValue {
    public final int statusCode;
    public final ArrayOfBytes body;
    public final List<NameValue> headers;

    public ResponseValue(int statusCode, ArrayOfBytes body, List<NameValue> headers) {
        this.statusCode = statusCode;
        this.body = body;
        this.headers = headers;
    }

    @Override
    public String toString() {
        return "ResponseValue{" +
                "statusCode=" + statusCode +
                ", body=" + body +
                ", headers=" + headers +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResponseValue that = (ResponseValue) o;
        return statusCode == that.statusCode &&
                Objects.equals(body, that.body) &&
                Objects.equals(headers, that.headers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(statusCode, body, headers);
    }
}
