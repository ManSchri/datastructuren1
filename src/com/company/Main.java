package com.company;

public class Main {

    public static void main(String[] args) {
        websitesTrie trie = new websitesTrie("URLs.txt");
        userInput input = new userInput();
        String foundUrl = trie.search(trie.root, input.url);
        System.out.println(foundUrl);
    }
}
