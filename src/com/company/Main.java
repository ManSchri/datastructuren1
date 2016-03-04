package com.company;

public class Main {

    public static void main(String[] args) {
        /*websitesTrie trie = new websitesTrie("URLs.txt");
        userInput input = new userInput();
        boolean foundUrl = trie.search(trie.root, input.url);
        System.out.println(foundUrl);*/
        node h = new node('h');
        node b = new node('b');
        node k = new node('k');
        nodeStack test = new nodeStack(1);
        nodeStack test2 = test.push(h);
        nodeStack test3 = test2.push(b);
        nodeStack test4 = test3.push(k);
        System.out.println(test4.peek().character);
        nodeStack test5 = test4.pop();
        System.out.println(test5.peek().character);

    }
}
