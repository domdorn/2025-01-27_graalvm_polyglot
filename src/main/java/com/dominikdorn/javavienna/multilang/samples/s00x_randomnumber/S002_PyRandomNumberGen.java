package com.dominikdorn.javavienna.multilang.samples.s00x_randomnumber;

import com.dominikdorn.javavienna.multilang.samples.RandomNumberGen;
import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.Value;

public class S002_PyRandomNumberGen implements RandomNumberGen {


  @Override
  public double getRandomNumber() {
    try (Context context = Context.create("python")) {

      Value result = context.eval("python",
      //language=python
      """
      import random
      
      random.random();
      """);
      return result.asDouble();
    }
  }
}
