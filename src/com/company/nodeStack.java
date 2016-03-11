package com.company;


/*
THIS CLASS IS NO LONGER NEEDED
SHOULD BE DELETED BEFORE HANDING IN!!!!!
 */

/*public class nodeStack {
    node[] stack;
    int numElements;

    nodeStack(){
        numElements = 0;
        stack = new node[10];
    }

    public node peek(){
        return stack[numElements-1];
    }

    public node pop(){
        if(numElements==0){
            return null;
        }
        numElements--;
        return stack[numElements];
    }

    public void push(node element){
        if(numElements==stack.length){
            node[] newStack = new node[stack.length*2];
            System.arraycopy(stack, 0, newStack, 0, numElements);
            stack = newStack;
        }
        stack[numElements] = element;
        numElements++;
    }


}
*/