package com.dominikdorn.javavienna.multilang.samples;

public interface Calculator extends AutoCloseable{
  int add(int a, int b);
  int subtract(int a, int b);
  int multiply(int a, int b);
  double divide(int a, int b);
}
