package com.dominikdorn.javavienna.multilang.samples.s00x_randomnumber;

import com.dominikdorn.javavienna.multilang.samples.RandomNumberGen;
import org.graalvm.polyglot.*;

public class S001_JSRandomNumberGen implements RandomNumberGen {

  @Override
  public double getRandomNumber() {
    try (Context context = Context.create("js")) {
      Value result = context.eval("js",
          // language=javascript
          "Math.random()");
      return result.asDouble();
    }
  }
}
