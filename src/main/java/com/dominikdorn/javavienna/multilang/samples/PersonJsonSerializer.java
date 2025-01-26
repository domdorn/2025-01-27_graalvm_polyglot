package com.dominikdorn.javavienna.multilang.samples;

public interface PersonJsonSerializer extends AutoCloseable{
  String toJson(Person person);
}
