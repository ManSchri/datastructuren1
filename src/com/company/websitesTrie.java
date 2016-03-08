package com.company;

import java.io.*;

public class websitesTrie {

    node root = new node(' ');
    int errors = 0;
    nodeStack nodes = new nodeStack();
    char[] totalURL;

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
    public String search(node start, char[] url){
        node curNode = start;
        for(int i=0; i<url.length; i++){
            System.out.println("curnode: " + curNode.character);
            nodes.push(curNode);
            Integer nextNodeLoc = findCharLoc(curNode.branches, url[i]);
            if(nextNodeLoc != null){
                curNode = curNode.branches[nextNodeLoc];
            }
            /*else if(errors == 0) {
                errors++;
            }*/
            else {
                return searchClosestMatch(url);
            }
        }
        if(curNode.fullUrl!=null){
            return curNode.fullUrl;
        }
        else {
            return "not found";
        }
    }

    public String searchClosestMatch(char[] url){
        int index = nodes.numElements;
        node parent = nodes.pop();
        System.out.println("index: " + index);
        int i = 0;
        while(parent!=null && parent.branches[i]!=null){
            if(parent.branches[i].fullUrl!=null){
                return parent.branches[i].fullUrl;
            }
            char[] partUrl = new char[totalURL.length - index];
            System.arraycopy(url, index, partUrl, 0, partUrl.length);
            for (int j = 0; j < partUrl.length; j++) {
                System.out.println("parturl: " + partUrl[j]);
            }
            String found = search(parent.branches[i], partUrl);
            if(found==null) {
                i++;
            }
            else{
                return found;
            /*if(parent.branches[i].character==url[index]) {
                char[] partUrl = new char[url.length - index];
                System.arraycopy(url, index, partUrl, 0, partUrl.length);
                for (int j = 0; j < partUrl.length; j++) {
                    System.out.println(partUrl[j]);
                }
                return search(parent.branches[i], partUrl);*/
            }
        }
        return searchClosestMatch(url);
    }

}
