package com.company;

import java.util.*;

/**
 * Created by Manon Schriever on 03-03-16.
 */
public class userInput {

    String url;

    userInput() {
        Scanner reader = new Scanner(System.in);
        System.out.println("Go to: ");
        url = reader.nextLine();
    }
}
