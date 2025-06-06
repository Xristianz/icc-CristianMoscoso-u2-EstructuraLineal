package ejercicio_02_sorting;

import controllers.Stack;

public class StackSorter {

    private Stack pila;

    public StackSorter() {
        this.pila = new Stack();
    }

    public void insertar(int valor) {
        pila.push(valor);
    }

    public Stack ordenar() {
        Stack auxiliar = new Stack();

        while (!pila.isEmpty()) {
            int temp = pila.pop();

            while (!auxiliar.isEmpty() && auxiliar.peek() > temp) {
                pila.push(auxiliar.pop());
            }

            auxiliar.push(temp);
        }

        return auxiliar;
    }
}

