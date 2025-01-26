package com.dominikdorn.javavienna.multilang.samples.s30x_value_passing;

import com.dominikdorn.javavienna.multilang.samples.Person;
import com.dominikdorn.javavienna.multilang.samples.PersonJsonParser;
import com.dominikdorn.javavienna.multilang.samples.PersonJsonSerializer;
import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.HostAccess;

public class S302_PythonPersonJsonParser implements PersonJsonParser, PersonJsonSerializer {

  final Context context;

  public S302_PythonPersonJsonParser() {
    context = Context.newBuilder("python")
        .allowAllAccess(true)
//        .allowHostAccess(HostAccess.SCOPED)
        .build();
  }

  @Override
  public Person parse(String json) {
    var binding = context.getBindings("python");
    binding.putMember("jsonString", json);
    var result = context.eval("python", """
        import json
        
        json.loads(jsonString)
        """);
    var map = result.as(java.util.Map.class);
    System.out.println("result = " + result);
    var name = (String) map.get("name");
    var age = (Integer) map.get("age");
    return new Person(name, age);
  }



  @Override
  public void close() throws Exception {
    context.close();
  }















  @Override
  public String toJson(Person person) {
    var binding = context.getBindings("python");
    binding.putMember("objToSerialize", person);
    var result = context.eval("python",
        // language=python
        """
        import json
        python_dict = {
         "name": objToSerialize.getName(),
         "age": objToSerialize.getAge()
        }
        
        json.dumps(python_dict)
        """);
    System.out.println("result = " + result);
    return result.asString();
  }

}
