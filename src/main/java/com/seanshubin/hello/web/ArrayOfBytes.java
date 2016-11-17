package com.seanshubin.hello.web;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

// Java does not have an immutable array type.
// There are many ways to deal with this.
// For my purposes it is sufficient to use encapsulation
// and defensive copies to protect the byte array from
// the extra complexity inherent is relying on mutable state.
class ArrayOfBytes {
    private final byte[] bytes;

    private ArrayOfBytes(byte[] bytes) {
        this.bytes = Arrays.copyOf(bytes, bytes.length);
    }

    byte[] bytes() {
        return Arrays.copyOf(bytes, bytes.length);
    }

    @Override
    public String toString() {
        return "ArrayOfBytes{" +
                "bytes=" + Arrays.toString(bytes) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArrayOfBytes that = (ArrayOfBytes) o;
        return Arrays.equals(bytes, that.bytes);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(bytes);
    }

    String toStringUtf8() {
        return new String(bytes, StandardCharsets.UTF_8);
    }

    static ArrayOfBytes fromStringUtf8(String body) {
        byte[] bytes = body.getBytes(StandardCharsets.UTF_8);
        return new ArrayOfBytes(bytes);
    }
}
