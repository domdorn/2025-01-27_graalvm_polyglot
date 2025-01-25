package com.dominikdorn.javavienna.multilang.samples.javascript;

import org.graalvm.polyglot.*;
import org.graalvm.polyglot.proxy.*;

public class ExecuteJavascriptSample {

  public static void main(String[] args) {
    try (Context context = Context.create("js")) {
      Value result = context.eval("js", "Math.random()");
      System.out.println("JavaScript Random Number: " + result.asDouble());
    }
  }
}
