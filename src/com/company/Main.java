package com.company;

public class Main {

    public static void main(String[] args) {
        websitesTrie trie = new websitesTrie("URLs.txt");
        userInput input = new userInput();
        trie.totalURL = input.url.toCharArray();
        String foundUrl = trie.search(trie.root, input.url.toCharArray());
        System.out.println(foundUrl.toCharArray());

    }
}
