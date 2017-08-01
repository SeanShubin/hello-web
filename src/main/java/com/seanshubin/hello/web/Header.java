package com.seanshubin.hello.web;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

class Header {
    final String name;
    final String value;

    Header(String name, String value) {
        this.name = name;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Header{" +
                "name='" + name + '\'' +
                ", value='" + value + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Header header = (Header) o;
        return Objects.equals(name, header.name) &&
                Objects.equals(value, header.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, value);
    }

    static List<Header> createHeaders(String... namesAndValues) {
        List<Header> headers = new ArrayList<>();
        int index = 0;
        while (index < namesAndValues.length / 2) {
            String name = namesAndValues[index * 2];
            String value = namesAndValues[index * 2 + 1];
            Header header = new Header(name, value);
            headers.add(header);
            index++;
        }
        return Collections.unmodifiableList(headers);
    }

    static List<Header> plainTextUtf8() {
        return createHeaders("Content-Type", "text/plain; charset=UTF-8");
    }
}
