package controllers;

import java.util.EmptyStackException;
import models.NodeGeneric;

public class ColaG<T> {

    private NodeGeneric<T> primero;
    private NodeGeneric<T> ultimo;
    private int size;

    public ColaG() {
        this.primero = null;
        this.ultimo = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return primero == null;
    }

    public void add(T valor) {
        NodeGeneric<T> nuevo = new NodeGeneric<T>(valor);
        if (isEmpty()) {
            primero = nuevo;
            ultimo = nuevo;
        } else {
            ultimo.setNext(nuevo);
            ultimo = nuevo;
        }
        size++;
    }

    public T remove() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        T valor = primero.getValue();
        primero = primero.getNext();
        if (primero == null) {
            ultimo = null;
        }
        size--;
        return valor;
    }

    public T peek() {
        if (isEmpty())
            throw new EmptyStackException();
        return primero.getValue();
    }

    public int size() {
        return size;
    }

    public void printCola() {
        if (isEmpty()) {
            System.out.println("La cola está vacía.");
            return;
        }
        NodeGeneric<T> current = primero;
        while (current != null) {
            System.out.print(current.getValue() + " ");
            current = current.getNext();
        }

        System.out.println();

        
    }
    public int findByName(String name) {
        int posicion = 0;
        NodeGeneric<T> node = primero;
        while (node != null) {
            if (node.getValue().toString().equals(name)) {
                return posicion;
            }
            node = node.getNext();
            posicion++;
        }
        return -1;
    }
    public void removeByName(String name) {
        if (isEmpty())
            throw new EmptyStackException();
        if (primero.getValue().toString().equals(name)) {
            primero = primero.getNext();
            if (primero == null) {
                ultimo = null;
            }
            size--;
            return;
        }
        NodeGeneric<T> actual = primero;
        NodeGeneric<T> anterior = null;
        while (actual != null && !actual.getValue().toString().equals(name)) {
            anterior = actual;
            actual = actual.getNext();
        }
        if (actual != null) {
            anterior.setNext(actual.getNext());
            if (actual == ultimo) {
                ultimo = anterior;
            }
            size--;
        }    
    }
}