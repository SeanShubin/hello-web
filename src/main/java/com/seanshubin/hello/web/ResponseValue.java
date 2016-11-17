package com.seanshubin.hello.web;

import java.util.List;
import java.util.Objects;

class ResponseValue {
    final int statusCode;
    final ArrayOfBytes body;
    final List<Header> headers;

    ResponseValue(int statusCode, ArrayOfBytes body, List<Header> headers) {
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

    static ResponseValue plainTextUtf8(int statusCode, String s) {
        ArrayOfBytes body = ArrayOfBytes.fromStringUtf8(s);
        List<Header> headers = Header.createHeaders("Content-Type", "text/plain; charset=UTF-8");
        ResponseValue response = new ResponseValue(statusCode, body, headers);
        return response;
    }
}
