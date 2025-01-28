package com.dominikdorn.javavienna.multilang.samples.s10x_call_functions;

import com.dominikdorn.javavienna.multilang.samples.Calculator;
import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.Value;

public class S101_JSCalculator implements Calculator {

  Context context;

  public S101_JSCalculator() {
    context = Context.newBuilder("js").build();
  }

  @Override
  public int add(int a, int b) {
    Value function = context.eval("js", " (a, b) => a + b");
    return function
        .execute(a,b)
        .asInt();
  }

  @Override
  public int subtract(int a, int b) {
    Value function = context.eval("js", " (a, b) => a - b");
    Value resultValue = function.execute(a, b);
    return resultValue.asInt();
  }

  @Override
  public int multiply(int a, int b) {
    Value function = context.eval("js", " (a, b) => a * b");
    Value resultValue = function.execute(a, b);
    return resultValue.asInt();
  }

  @Override
  public double divide(int a, int b) {
    Value function = context.eval("js", " (a, b) => a / b");
    Value resultValue = function.execute(a, b);
    return resultValue.asDouble();
  }

  @Override
  public void close() throws Exception {
    context.close();
  }
}
