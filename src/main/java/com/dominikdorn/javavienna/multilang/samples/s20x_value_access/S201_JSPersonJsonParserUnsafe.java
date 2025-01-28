package com.dominikdorn.javavienna.multilang.samples.s20x_value_access;

import com.dominikdorn.javavienna.multilang.samples.Person;
import com.dominikdorn.javavienna.multilang.samples.PersonJsonParser;
import org.graalvm.polyglot.Context;

public class S201_JSPersonJsonParserUnsafe implements PersonJsonParser {

  final Context context;

  public S201_JSPersonJsonParserUnsafe() {
    context = Context.newBuilder("js")

        .build();
  }

  @Override
  public Person parse(String json) {
    // unsafe! don't do this at work!
    var result = context.eval("js", "(" + json + ")");
    var name = result.getMember("name").asString();
    var age = result.getMember("age").asInt();
    return new Person(name, age);
  }

  @Override
  public void close() throws Exception {
    context.close();
  }
}
