package com.dominikdorn.javavienna.multilang.samples.s40x_expose_functionality;

import java.util.Arrays;
import java.util.function.Function;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.Value;
import org.graalvm.polyglot.proxy.ProxyExecutable;

public class S401_ExposeJavaMethod {

  Function<Integer, Boolean> javaFilterEven = (Integer n) -> n % 2 == 0;

  private static final Logger log = Logger.getLogger(S401_ExposeJavaMethod.class.getName());


  ProxyExecutable logger = args -> {
    log.log(Level.SEVERE, "[Java] Received from js: " + Arrays.toString(
        Arrays.stream(args).map(v -> {
          if(v.isString()) {
            return v.asString();
          } else {
            return v.toString();
          }
        }).toArray()
    ));
    return null;
  };


  public <A> A runScript(String script, Class<A> clazz) throws Exception {
    try (Context ctx = Context.newBuilder("js").build()) {

      ctx.getBindings("js").putMember("javaLogger", logger);
      ctx.eval("js", "console.log = javaLogger");


      ctx.getBindings("js").putMember("javaEvenFilter",
          (ProxyExecutable) (args -> {
            int n = args[0].asInt();
            return javaFilterEven.apply(n);
          })
      );

      Value result = ctx.eval("js", script);

      return result.as(clazz);
    }
  }


}
