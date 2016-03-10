package com.company;

public class Main {

    public static void main(String[] args) {
        WebsitesTrie trie = new WebsitesTrie("URLs.txt");
        UserInput input = new UserInput();
        String[] foundUrls = trie.search(input.url);
        if(foundUrls[0] == null){
            System.out.println("No results found");
        }
        else {
            System.out.println("Did you mean: ");
            for (String url : foundUrls) {
                if (url == null) {
                    break;
                }
                System.out.println(url);
            }
        }

    }
}
