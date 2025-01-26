package com.dominikdorn.javavienna.multilang.samples.s00x_randomnumber;

import com.dominikdorn.javavienna.multilang.samples.RandomNumberGen;
import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.Value;

public class S003_RubyRandomNumberGen implements RandomNumberGen {

  @Override
  public double getRandomNumber() {
    try (Context context = Context.create("ruby")) {
      Value result = context.eval("ruby", """
      rand
      """);
      return result.asDouble();
    }
  }
}
