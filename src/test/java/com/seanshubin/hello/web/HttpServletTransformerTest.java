package com.seanshubin.hello.web;

import org.junit.Test;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class HttpServletTransformerTest {
    @Test
    public void transformTypicalRequest() {
        List<NameValue> headers = createHeaders(
                "Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8",
                "Upgrade-Insecure-Requests", "1",
                "Connection", "keep-alive",
                "User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/53.0.2785.143 Safari/537.36",
                "Host", "localhost:8080",
                "Accept-Encoding", "gzip, deflate, sdch",
                "Accept-Language", "en-US,en;q=0.8");
        RequestValue requestValue = new RequestValue("GET", "/hello", "target=world", headers);
    }

    @Test
    public void transformFaviconRequest() {
        List<NameValue> headers = createHeaders(
                "Accept", "*/*",
                "Connection", "keep-alive",
                "User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/53.0.2785.143 Safari/537.36",
                "Referer", "http://localhost:8080/hello?target=world",
                "Host", "localhost:8080",
                "Accept-Encoding", "gzip, deflate, sdch",
                "Accept-Language", "en-US,en;q=0.8",
                "Upgrade-Insecure-Requests", "1");
        RequestValue requestValue = new RequestValue("GET", "/favicon.ico", null, headers);
    }

    private List<NameValue> createHeaders(String... namesAndValues) {
        List<NameValue> headers = new ArrayList<>();
        int index = 0;
        while (index < namesAndValues.length / 2) {
            String name = namesAndValues[index * 2];
            String value = namesAndValues[index * 2 + 1];
            NameValue nameValue = new NameValue(name, value);
            headers.add(nameValue);
        }
        return Collections.unmodifiableList(headers);
    }

    public class StubHttpServletRequest implements HttpServletResponse {
        @Override
        public void addCookie(Cookie cookie) {
            throw new UnsupportedOperationException("Not Implemented!");
        }

        @Override
        public boolean containsHeader(String s) {
            throw new UnsupportedOperationException("Not Implemented!");
        }

        @Override
        public String encodeURL(String s) {
            throw new UnsupportedOperationException("Not Implemented!");
        }

        @Override
        public String encodeRedirectURL(String s) {
            throw new UnsupportedOperationException("Not Implemented!");
        }

        @Override
        public String encodeUrl(String s) {
            throw new UnsupportedOperationException("Not Implemented!");
        }

        @Override
        public String encodeRedirectUrl(String s) {
            throw new UnsupportedOperationException("Not Implemented!");
        }

        @Override
        public void sendError(int i, String s) throws IOException {
            throw new UnsupportedOperationException("Not Implemented!");
        }

        @Override
        public void sendError(int i) throws IOException {
            throw new UnsupportedOperationException("Not Implemented!");
        }

        @Override
        public void sendRedirect(String s) throws IOException {
            throw new UnsupportedOperationException("Not Implemented!");
        }

        @Override
        public void setDateHeader(String s, long l) {
            throw new UnsupportedOperationException("Not Implemented!");
        }

        @Override
        public void addDateHeader(String s, long l) {
            throw new UnsupportedOperationException("Not Implemented!");
        }

        @Override
        public void setHeader(String s, String s1) {
            throw new UnsupportedOperationException("Not Implemented!");
        }

        @Override
        public void addHeader(String s, String s1) {
            throw new UnsupportedOperationException("Not Implemented!");
        }

        @Override
        public void setIntHeader(String s, int i) {
            throw new UnsupportedOperationException("Not Implemented!");
        }

        @Override
        public void addIntHeader(String s, int i) {
            throw new UnsupportedOperationException("Not Implemented!");
        }

        @Override
        public void setStatus(int i) {
            throw new UnsupportedOperationException("Not Implemented!");
        }

        @Override
        public void setStatus(int i, String s) {
            throw new UnsupportedOperationException("Not Implemented!");
        }

        @Override
        public String getCharacterEncoding() {
            throw new UnsupportedOperationException("Not Implemented!");
        }

        @Override
        public String getContentType() {
            throw new UnsupportedOperationException("Not Implemented!");
        }

        @Override
        public ServletOutputStream getOutputStream() throws IOException {
            throw new UnsupportedOperationException("Not Implemented!");
        }

        @Override
        public PrintWriter getWriter() throws IOException {
            throw new UnsupportedOperationException("Not Implemented!");
        }

        @Override
        public void setCharacterEncoding(String s) {
            throw new UnsupportedOperationException("Not Implemented!");
        }

        @Override
        public void setContentLength(int i) {
            throw new UnsupportedOperationException("Not Implemented!");
        }

        @Override
        public void setContentType(String s) {
            throw new UnsupportedOperationException("Not Implemented!");
        }

        @Override
        public void setBufferSize(int i) {
            throw new UnsupportedOperationException("Not Implemented!");
        }

        @Override
        public int getBufferSize() {
            throw new UnsupportedOperationException("Not Implemented!");
        }

        @Override
        public void flushBuffer() throws IOException {
            throw new UnsupportedOperationException("Not Implemented!");
        }

        @Override
        public void resetBuffer() {
            throw new UnsupportedOperationException("Not Implemented!");
        }

        @Override
        public boolean isCommitted() {
            throw new UnsupportedOperationException("Not Implemented!");
        }

        @Override
        public void reset() {
            throw new UnsupportedOperationException("Not Implemented!");
        }

        @Override
        public void setLocale(Locale locale) {
            throw new UnsupportedOperationException("Not Implemented!");
        }

        @Override
        public Locale getLocale() {
            throw new UnsupportedOperationException("Not Implemented!");
        }
    }

}
