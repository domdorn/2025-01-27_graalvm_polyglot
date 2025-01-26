package com.dominikdorn.javavienna.multilang;

import com.dominikdorn.javavienna.multilang.samples.s01_randomnumber.RandomNumberGen;
import com.dominikdorn.javavienna.multilang.samples.s01_randomnumber.S001_JSRandomNumberGen;
import com.dominikdorn.javavienna.multilang.samples.s01_randomnumber.S002_PyRandomNumberGen;
import com.dominikdorn.javavienna.multilang.samples.s01_randomnumber.S003_RubyRandomNumberGen;
import java.util.Scanner;

public class SelectorApp {

  public static void main(String[] args) {
    System.out.println("Welcome Java Vienna Community!");

    Scanner scanner = new Scanner(System.in);

    while (true) {
      System.out.println("Please choose your sample!");
      System.out.println("01 - Get a random number from Javascript");
      System.out.println("02 - Get a random number from python");
      System.out.println("03 - Get a random number from ruby");

      System.out.println("exit - Exit the program");

      String input = scanner.nextLine();
      switch (input) {
        case "01": {
          RandomNumberGen gen = new S001_JSRandomNumberGen();
          System.out.println("Generated random number: " + gen.getRandomNumber());
          break;
        }
        case "02": {
          RandomNumberGen gen = new S002_PyRandomNumberGen();
          System.out.println("Generated random number: " + gen.getRandomNumber());
          break;
        }
        case "03": {
          RandomNumberGen gen = new S003_RubyRandomNumberGen();
          System.out.println("Generated random number: " + gen.getRandomNumber());
          break;
        }

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
