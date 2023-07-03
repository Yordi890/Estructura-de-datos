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
import Listas.Simple_Enlazada.Simple_Enlazada;
import Pilas.Pila_Enlazada;

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
                valor_actual = Cola.poll();
                suma += valor_actual;
                Cola.add(valor_actual);
            }

            for (int i = 0; i < (Cola.size() - n - 1); i++) {
                Cola.add(Cola.poll());
            }

            return suma;
        }
        throw new IndexOutOfBoundsException("Index out of the range");
    }

    public static int llenar_asientos(Cola_enlazada<Integer> Cola, int cant_asientos) {
        int cant_clientes = 0;
        while (!Cola.isEmpty() && cant_asientos - Cola.peek() >= 0) {
            cant_asientos -= Cola.poll();
            cant_clientes++;
        }
        return cant_clientes;
    }


    public static void tiempo_Espera(Cola_enlazada<String> Cola) {
        while (!Cola.isEmpty()) {
            System.out.println("El cliente " + Cola.peek() + " demora " + Cola.poll().length() + " segundos");
        }
    }

    public static Cola_enlazada<String> invertir_Cola(Cola_enlazada<String> Cola) {
        Pila_Enlazada<String> P1 = new Pila_Enlazada<>();
        while (!Cola.isEmpty()) {
            P1.push(Cola.poll());
        }
        while (!P1.isEmpty()) {
            Cola.add(P1.pop());
        }
        return Cola;
    }

    public static Cola_enlazada<String> unir_Cola(Pila_Enlazada<String> Pila, Cola_enlazada<String> Cola) {
        while (!Pila.isEmpty()) {
            Cola.add(Pila.pop());
        }
        return Cola;
    }

    public static Cola_enlazada<Integer> adicionar(Cola_enlazada<Integer> Cola, int nuevo, int pos) {
        if (pos >= 0 && pos < Cola.size()) {
            for (int i = 0; i < Cola.size(); i++) {
                if (i == pos) {
                    Cola.add(nuevo);
                } else {
                    Cola.add(Cola.poll());
                }
            }
            return Cola;
        }
        throw new IndexOutOfBoundsException("Index out of the range");
    }

    public static void ordenar_Cola(Cola_enlazada<Integer> Cola) {
        Simple_Enlazada<Integer> Lista = new Simple_Enlazada<>();

        while (!Cola.isEmpty()) {
            Lista.add(Cola.poll());
        }

        while (!Lista.isEmpty()) {
            int menor = Integer.MAX_VALUE, pos_menor = -1;

            for (int i = 0; i < Lista.size(); i++) {
                if (Lista.get(i) < menor) {
                    menor = Lista.get(i);
                    pos_menor = i;
                }
            }
            Cola.add(Lista.remove(pos_menor));
        }
    }

    public static void main(String[] args) {
        Cola_enlazada<Integer> Cola = new Cola_enlazada<Integer>();

        Cola.add(5);
        Cola.add(2);
        Cola.add(8);
        Cola.add(10);
        Cola.add(1);
        Cola.add(5);

        ordenar_Cola(Cola);
        Cola.forEach(System.out::println);
    }
}
