

import controllers.Cola;
import controllers.ColaG;
import controllers.Stack;
import controllers.StackG;
import ejercicio_01_sing.SigValidator;
import ejercicio_02_sorting.StackSorter;
import models.Persona;

public class App {
    public static void main(String[] args) throws Exception {
        Stack stack = new Stack();
        stack.push(10);
        stack.push(-1);
        stack.push (0);
        stack.push(5);
        stack.printStack();
        stack.pop();
        stack.peek();
        stack.printStack();

        //Stack Generica
        System.out.println("\nStack Generica");

        StackG<Integer> stackG = new StackG<Integer>();
        stackG.push(1);
        stackG.push(4);
        stackG.printStack();

        StackG<String> stackG1 = new StackG<String>();
        stackG1.push("Uno");
        stackG1.push("Cuatro");
        stackG1.printStack();

        //FIFO  - PRIMERO EN ENTRAR, PRIMERO EN SALIR
        //Colas
        System.out.println("\nColas");

        // Cola no generica
        Cola cola = new Cola();
        cola.add(5);
        cola.add(7);
        cola.add(10);
        System.out.println("Tam = " + cola.size);
        cola.printCola();
        cola.remove();
        System.out.println("Tam = " + cola.size);
        cola.printCola();

        System.out.println("Peek: " + stack.peek());
        // Cola generica

        Persona p1 = new Persona("Pablo");
        Persona p2 = new Persona("Juan");
        Persona p3 = new Persona("Maria");

        System.out.println("\nCola Generica");

        ColaG<Persona> colaPersonas = new ColaG<Persona>();
        colaPersonas.add(p1);
        colaPersonas.add(p2);
        colaPersonas.add(p3);
        System.out.println("Tam = " + colaPersonas.size());
        colaPersonas.printCola();
        System.out.println("Atiende a la persona: " + colaPersonas.remove().getNombre());
        System.out.println("Tam = " + colaPersonas.size());
        colaPersonas.printCola();
        

        System.out.println("Maria esta en la posicion "+colaPersonas.findByName("Maria"));
        System.out.println("Elimina");
        colaPersonas.removeByName("David");
        colaPersonas.printCola();

        SigValidator validador = new SigValidator();
        String[] pruebas = {"([]){}", "({)}", "()[]{}", "(([]))", "(([]))["};

        System.out.println("Validación de signos:");
        for (String prueba : pruebas) {
            boolean resultado = validador.validar(prueba);
            System.out.println(prueba + " → " + resultado);
            validador.reiniciar(); 
        }

        // Ejercicio 2: Ordenar pila
        StackSorter sorter = new StackSorter();
        sorter.insertar(5);
        sorter.insertar(1);
        sorter.insertar(4);
        sorter.insertar(2);

        Stack resultadoOrdenado = sorter.ordenar();

        System.out.println("\n Pila ordenada (de menor a mayor):");
        resultadoOrdenado.printStack(); 
    }



}

