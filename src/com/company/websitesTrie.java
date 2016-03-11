package com.company;

import java.io.*;

public class WebsitesTrie {

    Node root = new Node(' ');
    int maxErrors = 3;
    Object[][] results = new Object[1000][2];

    // Read file and put it in the trie
    WebsitesTrie(String file){
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
        Node curNode = root;
        for(int i=0; i<url.length(); i++){
            Integer charLoc = findCharLoc(curNode.branches, url.charAt(i));
            if(charLoc==null){
                int place = findEmptySpot(curNode.branches);
                curNode.branches[place] = new Node(url.charAt(i));
                curNode = curNode.branches[place];
            }
            else{
                curNode = curNode.branches[charLoc];
            }
        }
        curNode.fullUrl = url;
    }

    // find the child with the right character
    public Integer findCharLoc(Node[] branches, char character){
        int i = 0;
        while(branches[i]!=null){
            if(branches[i].character == character){
                return i;
            }
            i++;
        }
        return null;
    }

    // find an empty spot in an one dimensional array
    public int findEmptySpot(Object[] list){
        int i = 0;
        while(true){
            if(list[i]==null){
                break;
            }
            i++;
        }
        return i;
    }

    // find the next empty spot in a 2D array
    public int findEmptySpot(Object[][] list){
        int i = 0;
        while(true){
            if(list[i][0]==null){
                break;
            }
            i++;
        }
        return i;
    }

    // compute the minimum number from an array of integers
    public int min(Integer[] numbers){
        int min = 100;
        for(int i=0; i<numbers.length; i++){
            if(numbers[i]<min){
                min = numbers[i];
            }
        }
        return min;
    }

// search function uses the Levenshtein distance
    public Object[][] search(String url){

        // The first row in a levenshtein table is {0,1,2,...}
        Integer[] firstRow = new Integer[url.length()+1];
        for(int i=0; i<url.length()+1; i++){
            firstRow[i] = i;
        }

        // Search each trie branch
        for(Node child : root.branches){
            if(child==null){
                break;
            }
            recursiveSearch(child, root, url, firstRow);
        }

        for(int i=1; i<results.length; i++){
            if(results[i][0] == null){
                return results;
            }
            Object[] element = results[i];
            int j=i;
            while(j>0 && (int) results[j-1][1] > (int) element[1]){
                results[j]= results[j-1];
                j = j-1;
            }
            results[j] = element;
        }
        return results;

    }

    // recursively search for solutions
    public void recursiveSearch(Node node, Node formerNode, String url, Integer[] formerRow){

        int costInsert;
        int costDelete;
        int costReplace;
        int numColumns = formerRow.length;

        Integer[] newRow = new Integer[url.length()+1];
        newRow[0] = formerRow[0]+1;

        for(int i=1; i<numColumns; i++){

            // calculate the cost of each possible transformationj
            costInsert = newRow[i-1]+1;
            costDelete = formerRow[i] + 1;
            if(url.charAt(i-1) != node.character){
                if(i>2 && url.charAt(i-1)==formerNode.character && url.charAt(i-2)==node.character){
                    costReplace = formerRow[i-1];
                }
                else {
                    costReplace = formerRow[i - 1] + 1;
                }
            }
            else{
                costReplace = formerRow[i-1];
            }
            // keep the smallest cost
            int newCost = Math.min(costDelete, Math.min(costInsert, costReplace));
            int index = findEmptySpot(newRow);
            newRow[index] = newCost;
        }

        /* if the cost is smaller or equal to the maximum number of errors and the current node contains an url,
           that url is added to the list of results*/
        if(newRow[url.length()] <= maxErrors && node.fullUrl!=null){
            int freeSpot = findEmptySpot(results);
            results[freeSpot][0] = node.fullUrl;
            results[freeSpot][1] = newRow[url.length()];
        }

        /* if the smallest number of a row is smaller than or equal to the maximum number of errors,
           search each branch of the current node */
        if(min(newRow)<=maxErrors){
            for(Node child : node.branches){
                if(child==null){
                    break;
                }
                recursiveSearch(child, node, url, newRow);
            }
        }
    }

}
