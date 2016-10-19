package com.seanshubin.hello.web;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class DispatcherTest {
    @Test
    public void sayHelloToWorld() {
        //given
        Request request = new Request("hello", "world");
        Handler dispatcher = new DispatchHandler();

        //when
        String response = dispatcher.handle(request);

        //then
        assertThat(response, equalTo("Hello, world!"));
    }

    @Test
    public void displayLength() {
        //given
        Request request = new Request("length", "world");
        Handler dispatcher = new DispatchHandler();

        //when
        String response = dispatcher.handle(request);

        //then
        assertThat(response, equalTo("length: 5"));
    }
}
