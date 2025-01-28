package com.dominikdorn.javavienna.multilang;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringEntryPoint {


  public static ApplicationContext buildCtx() {

    var ctx = new
            AnnotationConfigApplicationContext(
                "com.dominikdorn.javavienna.multilang.samples"
        );

    return ctx;
  }
}
