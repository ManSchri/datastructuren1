package com.company;

public class Main {

    public static void main(String[] args) {
        WebsitesTrie trie = new WebsitesTrie("URLs.txt");
        UserInput input = new UserInput();
        trie.totalURL = input.url.toCharArray();
        String foundUrl = trie.search(trie.root, input.url.toCharArray());
        System.out.println(foundUrl.toCharArray());

    }
}
