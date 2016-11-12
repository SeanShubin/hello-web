package com.seanshubin.hello.web;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;

public abstract class HttpServletResponseNotImplemented implements HttpServletResponse {
    @Override
    public void addCookie(Cookie cookie) {
        throw new UnsupportedOperationException("Not Implemented!");
    }

    @Override
    public boolean containsHeader(String name) {
        throw new UnsupportedOperationException("Not Implemented!");
    }

    @Override
    public String encodeURL(String url) {
        throw new UnsupportedOperationException("Not Implemented!");
    }

    @Override
    public String encodeRedirectURL(String url) {
        throw new UnsupportedOperationException("Not Implemented!");
    }

    /**
     * @param url the url to be encoded.
     * @return the encoded URL if encoding is needed;
     * the unchanged URL otherwise.
     * @deprecated As of version 2.1, use encodeURL(String url) instead
     */

    @Override
    public String encodeUrl(String url) {
        throw new UnsupportedOperationException("Not Implemented!");
    }

    /**
     * @param url the url to be encoded.
     * @return the encoded URL if encoding is needed;
     * the unchanged URL otherwise.
     * @deprecated As of version 2.1, use
     * encodeRedirectURL(String url) instead
     */

    @Override
    public String encodeRedirectUrl(String url) {
        throw new UnsupportedOperationException("Not Implemented!");
    }

    @Override
    public void sendError(int sc, String msg) throws IOException {
        throw new UnsupportedOperationException("Not Implemented!");
    }

    @Override
    public void sendError(int sc) throws IOException {
        throw new UnsupportedOperationException("Not Implemented!");
    }

    @Override
    public void sendRedirect(String location) throws IOException {
        throw new UnsupportedOperationException("Not Implemented!");
    }

    @Override
    public void setDateHeader(String name, long date) {
        throw new UnsupportedOperationException("Not Implemented!");
    }

    @Override
    public void addDateHeader(String name, long date) {
        throw new UnsupportedOperationException("Not Implemented!");
    }

    @Override
    public void setHeader(String name, String value) {
        throw new UnsupportedOperationException("Not Implemented!");
    }

    @Override
    public void addHeader(String name, String value) {
        throw new UnsupportedOperationException("Not Implemented!");
    }

    @Override
    public void setIntHeader(String name, int value) {
        throw new UnsupportedOperationException("Not Implemented!");
    }

    @Override
    public void addIntHeader(String name, int value) {
        throw new UnsupportedOperationException("Not Implemented!");
    }

    @Override
    public void setStatus(int sc) {
        throw new UnsupportedOperationException("Not Implemented!");
    }

    /**
     * @param sc the status code
     * @param sm the status message
     * @deprecated As of version 2.1, due to ambiguous meaning of the
     * message parameter. To set a status code
     * use <code>setStatus(int)</code>, to send an error with a description
     * use <code>sendError(int, String)</code>.
     * <p>
     * Sets the status code and message for this response.
     */

    @Override
    public void setStatus(int sc, String sm) {
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
    public void setCharacterEncoding(String charset) {
        throw new UnsupportedOperationException("Not Implemented!");
    }

    @Override
    public void setContentLength(int len) {
        throw new UnsupportedOperationException("Not Implemented!");
    }

    @Override
    public void setContentType(String type) {
        throw new UnsupportedOperationException("Not Implemented!");
    }

    @Override
    public void setBufferSize(int size) {
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
    public void setLocale(Locale loc) {
        throw new UnsupportedOperationException("Not Implemented!");
    }

    @Override
    public Locale getLocale() {
        throw new UnsupportedOperationException("Not Implemented!");
    }
}
