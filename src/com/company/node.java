package com.company;

public class node {
    char character;
    node[] branches;
    String fullUrl =  null;

    node(char letter){
        character = letter;
        branches = new node[300];
    }
}
