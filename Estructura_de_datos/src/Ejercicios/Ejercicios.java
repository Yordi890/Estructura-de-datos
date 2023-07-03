/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */
package Ejercicios;

import Cola.Cola_enlazada;
import Listas.Simple_Enlazada.Simple_Enlazada;

public class Ejercicios {

    public static void invertir_Lista(Simple_Enlazada<Integer> Lista) {
        for (int i = 0; i < Lista.size(); i++) {
            Lista.add(Lista.remove(Lista.size() - 1), i);
        }

        /*
          Pila_Enlazada<Integer> Pila = new Pila_Enlazada<>(); // La pila que usaremos para invertir la lista

           for (int i = 0; i < size; i++) {
              Pila.push(Lista.remove(0));
           }

        while (!Pila.isEmpty()) {
            Lista.add(Pila.pop()); // Voy agregando a la lista que ya no contiene elemento lo que voy sacando de la pila y quedaría en orden inverso
        }*/
    }

    public static void main(String[] args) {
        // Pila_Enlazada<String> Pila = new Pila_Enlazada<>();
        Cola_enlazada<Integer> Cola = new Cola_enlazada<Integer>();

        Ejercicios E = new Ejercicios();
        /*Pila.push("Yordanis");
        Pila.push("Ana");
        Pila.push("Alberto");
        Pila.push("Juan");*/

        Cola.add(4);
        Cola.add(2);
        Cola.add(8);
        Cola.add(3);

        /*Cola = unir_Cola(Pila, Cola);

        for (String valor : Cola) {
            System.out.println(valor);
        }*/


    }
}
