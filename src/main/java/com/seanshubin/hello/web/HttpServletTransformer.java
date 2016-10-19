package com.seanshubin.hello.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HttpServletTransformer {
    public static Request transformRequest(HttpServletRequest httpServletRequest) {
        String command = httpServletRequest.getPathInfo().substring(1);
        String target = httpServletRequest.getQueryString().split("=")[1];
        Request request = new Request(command, target);
        return request;
    }

    public static void transformResponse(String response, HttpServletResponse httpServletResponse) {
        UncheckedHttpServletResponse uncheckedHttpServletResponse = new UncheckedHttpServletResponse(httpServletResponse);
        httpServletResponse.setStatus(HttpServletResponse.SC_OK);
        httpServletResponse.setContentType("text/plain; charset=UTF-8");
        uncheckedHttpServletResponse.getWriter().println(response);
    }

    public static RequestValue transformRequestValue(HttpServletRequest httpServletRequest) {
        String method = httpServletRequest.getMethod();
        String uriString = httpServletRequest.getRequestURI();
        RequestValue request = new RequestValue(method, uriString);
        return request;
    }

    public static void transformResponseValue(ResponseValue response, HttpServletResponse httpServletResponse) {
        UncheckedHttpServletResponse uncheckedHttpServletResponse = new UncheckedHttpServletResponse(httpServletResponse);
        httpServletResponse.setStatus(response.statusCode);

        uncheckedHttpServletResponse.getWriter().println(response);
    }
}
