package controllers;

import java.util.EmptyStackException;

import models.Node;


public class Cola {
    private Node primero;
    private Node ultimo;
    public int size;
    
    public Cola() {
        this.primero = null;
        this.ultimo = null;
        this.size=0;
    }


    public void add(int value){
        Node newnode= new Node(value);
        if(isEmpty()){
            primero = newnode;
            ultimo=newnode;
        }else{
            ultimo.setNext(newnode);
            ultimo = newnode;

        }
        size++;
        

    }
    public int remove(){
        if(isEmpty()){
            throw new EmptyStackException();

        }else{
            int value = primero.getValue();
            primero.getNext();
            size--;
            return value;

        }
    }

    public int peek(){
        if(isEmpty()){
            throw new EmptyStackException();
        }
        int value = primero.getValue();
        return value;
    }


    public Boolean isEmpty(){
        return primero==null;

    }

    public int size() {  
        return size;
    }
    public void printCola() {
    Node actual = primero;
    while (actual != null) {
        System.out.println(actual.getValue()); 
        actual = actual.getNext();
    }
    }

}
