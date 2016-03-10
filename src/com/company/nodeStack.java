package com.company;


/*
THIS CLASS IS NO LONGER NEEDED
SHOULD BE DELETED BEFORE HANDING IN!!!!!
 */

public class NodeStack {
    Node[] stack;
    int numElements;

    NodeStack(){
        numElements = 0;
        stack = new Node[10];
    }

    public Node peek(){
        return stack[numElements-1];
    }

    public Node pop(){
        if(numElements==0){
            return null;
        }
        numElements--;
        return stack[numElements];
    }

    public void push(Node element){
        if(numElements==stack.length){
            Node[] newStack = new Node[stack.length*2];
            System.arraycopy(stack, 0, newStack, 0, numElements);
            stack = newStack;
        }
        stack[numElements] = element;
        numElements++;
    }


}
