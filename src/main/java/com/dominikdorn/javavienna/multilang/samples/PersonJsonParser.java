package com.dominikdorn.javavienna.multilang.samples;

public interface PersonJsonParser extends AutoCloseable {

  Person parse(String json);



}
