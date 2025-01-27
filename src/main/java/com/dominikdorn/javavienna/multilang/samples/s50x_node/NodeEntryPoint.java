package com.dominikdorn.javavienna.multilang.samples.s50x_node;

import com.dominikdorn.javavienna.multilang.samples.s10x_call_functions.S104_AdvancedJSCalculator;
import org.graalvm.polyglot.HostAccess;

public class NodeEntryPoint {

  @HostAccess.Export
  public static double runCalc(String op, Integer a, Integer b) {
    var calc = new S104_AdvancedJSCalculator();
    switch (op) {
      case "add":
        return calc.add(a, b);
      case "sub":
        return calc.subtract(a, b);
      case "mult":
        return calc.multiply(a, b);
      case "div":
        return calc.divide(a, b);
      default:
        throw new IllegalArgumentException("Unknown operation: " + op);
    }
  }

}
