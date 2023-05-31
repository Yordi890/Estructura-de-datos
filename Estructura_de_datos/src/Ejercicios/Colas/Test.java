/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package Ejercicios.Colas;

import Cola.Cola_enlazada;
import Cola.Nodo;

public class Test {

    public static int encontrar_menor(Cola_enlazada<Integer> Cola) {
        int menor = Integer.MAX_VALUE, valor_actual;
        for (int i = 0; i < Cola.size(); i++) {
            valor_actual = Cola.poll(); // Saco el elemento de la cola
            if (valor_actual < menor) {// Hago la comparación
                menor = valor_actual;// Si es menor pasa a ser mi menor
            }
            Cola.add(valor_actual); // Lo vuelvo a agregar a la cola
        }
        return menor; // Al final retorno quien fue el menor
    }

    public static int encontrar_mayor(Cola_enlazada<Integer> Cola) {
        int mayor = 0, valor_actual;
        for (int i = 0; i < Cola.size(); i++) {
            valor_actual = Cola.poll(); // Saco el elemento de la cola
            if (valor_actual > mayor) {// Hago la comparación
                mayor = valor_actual;// Si es mayor pasa a ser mi mayor
            }
            Cola.add(valor_actual); // Lo vuelvo a agregar a la cola
        }
        return mayor; // Al final retorno quien fue el mayor
    }

    public static int suma_hasta(Cola_enlazada<Integer> Cola, int n) {
        if (n >= 0 && n < Cola.size()) {
            int valor_actual, suma = 0;
            for (int i = 0; i <= n; i++) {
                suma += valor_actual = Cola.poll();
                Cola.add(valor_actual);
            }

            for (int i = 0; i < (Cola.size() - n - 1); i++) {
                Cola.add(Cola.poll());
            }

            return suma;
        }
        throw new IndexOutOfBoundsException("Index out of the range");
    }

    public static void main(String[] args) {
        Cola_enlazada<Integer> Cola = new Cola_enlazada<Integer>();

        Cola.add(3);
        Cola.add(8);
        Cola.add(2);
        Cola.add(9);

        /*System.out.println("El mayor es " + encontrar_mayor(Cola));
        System.out.println("El menor es " + encontrar_menor(Cola));*/
        System.out.println("La suma es " + suma_hasta(Cola, 4));

        Cola.forEach(System.out::println);
    }
}
