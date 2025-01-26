package com.dominikdorn.javavienna.multilang.samples.s01_randomnumber;

import org.graalvm.polyglot.*;

public class S001_JSRandomNumberGen implements RandomNumberGen {

  @Override
  public double getRandomNumber() {
    try (Context context = Context.create("js")) {
      Value result = context.eval("js", "Math.random()");
      return result.asDouble();
    }
  }
}
