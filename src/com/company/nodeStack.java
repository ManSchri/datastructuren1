package com.company;

/**
 * Created by Manon Schriever on 04-03-16.
 */
public class nodeStack {
    node[] stack;
    int numElements;

    nodeStack(int size){
        numElements = size;
        stack = new node[size];
    }

    public node peek(){
        return stack[numElements];
    }

    public nodeStack pop(){
        nodeStack newie = new nodeStack(numElements-1);
        newie.stack[numElements]=null;
        return newie;
    }

    public nodeStack push(node element){
        nodeStack newie = new nodeStack(numElements+1);
        newie.stack[numElements+1]=element;
        return newie;
    }



}
