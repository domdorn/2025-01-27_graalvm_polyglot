package com.dominikdorn.javavienna.multilang.samples.s10x_call_functions;

import com.dominikdorn.javavienna.multilang.samples.Calculator;
import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.HostAccess.Export;
import org.graalvm.polyglot.Value;
import org.springframework.stereotype.Component;

@Component(value = "calculator")
public class S104_AdvancedJSCalculator implements Calculator {

  // language=javascript
  String program = """
      function add(a, b) { return a+b; }
      function sub(a, b) { return a-b; }
      function div(a, b) { return a/b; }
      function mul(a, b) { return a*b; }
      """;

  final Context ctx;
  final Value add;
  final Value sub;
  final Value div;
  final Value mul;

  public S104_AdvancedJSCalculator() {
    ctx = Context.newBuilder("js").build();;
    System.out.println("in Advanced JS Calculator");
    ctx.eval("js", program);
    add = ctx.getBindings("js").getMember("add");
    sub = ctx.getBindings("js").getMember("sub");
    div = ctx.getBindings("js").getMember("div");
    mul = ctx.getBindings("js").getMember("mul");
  }


  @Override
  @Export
  public int add(int a, int b) {
    return add.execute(a,b).asInt();
  }

  @Override
  @Export
  public int subtract(int a, int b) {
    return sub.execute(a,b).asInt();
  }

  @Override
  @Export
  public int multiply(int a, int b) {
    return mul.execute(a,b).asInt();
  }

  @Override
  @Export
  public double divide(int a, int b) {
    return div.execute(a,b).asDouble();
  }

  @Override
  public void close() throws Exception {
    ctx.close();
  }
}
