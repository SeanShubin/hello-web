package com.seanshubin.hello.web;

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
}
