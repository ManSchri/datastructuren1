package com.company;

import java.util.*;

public class userInput {

    String url;

    userInput() {
        Scanner reader = new Scanner(System.in);
        System.out.println("Go to: ");
        url = reader.nextLine();
    }
}
