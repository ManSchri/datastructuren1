package com.company;

public class node {
    char character;
    node[] branches;
    boolean fullUrl;

    node(char letter){
        character = letter;
        branches = new node[300];
    }
}
