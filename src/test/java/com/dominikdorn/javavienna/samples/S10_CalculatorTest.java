package com.dominikdorn.javavienna.samples;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.dominikdorn.javavienna.multilang.samples.Calculator;
import com.dominikdorn.javavienna.multilang.samples.s10x_call_functions.S101_JSCalculator;
import com.dominikdorn.javavienna.multilang.samples.s10x_call_functions.S102_PyCalculator;
import com.dominikdorn.javavienna.multilang.samples.s10x_call_functions.S103_RubyCalculator;
import org.junit.jupiter.api.Test;

public class S10_CalculatorTest {


  void testCalculator(Calculator calculator) {
    assertEquals(8, calculator.add(5, 3));
    assertEquals(2, calculator.subtract(5, 3));
    assertEquals(15, calculator.multiply(5, 3));
    assertEquals(2, calculator.divide(6, 3));
  }


  @Test
  void testJavascriptCalculator() throws Exception {
    try (var calc = new S101_JSCalculator()) {
      testCalculator(calc);
    }
  }

  @Test
  void testPythonCalculator() throws Exception {
    try (var calc = new S102_PyCalculator()) {
      testCalculator(calc);
    }
  }

  @Test
  void testRubyCalculator() throws Exception {
    try ( var calc = new S103_RubyCalculator()) {
      testCalculator(calc);
    }
  }

  // no wasm calculator - lack of time

}
