package controllers;

import java.util.EmptyStackException;

import models.Node;

public class Stack {
    private Node top;

    public Stack() {
        this.top = null;
    }

    public void push(int Value){
        Node newNode = new Node(Value);
        newNode.setNext(top);
        top = newNode;

    }
    public int pop(){
        if(isEmpty()){
            throw new EmptyStackException();
        }else{
            int value = top.getValue();
            top=top.getNext();
            return value;
        }
        

    }
    public boolean isEmpty(){
        return top==null;
    
    }
    public int peek(){
        if(isEmpty()){
            throw new EmptyStackException();
        }else{
            return top.getValue();
        }
    }

    public void printStack(){
        Node current = top;
        while(current != null){
            System.out.println(current.getValue());
            current = current.getNext();

        }
        System.out.println();
    }


    

    
    
}
