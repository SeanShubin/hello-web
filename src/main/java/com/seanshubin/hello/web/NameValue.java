package com.seanshubin.hello.web;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class NameValue {
    public final String name;
    public final String value;

    public NameValue(String name, String value) {
        this.name = name;
        this.value = value;
    }

    @Override
    public String toString() {
        return "NameValue{" +
                "name='" + name + '\'' +
                ", value='" + value + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NameValue nameValue = (NameValue) o;
        return Objects.equals(name, nameValue.name) &&
                Objects.equals(value, nameValue.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, value);
    }

    public static List<NameValue> createHeaders(String... namesAndValues) {
        List<NameValue> headers = new ArrayList<>();
        int index = 0;
        while (index < namesAndValues.length / 2) {
            String name = namesAndValues[index * 2];
            String value = namesAndValues[index * 2 + 1];
            NameValue nameValue = new NameValue(name, value);
            headers.add(nameValue);
            index++;
        }
        return Collections.unmodifiableList(headers);
    }
}
