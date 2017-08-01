package com.seanshubin.hello.web;

import org.junit.Test;

import javax.servlet.http.HttpServletResponse;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class AddHandlerTest {
    @Test
    public void addNumbers(){
        // given
        Handler addHandler = new AddHandler();
        String method = "GET";
        String path = "/add";
        String query = "left=2&right=3";
        List<Header> headers = Collections.emptyList();
        RequestValue request = new RequestValue(method, path, query, headers);

        // when
        ResponseValue response = addHandler.handle(request);

        // then
        assertThat(response.statusCode, is(HttpServletResponse.SC_OK));
        assertThat(response.body.toStringUtf8(), is("2 + 3 = 5"));
    }
}
