package com.company;

import java.util.Scanner;

// creates the interface and lets the user type in an URL

public class UserInput {

  String url;

  UserInput() {
    Scanner reader = new Scanner(System.in);
    System.out.println("Go to: ");
    url = reader.nextLine();
  }
}
