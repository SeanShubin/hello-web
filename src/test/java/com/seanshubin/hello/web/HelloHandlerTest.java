package com.seanshubin.hello.web;

import org.junit.Test;

import javax.servlet.http.HttpServletResponse;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class HelloHandlerTest {
    @Test
    public void sayHello() {
        // given
        Handler helloHandler = new HelloHandler();
        String method = "GET";
        String path = "/hello";
        String query = "target=foo";
        List<Header> headers = Collections.emptyList();
        RequestValue request = new RequestValue(method, path, query, headers);
        // when
        ResponseValue response = helloHandler.handle(request);
        // then
        assertThat(response.statusCode, is(HttpServletResponse.SC_OK));
        assertThat(response.body.toStringUtf8(), is("Hello, foo!"));
    }
}
