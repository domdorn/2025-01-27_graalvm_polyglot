package com.dominikdorn.javavienna.samples;

import com.dominikdorn.javavienna.multilang.samples.RandomNumberGen;
import com.dominikdorn.javavienna.multilang.samples.s00x_randomnumber.S001_JSRandomNumberGen;
import com.dominikdorn.javavienna.multilang.samples.s00x_randomnumber.S002_PyRandomNumberGen;
import com.dominikdorn.javavienna.multilang.samples.s00x_randomnumber.S003_RubyRandomNumberGen;
import com.dominikdorn.javavienna.multilang.samples.s00x_randomnumber.S004_WasmRandomNumberGen;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class S00_RandomNumberGenTest {

  private void testRandomNumber(RandomNumberGen gen) {

    var number = gen.getRandomNumber();
    System.out.println("number is " + number);
    assertTrue(number > 0 && number < 1);
  }


  @Test
  public void shouldGenerateJavascriptRandomNumber() {
    RandomNumberGen gen = new S001_JSRandomNumberGen();
    testRandomNumber(gen);
  }

  @Test
  public void shouldGeneratePythonRandomNumber() {
    RandomNumberGen gen = new S002_PyRandomNumberGen();
    testRandomNumber(gen);
  }

  @Test
  public void shouldGenerateRubyRandomNumber() {
    RandomNumberGen gen = new S003_RubyRandomNumberGen();
    testRandomNumber(gen);
  }

  @Test
  public void shouldGenerateWasmRandomNumber() {
    RandomNumberGen gen = new S004_WasmRandomNumberGen();
    testRandomNumber(gen);
  }

}
