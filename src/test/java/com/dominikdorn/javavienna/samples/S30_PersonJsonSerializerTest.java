package com.dominikdorn.javavienna.samples;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.dominikdorn.javavienna.multilang.samples.Person;
import com.dominikdorn.javavienna.multilang.samples.PersonJsonSerializer;
import com.dominikdorn.javavienna.multilang.samples.s30x_value_passing.S301_JSPersonJsonParser;
import com.dominikdorn.javavienna.multilang.samples.s30x_value_passing.S302_PythonPersonJsonParser;
import com.dominikdorn.javavienna.multilang.samples.s30x_value_passing.S303_RubyPersonJsonParser;
import org.junit.jupiter.api.Test;

public class S30_PersonJsonSerializerTest {

  Person testPerson = new Person("Dominik", 39);

  void testJson(PersonJsonSerializer serializer) {
    String expected = """
        {
        "name":"Dominik",
        "age":39
        }
        """;
    assertEquals(jsonSanitize(expected), jsonSanitize(serializer.toJson(testPerson)));
  }

  private String jsonSanitize(String json) {
    return json
        .replace(" ","")
        .replace("\r\n","")
        .replace("\n","")
        ;
  }

  @Test
  public void testJSPersonJsonSerializer() throws Exception {
    try (var p = new S301_JSPersonJsonParser()) {
      testJson(p);
    }
  }

  @Test
  public void testPythonPersonJsonSerializer() throws Exception {
    try (var p = new S302_PythonPersonJsonParser()) {
      testJson(p);
    }
  }

  @Test
  public void testRubyPersonJsonSerializer() throws Exception {
    try (var p = new S303_RubyPersonJsonParser()) {
      testJson(p);
    }
  }


}
