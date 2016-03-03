package com.company;

import java.io.*;

public class Main {

    public static void main(String[] args) {
        websitesTrie trie = new websitesTrie("URLs.txt");
        userInput input = new userInput();
        System.out.println(trie.contains(input.url));
    }
}
