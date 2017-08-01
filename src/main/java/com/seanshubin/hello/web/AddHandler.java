package com.seanshubin.hello.web;

import javax.servlet.http.HttpServletResponse;

public class AddHandler implements AddHandlerMarker {
    @Override
    public ResponseValue handle(RequestValue request) {
        String leftString = request.singleQueryParameter("left");
        String rightString = request.singleQueryParameter("right");
        int left = Integer.parseInt(leftString);
        int right = Integer.parseInt(rightString);
        int sum = left + right;
        String resultString = String.format("%d + %d = %d", left, right, sum);
        return ResponseValue.plainTextUtf8(HttpServletResponse.SC_OK, resultString);
    }
}
