package com.seanshubin.hello.web;

import java.util.Objects;

public class ResponseValue {
    public final int statusCode;
    public final ArrayOfBytes body;

    public ResponseValue(int statusCode, ArrayOfBytes body) {
        this.statusCode = statusCode;
        this.body = body;
    }

    @Override
    public String toString() {
        return "ResponseValue{" +
                "statusCode=" + statusCode +
                ", body='" + body + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResponseValue that = (ResponseValue) o;
        return statusCode == that.statusCode &&
                Objects.equals(body, that.body);
    }

    @Override
    public int hashCode() {
        return Objects.hash(statusCode, body);
    }
}
