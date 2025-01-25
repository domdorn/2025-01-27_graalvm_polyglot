package com.dominikdorn.javavienna.multilang;

import com.dominikdorn.javavienna.multilang.samples.javascript.ExecuteJavascriptSample;
import java.util.Scanner;

public class SelectorApp {

  public static void main(String[] args) {
    System.out.println("Welcome Java Vienna Community!");

    Scanner scanner = new Scanner(System.in);

    while (true) {
      System.out.println("Please choose your sample!");
      System.out.println("01 - Get a random number from Javascript");
      System.out.println("exit - Exit the program");

      String input = scanner.nextLine();
      switch (input) {
        case "01":
          ExecuteJavascriptSample.main(args);
          break;
        case "exit":
          System.out.println("bye bye");
          System.exit(0);
        default:
          System.out.println("Invalid input!");
          break;
      }

    }
  }
}
