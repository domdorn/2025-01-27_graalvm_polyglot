package com.dominikdorn.javavienna.samples;

import static org.graalvm.wasm.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.dominikdorn.javavienna.multilang.samples.PersonJsonParser;
import com.dominikdorn.javavienna.multilang.samples.s20x_value_access.S201_JSPersonJsonParserUnsafe;
import com.dominikdorn.javavienna.multilang.samples.s30x_value_passing.S301_JSPersonJsonParser;
import com.dominikdorn.javavienna.multilang.samples.s30x_value_passing.S302_PythonPersonJsonParser;
import com.dominikdorn.javavienna.multilang.samples.s30x_value_passing.S303_RubyPersonJsonParser;
import org.junit.jupiter.api.Test;

public class S20_PersonJsonParserTest {


  String testPersonJson = """
      {
      "name": "Dominik",
      "age": 39
      }
      """;


  void testParsingWorks(PersonJsonParser parser) {
    var person = parser.parse(testPersonJson);
    assertEquals("Dominik", person.getName());
    assertEquals(39, person.getAge());
  }



  @Test
  void testJavascriptPersonParserUnsafe() throws Exception {
    try(var p = new S201_JSPersonJsonParserUnsafe()) {
      testParsingWorks(p);
    }
  }

  @Test
  void testJavascriptPersonParserSafe() throws Exception {
    try(var p = new S301_JSPersonJsonParser()) {
      testParsingWorks(p);
    }
  }

  @Test
  void testPythonPersonParser() throws Exception {
    try(var p = new S302_PythonPersonJsonParser()) {
      testParsingWorks(p);
    }
  }

  @Test
  void testRubyPersonParser() throws Exception {
    try(var p= new S303_RubyPersonJsonParser()) {
      testParsingWorks(p);
    }
  }

}
