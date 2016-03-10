package com.company;

import java.util.*;

public class UserInput {

    String url;

    UserInput() {
        Scanner reader = new Scanner(System.in);
        System.out.println("Go to: ");
        url = reader.nextLine();
    }
}
