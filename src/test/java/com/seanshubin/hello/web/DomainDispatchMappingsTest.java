package com.seanshubin.hello.web;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class DomainDispatchMappingsTest {
    DispatchMappings dispatchMappings = new DomainDispatchMappings();

    @Test
    public void dispatchMappingsUsingCorrectImplementations() {
        assertThat(implementationFor("/hello"), is("HelloHandler"));
        assertThat(implementationFor("/add"), is("AddHandler"));
    }

    String implementationFor(String path) {
        return dispatchMappings.lookupByPath(path).get().getClass().getSimpleName();
    }
}
