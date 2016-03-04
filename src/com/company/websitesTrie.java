package com.company;

import java.io.*;

public class websitesTrie {

    node root = new node(' ');
    int errors = 0;

    // Read file and put it in the trie
    websitesTrie(String file){
        try{
            BufferedReader rd = new BufferedReader(new FileReader(file));
            String url;
            while(true){
                url = rd.readLine();
                if(url==null){
                    break;
                }
                addURL(url);
            }
        }
        catch(Exception ex){
            System.out.println("incorrect file");
        }
    }

    // add a URL to the trie
    public void addURL(String url){
        node curNode = root;
        for(int i=0; i<url.length(); i++){
            Integer charLoc = findCharLoc(curNode.branches, url.charAt(i));
            if(charLoc==null){
                int place = findEmptySpot(curNode.branches);
                curNode.branches[place] = new node(url.charAt(i));
                curNode = curNode.branches[place];
            }
            else{
                curNode = curNode.branches[charLoc];

            }
        }
        curNode.fullUrl = url;
    }

    // find the child with the right character
    public Integer findCharLoc(node[] branches, char character){
        int i = 0;
        while(branches[i]!=null){
            if(branches[i].character == character){
                return i;
            }
            i++;
        }
        return null;
    }

    // find the next empty spot to put the character in
    public int findEmptySpot(node[] list){
        int i = 0;
        while(true){
            if(list[i]==null){
                break;
            }
            i++;
        }
        return i;
    }

    // search the trie for an URL
    public boolean search(node start, String url){
        node curNode = start;
        for(int i=0; i<url.length(); i++){
            Integer nextNodeLoc = findCharLoc(curNode.branches, url.charAt(i));
            if(nextNodeLoc == null){
                return false;
            }
            else {
                curNode = curNode.branches[nextNodeLoc];
            }
        }
        if(curNode.fullUrl==url){
            return true;
        }
        return false;
    }
}
