package com.dominikdorn.javavienna.multilang.samples.s10x_call_functions;

import com.dominikdorn.javavienna.multilang.samples.Calculator;
import org.graalvm.polyglot.Context;

public class S103_RubyCalculator implements Calculator {

  final Context context;

  public S103_RubyCalculator() {
    context = Context.newBuilder("ruby").build();
  }

  @Override
  public int add(int a, int b) {
    return context.eval("ruby", "proc { |x,y| x+y }").execute(a , b).asInt();
  }

  @Override
  public int subtract(int a, int b) {
    return context.eval("ruby", "proc { |x,y| x-y }" ).execute(a, b).asInt();
  }

  @Override
  public int multiply(int a, int b) {
    return context.eval("ruby", "proc { |x,y| x*y }").execute(a, b).asInt();
  }

  @Override
  public double divide(int a, int b) {
    return context.eval("ruby", "proc { |x,y| x/y }").execute(a, b).asDouble();
  }

  @Override
  public void close() throws Exception {
    context.close();
  }
}
