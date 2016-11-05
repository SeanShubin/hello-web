package com.seanshubin.hello.web;

import javax.servlet.ServletOutputStream;
import java.io.IOException;

public class UncheckedServletOutputStream {
    public final ServletOutputStream delegate;

    public UncheckedServletOutputStream(ServletOutputStream delegate) {
        this.delegate = delegate;
    }

    public void write(byte b[]) {
        try {
            delegate.write(b);
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }
}
