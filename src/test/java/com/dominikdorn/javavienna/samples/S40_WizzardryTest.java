package com.dominikdorn.javavienna.samples;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.dominikdorn.javavienna.multilang.samples.s40x_expose_functionality.S401_ExposeJavaMethod;
import java.util.List;
import org.graalvm.polyglot.Value;
import org.junit.jupiter.api.Test;

public class S40_WizzardryTest {


  @Test
  void testConsoleLog() throws Exception {

    var script = """
        
        console.log("hello world");
        
        console.log("this is great");

        "bla"
        """;

    var x = new S401_ExposeJavaMethod();
    String returnValue = x.<String>runScript(script, String.class);
    assertEquals("bla", returnValue);
  }


  @Test
  void testFilter() throws Exception {
    // language=javascript
    var script = """
        
        let data = [1,2,3,4,5];

        let filtered = data.filter( (f, idx, arr) => javaEvenFilter(f));
        console.log("even elements are", filtered);
        
        filtered
        """;
    var x =new S401_ExposeJavaMethod();
    Integer[] evenValues = x.runScript(script, Integer[].class);

    assertEquals(List.of(new Integer[]{2,4}), List.of(evenValues));
  }

}
