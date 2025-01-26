package com.dominikdorn.javavienna.multilang.samples.s10x_call_functions;

import com.dominikdorn.javavienna.multilang.samples.Calculator;
import org.graalvm.polyglot.Context;

public class S102_PyCalculator implements Calculator {

  Context context;

  public S102_PyCalculator() {
    context = Context.newBuilder("python").build();
  }

  @Override
  public int add(int a, int b) {
    return context.eval("python", "lambda x, y:  x + y").execute(a, b).asInt();
  }

  @Override
  public int subtract(int a, int b) {
    return context.eval("python", "lambda x, y: x - y").execute(a, b).asInt();
  }

  @Override
  public int multiply(int a, int b) {
    return context.eval("python", "lambda x, y: x * y").execute(a, b).asInt();
  }

  @Override
  public double divide(int a, int b) {
    return context.eval("python", "lambda x, y:  x / y").execute(a, b).asDouble();
  }

  @Override
  public void close() throws Exception {
    context.close();
  }
}
