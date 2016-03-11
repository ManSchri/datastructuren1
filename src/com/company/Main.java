package com.company;

public class Main {

    public static void main(String[] args) {
        WebsitesTrie trie = new WebsitesTrie("URLs.txt");
        UserInput input = new UserInput();
        Object[][] foundUrls = trie.search(input.url);
        if(foundUrls[0][0] == null){
            System.out.println("No results found");
        }
        //else if (trie.typos > 0){
            System.out.println("Did you mean: ");
            for (int i=0; i<foundUrls.length; i++) {
                if (foundUrls[i][0] == null) {
                    break;
                }
                System.out.println(foundUrls[i][0]);
                System.out.println(foundUrls[i][1]);
            }
       // }
       // else {
         //   System.out.println("Result found!");
       // }

    }
}
