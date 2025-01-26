package com.dominikdorn.javavienna.multilang.samples;

import org.graalvm.polyglot.HostAccess;

public class Person {

  public final String name;
  public final int age;

  public Person(String name, int age) {
    this.name = name;
    this.age = age;
  }

  @HostAccess.Export
  public String getName() {
    return name;
  }

  @HostAccess.Export
  public int getAge() {
    return age;
  }

}