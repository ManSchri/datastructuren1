package com.company;

/**
 * Nodes for the tree of the "Did you mean..." assignment.
 */

public class Node {
  char character;
  Node[] branches;
  String fullUrl;

  Node(char letter) {
    character = letter;
    branches = new Node[300];
    fullUrl = null;
  }
}
