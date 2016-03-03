package com.company;


public class websitesTrie {

    node root = new node(' ');

    public void addWord(String url){
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
        curNode.fullUrl = true;
    }

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

}
