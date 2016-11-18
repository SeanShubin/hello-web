package com.seanshubin.hello.web;

import org.junit.Test;

import javax.servlet.http.HttpServletResponse;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class DispatcherTest {
    @Test
    public void sayHelloToWorld() {
        //given
        RequestValue request = makeRequest("hello", "world");
        Handler dispatcher = new Dispatcher();

        //when
        ResponseValue actual = dispatcher.handle(request);

        //then
        ResponseValue expected = ResponseValue.plainTextUtf8(HttpServletResponse.SC_OK, "Hello, world!");

        assertThat(actual, equalTo(expected));
    }

    @Test
    public void displayLength() {
        //given
        RequestValue request = makeRequest("length", "world");
        Handler dispatcher = new Dispatcher();

        //when
        ResponseValue actual = dispatcher.handle(request);

        //then
        ResponseValue expected = ResponseValue.plainTextUtf8(HttpServletResponse.SC_OK, "length: 5");
        assertThat(actual, equalTo(expected));
    }

    @Test
    public void unhandledRequest() {
        //given
        String method = "GET";
        String path = "/favicon.ico";
        String query = null;
        List<Header> headers = Collections.emptyList();
        RequestValue request = new RequestValue(method, path, query, headers);
        Handler dispatcher = new Dispatcher();

        //when
        ResponseValue actual = dispatcher.handle(request);

        //then

        ResponseValue expected = ResponseValue.plainTextUtf8(HttpServletResponse.SC_NOT_FOUND, "RequestValue{method='GET', path='/favicon.ico', query='null', headers=[]}");

        assertThat(actual, equalTo(expected));

    }

    private RequestValue makeRequest(String command, String target) {
        String method = "GET";
        String path = "/" + command;
        String query = String.format("target=%s", target);
        List<Header> headers = Collections.emptyList();
        RequestValue requestValue = new RequestValue(method, path, query, headers);
        return requestValue;
    }
}
