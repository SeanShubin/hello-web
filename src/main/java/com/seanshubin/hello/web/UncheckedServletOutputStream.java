package com.seanshubin.hello.web;

import javax.servlet.ServletOutputStream;
import java.io.IOException;

class UncheckedServletOutputStream {
    final ServletOutputStream delegate;

    UncheckedServletOutputStream(ServletOutputStream delegate) {
        this.delegate = delegate;
    }

    void write(byte b[]) {
        try {
            delegate.write(b);
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }
}
