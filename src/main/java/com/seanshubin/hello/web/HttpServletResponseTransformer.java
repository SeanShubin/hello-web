package com.seanshubin.hello.web;

import javax.servlet.http.HttpServletResponse;

public class HttpServletResponseTransformer {
    public static void transformResponse(ResponseValue response, HttpServletResponse httpServletResponse) {
        UncheckedHttpServletResponse uncheckedHttpServletResponse = new UncheckedHttpServletResponse(httpServletResponse);
        httpServletResponse.setStatus(response.statusCode);
        for (Header header : response.headers) {
            httpServletResponse.addHeader(header.name, header.value);
        }
        uncheckedHttpServletResponse.getOutputStream().write(response.body.bytes());
    }
}
