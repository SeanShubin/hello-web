package com.seanshubin.hello.web;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UncheckedHttpServletResponse {
    public final HttpServletResponse delegate;

    public UncheckedHttpServletResponse(HttpServletResponse delegate) {
        this.delegate = delegate;
    }

    public UncheckedServletOutputStream getOutputStream() {
        try {
            return new UncheckedServletOutputStream(delegate.getOutputStream());
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }
}
