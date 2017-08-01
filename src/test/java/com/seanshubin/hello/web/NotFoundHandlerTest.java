package com.seanshubin.hello.web;

import org.junit.Test;

import javax.servlet.http.HttpServletResponse;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class NotFoundHandlerTest {
    @Test
    public void addNumbers() {
        // given
        Handler notFoundHandler = new NotFoundHandler();
        String method = "GET";
        String path = "/foo";
        String query = "bar";
        List<Header> headers = Collections.emptyList();
        RequestValue request = new RequestValue(method, path, query, headers);
        // when
        ResponseValue response = notFoundHandler.handle(request);
        // then
        assertThat(response.statusCode, is(HttpServletResponse.SC_NOT_FOUND));
        assertThat(response.body.toStringUtf8(), is("Unable to handle request at path '/foo'"));
    }
}
