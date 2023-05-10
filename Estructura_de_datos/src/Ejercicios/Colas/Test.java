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
        int menor = Integer.MAX_VALUE, size = Cola.size(), valor_actual;
        for (int i = 0; i < Cola.size(); i++) {
            Cola.add(valor_actual = Cola.poll());
            if (valor_actual < menor) {
                menor = valor_actual;
            }
        }
        return menor;
    }

    public static int encontrar_mayor(Cola_enlazada<Integer> Cola) {
        int mayor = Integer.MIN_VALUE, size = Cola.size(), valor_actual;
        for (int i = 0; i < size; i++) {
            Cola.add(valor_actual = Cola.poll());
            if (valor_actual > mayor) {
                mayor = valor_actual;
            }
        }
        return mayor;
    }

    public static int suma_hasta(Cola_enlazada<Integer> Cola, int n) {
        Nodo<Integer> cursor = Cola.getFirst();
        int suma = 0;
        for (int i = 0; i <= n; i++) {
            suma += cursor.getInfo();
            cursor = cursor.getNext();
        }
        return suma;
    }

    public static void main(String[] args) {
        Cola_enlazada<Integer> Cola = new Cola_enlazada<Integer>();

        Cola.add(3);
        Cola.add(8);
        Cola.add(2);
        Cola.add(9);

        //  System.out.println("El mayor es " + encontrar_mayor(Cola));
        //  System.out.println("El menor es " + encontrar_menor(Cola));
        System.out.println("La suma es " + suma_hasta(Cola, 2));

        Cola.forEach(System.out::println);
    }
}
