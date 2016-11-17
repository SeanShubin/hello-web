package com.seanshubin.hello.web;

import org.junit.Test;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class HttpServletResponseTransformerTest {
    @Test
    public void transformTypicalResponse() {
        //given
        List<Header> headers = Header.createHeaders("Content-Type", "text/plain; charset=UTF-8");

        ResponseValue responseValue = new ResponseValue(HttpServletResponse.SC_OK, ArrayOfBytes.fromStringUtf8("body"), headers);
        StubResponse stubResponse = new StubResponse();
        //when
        HttpServletResponseTransformer.transformResponse(responseValue, stubResponse);

        //then
        assertThat(stubResponse.lastStatus, equalTo(HttpServletResponse.SC_OK));
        assertThat(new String(stubResponse.byteArrayOutputStream.toByteArray(), StandardCharsets.UTF_8), equalTo("body"));
    }

    private class StubResponse extends HttpServletResponseNotImplemented {
        int lastStatus = -1;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        List<Header> headers = new ArrayList<>();

        @Override
        public void setStatus(int sc) {
            lastStatus = sc;
        }

        @Override
        public ServletOutputStream getOutputStream() throws IOException {
            return new ServletOutputStream() {
                @Override
                public void write(int b) throws IOException {
                    byteArrayOutputStream.write(b);
                }
            };
        }

        @Override
        public void addHeader(String name, String value) {
            headers.add(new Header(name, value));
        }
    }
}
