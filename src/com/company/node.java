package com.company;

public class node {
    char character;
    node[] branches;
    String fullUrl;

    node(char letter){
        character = letter;
        branches = new node[300];
        fullUrl = null;
    }
}
