package com.dominikdorn.javavienna.multilang.samples.s30x_value_passing;

import com.dominikdorn.javavienna.multilang.samples.Person;
import com.dominikdorn.javavienna.multilang.samples.PersonJsonParser;
import com.dominikdorn.javavienna.multilang.samples.PersonJsonSerializer;
import org.graalvm.polyglot.Context;

public class S303_RubyPersonJsonParser implements PersonJsonParser, PersonJsonSerializer {

  final Context context;

  public S303_RubyPersonJsonParser() {
    context = Context.newBuilder("ruby")
        .allowAllAccess(true)
        .build();
  }


  @Override
  public Person parse(String json) {
    var binding = context.getPolyglotBindings();
    binding.putMember("jsonString", json);
    var result = context.eval("ruby", """
        require 'json'
        
        jsonString = Polyglot.import('jsonString')
        
        JSON.parse(jsonString, object_class: OpenStruct)
        """);
    // rubys openstruct creates methods, not values
    var name =  result.getMember("name").execute().asString();
    var age = result.getMember("age").execute().asInt();
    return new Person(name, age);
  }

  @Override
  public void close() throws Exception {
    context.close();
  }

















@Override
public String toJson(Person person) {
    var binding = context.getPolyglotBindings();
    binding.putMember("objToSerialize", person);
    var result = context.eval("ruby",
        // language=ruby
        """
        require 'json'
        
        objToSerialize = Polyglot.import('objToSerialize')
        ruby_dict = {
         "name": objToSerialize["name"],
         "age": objToSerialize["age"]
        }
        
        JSON.generate(ruby_dict)
        """);
    System.out.println("result = " + result);
    return result.asString();
  }

}
