package com.dominikdorn.javavienna.multilang;

import com.dominikdorn.javavienna.multilang.samples.s10x_call_functions.S104_AdvancedJSCalculator;
import org.graalvm.polyglot.HostAccess;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringEntryPoint {


  @HostAccess.Export
  public static ApplicationContext buildCtx() {

    var ctx = new
            AnnotationConfigApplicationContext(
                "com.dominikdorn.javavienna.multilang.samples"
        );
    ctx.registerBean("calculator", S104_AdvancedJSCalculator.class);

    return ctx;
  }
}
