package com.seanshubin.hello.web;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

class UncheckedHttpServletResponse {
    final HttpServletResponse delegate;

    UncheckedHttpServletResponse(HttpServletResponse delegate) {
        this.delegate = delegate;
    }

    UncheckedServletOutputStream getOutputStream() {
        try {
            return new UncheckedServletOutputStream(delegate.getOutputStream());
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }
}
