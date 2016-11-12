package com.seanshubin.hello.web;

import org.junit.Test;

import javax.servlet.http.HttpServletRequest;
import java.util.*;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class HttpServletRequestTransformerTest {
    @Test
    public void transformTypicalRequest() {
        //given
        List<Header> headers = createHeaders(
                "Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8",
                "Upgrade-Insecure-Requests", "1",
                "Connection", "keep-alive",
                "User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/53.0.2785.143 Safari/537.36",
                "Host", "localhost:8080",
                "Accept-Encoding", "gzip, deflate, sdch",
                "Accept-Language", "en-US,en;q=0.8");
        RequestValue expectedRequestValue = new RequestValue("GET", "/hello", "target=world", headers);
        HttpServletRequest request = new HttpServletRequestNotImplemented() {
            @Override
            public String getMethod() {
                return "GET";
            }

            @Override
            public String getRequestURI() {
                return "/hello";
            }

            @Override
            public String getQueryString() {
                return "target=world";
            }

            @Override
            public Enumeration getHeaderNames() {
                return Collections.enumeration(headers.stream().map(nameValue -> nameValue.name).collect(Collectors.toList()));
            }

            @Override
            public String getHeader(String name) {
                return headers.stream().filter(nameValue -> nameValue.name.equals(name)).findFirst().get().value;

            }
        };

        //when
        RequestValue actualRequestValue = HttpServletRequestTransformer.transformRequest(request);

        //then
        assertThat(actualRequestValue, equalTo(expectedRequestValue));

    }

    @Test
    public void transformFaviconRequest() {
        List<Header> headers = createHeaders(
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

    private List<Header> createHeaders(String... namesAndValues) {
        List<Header> headers = new ArrayList<>();
        int index = 0;
        while (index < namesAndValues.length / 2) {
            String name = namesAndValues[index * 2];
            String value = namesAndValues[index * 2 + 1];
            Header header = new Header(name, value);
            headers.add(header);
            index++;
        }
        return Collections.unmodifiableList(headers);
    }

    public Map<String, String> createMap(String... keysAndValues) {
        Map<String, String> result = new HashMap<>();
        int index = 0;
        while (index < keysAndValues.length / 2) {
            String key = keysAndValues[index * 2];
            String value = keysAndValues[index * 2 + 1];
            result.put(key, value);
        }
        return result;
    }
}
