package com.company;

import java.io.*;

public class Main {

    public static void main(String[] args) {
        websitesTrie trie = new websitesTrie();
        try{
            BufferedReader rd = new BufferedReader(new FileReader("URLs.txt"));
            String url;
            while(true){
                url = rd.readLine();
                if(url==null){
                    break;
                }
                trie.addWord(url);
            }
        }
        catch(Exception ex){
            System.out.println("incorrect file");
        }

    }
}
