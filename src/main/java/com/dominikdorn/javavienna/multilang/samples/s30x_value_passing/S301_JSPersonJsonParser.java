package com.dominikdorn.javavienna.multilang.samples.s30x_value_passing;

import com.dominikdorn.javavienna.multilang.samples.Person;
import com.dominikdorn.javavienna.multilang.samples.PersonJsonParser;
import com.dominikdorn.javavienna.multilang.samples.PersonJsonSerializer;
import org.graalvm.polyglot.Context;

public class S301_JSPersonJsonParser implements PersonJsonParser, PersonJsonSerializer {

  final Context context;

  public S301_JSPersonJsonParser() {
    context = Context.newBuilder("js")
//        .allowAllAccess(true)
        .build();
  }


  @Override
  public Person parse(String json) {
    var binding = context.getBindings("js");
    binding.putMember("jsonString", json);
    // right way
    var result = context.eval("js", """
        JSON.parse(jsonString)
        """);

//    var esult2 = context.eval("js",
//        "JSON.parse(" + json + ")"); // wrong way
    var name = result.getMember("name").asString();
    var age = result.getMember("age").asInt();
    return new Person(name, age);
  }


  @Override
  public void close() throws Exception {
    context.close();
  }


  @Override
  public String toJson(Person obj) {
    var bindings = context.getBindings("js");
    bindings.putMember("obj", obj); // Pass any Java object

    // language=javascript
    return context.eval("js", """
        (function(obj) {
            let result = {};
            let keys = Object.keys(obj);
        
            keys.forEach(key => {
                let value = obj[key];
        
                // Exclude non-field methods (anything returning a complex object)
                if (typeof value === 'function') {
                    try {
                        let returnValue = value.call(obj);
                        if (typeof returnValue !== 'object') { // Allow only primitive return types
                            result[key.replace(/^get/, "").toLowerCase()] = returnValue;
                        }
                    } catch (e) {
                        // Ignore methods that fail (e.g., toMap() or unsupported)
                    }
                } else {
                    result[key] = value;
                }
            });
        
            return JSON.stringify(result);
        })(obj);
        """).asString();
  }
}
