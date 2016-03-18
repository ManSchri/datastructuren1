package com.company;

public class Main {

  public static void main(String[] args) {
    Object typos;
    WebsitesTrie trie = new WebsitesTrie("URLs.txt");
    UserInput input = new UserInput();

    Object[][] foundUrls = trie.search(input.url);
    typos = foundUrls[0][1];

    if (foundUrls[0][0] == null) {
      System.out.println("No results found");
    }

    // no typos
    else if ((int) typos == 0) {
      System.out.println("Result found!");
    }

    // return first five results from the sorted array
    else {
      System.out.println("Did you mean: ");
      for (int i = 0; i < 5; i++) {

        if (foundUrls[i][0] == null) {
          break;
        } else {
          System.out.println(foundUrls[i][0]);
          System.out.println(foundUrls[i][1]);
        }
      }
    }
  }
}
