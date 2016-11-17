package com.seanshubin.hello.web;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

class HttpServletRequestTransformer {
    static RequestValue transformRequest(HttpServletRequest httpServletRequest) {
        String method = httpServletRequest.getMethod();
        String uriString = httpServletRequest.getRequestURI();
        String query = httpServletRequest.getQueryString();
        Enumeration headerNames = httpServletRequest.getHeaderNames();
        List<Header> headers = new ArrayList<>();
        while (headerNames.hasMoreElements()) {
            String name = (String) headerNames.nextElement();
            String value = httpServletRequest.getHeader(name);
            Header header = new Header(name, value);
            headers.add(header);
        }
        RequestValue request = new RequestValue(method, uriString, query, headers);
        return request;
    }
}
