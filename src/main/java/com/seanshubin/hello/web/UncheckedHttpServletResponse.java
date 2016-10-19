package com.seanshubin.hello.web;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class UncheckedHttpServletResponse {
    public final HttpServletResponse delegate;

    public UncheckedHttpServletResponse(HttpServletResponse delegate) {
        this.delegate = delegate;
    }

    public PrintWriter getWriter() {
        try {
            return delegate.getWriter();
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }
}
