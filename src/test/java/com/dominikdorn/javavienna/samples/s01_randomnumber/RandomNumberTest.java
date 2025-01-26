package com.dominikdorn.javavienna.samples.s01_randomnumber;

import com.dominikdorn.javavienna.multilang.samples.s01_randomnumber.RandomNumberGen;
import com.dominikdorn.javavienna.multilang.samples.s01_randomnumber.S001_JSRandomNumberGen;
import com.dominikdorn.javavienna.multilang.samples.s01_randomnumber.S002_PyRandomNumberGen;
import com.dominikdorn.javavienna.multilang.samples.s01_randomnumber.S003_RubyRandomNumberGen;
import com.dominikdorn.javavienna.multilang.samples.s01_randomnumber.S004_WasmRandomNumberGen;
import com.dominikdorn.javavienna.multilang.samples.s01_randomnumber.S005_JavaRandomNumberGen;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RandomNumberTest {

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
