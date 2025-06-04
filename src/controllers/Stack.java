package controllers;

import java.util.EmptyStackException;
import models.Node;

public class Stack {
    //regla, ultimo en entrar, primero en eliminarse
    //stack es la estructura de datos, la caja
    private Node top; //va a ser el ultimo nodo
    private int size;

    public Stack(){
        this.top = null;
        this.size = 0;
    }

    //Metodo que ingrese un valor int
    public void push(int getValue){
        Node newNode = new Node(getValue);
        newNode.setNext(top);
        top = newNode; //el tope es el ultimo nodo ingresado
    }

    //pop retorna el elemento
    public int pop(){
        int value = top.getValue(); //se guarda el valor del nodo que se va a eliminar 
        top = top.getNext(); //elimina el elemento
        return value;
    }

    public boolean isEmpty(){
        return top == null;
    }

    public int peek(){
        if(isEmpty()){
            throw new EmptyStackException();
        }
        return top.getValue();
    }

    public void printStack(){
        Node current = top;
        while(current != null){
            System.out.println(current.getValue());
            current = current.getNext();
        }
    }

    public int size(){
        Node current = top;
        int cont=0;
        while(current != null){
            System.out.print(current.getValue());
            current = current.getNext();
            cont++;
        }
        return cont;
    }

}