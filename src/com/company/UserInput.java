package com.company;

import java.util.Scanner;

/**
 * Creates the interface and lets the user type in an URL for the
 * "Did you mean..." assignment.
 */

public class UserInput {

  String url;

  UserInput() {
    Scanner reader = new Scanner(System.in);
    System.out.println("Go to: ");
    url = reader.nextLine();
  }
}
