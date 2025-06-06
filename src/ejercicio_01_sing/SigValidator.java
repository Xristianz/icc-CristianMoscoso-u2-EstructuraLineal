package ejercicio_01_sing;

import controllers.Stack;

public class SigValidator {

    private Stack pila;

    public SigValidator() {
        this.pila = new Stack();
    }

    public boolean validar(String cadena) {
        for (int i = 0; i < cadena.length(); i++) {
            char c = cadena.charAt(i);

            if (c == '(' || c == '[' || c == '{') {
                pila.push(c); 
            } else {
                if (pila.isEmpty()) return false;

                char tope = (char) pila.pop();

                if ((c == ')' && tope != '(') ||
                    (c == ']' && tope != '[') ||
                    (c == '}' && tope != '{')) {
                    return false;
                }
            }
        }
        return pila.isEmpty();
    }

    public void reiniciar() {
        this.pila = new Stack();
    }
}