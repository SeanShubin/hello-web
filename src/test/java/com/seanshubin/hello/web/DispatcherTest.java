package com.seanshubin.hello.web;

import org.junit.Test;

import javax.servlet.http.HttpServletResponse;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class DispatcherTest {
    @Test
    public void invokeMatchingHandler() {
        //given
        DispatchMappingsStub dispatchMappings = new DispatchMappingsStub("foo", "bar");
        RequestValue request = makeRequest("foo");
        Handler dispatcher = new Dispatcher(dispatchMappings);
        //when
        ResponseValue actual = dispatcher.handle(request);
        //then
        ResponseValue expected = ResponseValue.plainTextUtf8(HttpServletResponse.SC_OK, "foo response");
        assertThat(actual, equalTo(expected));
    }

    private RequestValue makeRequest(String command) {
        String method = "GET";
        String path = "/" + command;
        String query = null;
        List<Header> headers = Collections.emptyList();
        RequestValue requestValue = new RequestValue(method, path, query, headers);
        return requestValue;
    }

    private Handler createSampleHandler(String bodyText) {
        return request -> ResponseValue.plainTextUtf8(200, bodyText + " response");
    }

    class DispatchMappingsStub implements DispatchMappings {
        private final Map<String, Handler> map = new HashMap<>();

        public DispatchMappingsStub(String... handlerNames) {
            for (String handlerName : handlerNames) {
                map.put("/" + handlerName, createSampleHandler(handlerName));
            }
        }

        @Override
        public Handler lookupByPath(String path) {
            return map.get(path);
        }
    }
}
