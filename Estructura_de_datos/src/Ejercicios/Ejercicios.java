/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */
package Ejercicios;

import Cola.Cola;
import Cola.Cola_enlazada;
import Listas.Simple_Enlazada.Simple_Enlazada;
import Pilas.Pila;
import Pilas.Pila_Enlazada;

public class Ejercicios {

    /**
     * El objetivo del método es dado una cantidad de dinero devolver cuantos billetes de cada tipo hizo falta para pagarle siempre y cuando esta cantidad sea menor o igual a 42, en caso de que sea mayor retorna un mensaje informando que no se puede pagar la cifra
     *
     * @param cant_a_sacar la cantidad de dinero que se quiere sacar
     * @return mensaje que indica la cantidad de billetes necesarios o respuesta de que no se pudo pagar
     */
    public static String sacar_billete(int cant_a_sacar) {

        if (cant_a_sacar <= 42) { // Según el ejercicio solo se tiene para dar hasta 42 pesos

            Pila_Enlazada<Integer> cinco = new Pila_Enlazada<>(), tres = new Pila_Enlazada<>(), un_peso = new Pila_Enlazada<>();

            for (int i = 0; i < 4; i++) { // Es hasta 4 porque la pila debe tener 4 billetes de 5, es como lo dice en el ejercicio
                cinco.push(5);
            }

            for (int i = 0; i < 5; i++) { // Es hasta 5 porque la pila debe tener 5 billetes de 3, es como lo dice en el ejercicio
                tres.push(3);
            }

            for (int i = 0; i < 7; i++) { // Es hasta 7 porque la pila debe tener 7 billetes de 1, es como lo dice en el ejercicio
                un_peso.push(1);
            }

            int cant_billetes_cinco = 0, cant_billetes_tres = 0, cant_billetes_uno = 0; // Acumuladores de los tipos de billetes

            while (cant_a_sacar >= 5 && !cinco.isEmpty()) {
                cant_a_sacar -= cinco.pop(); // Saco de la pila un billete
                cant_billetes_cinco++; // Lo voy aumentando en cada iteración
            }

            while (cant_a_sacar >= 3 && !tres.isEmpty()) {
                cant_a_sacar -= tres.pop(); // Saco de la pila un billete
                cant_billetes_tres++; // Lo voy aumentando en cada iteración
            }

            /* Al final simplemente saco la cantidad de billetes equivalente al dinero que me queda por sacar
               esto se puede hacer porque es una relación de 1 a 1 */
            for (int i = 0; i < cant_a_sacar; i++) {
                un_peso.pop(); // Saco de la pila un billete
            }
            // Al final retorno un mensaje con lo que acumularon los contadores
            return "Billete(s) de 5: " + cant_billetes_cinco + "\nBillete(s) de 3: " + cant_billetes_tres + "\nBillete(s) 1: " + cant_a_sacar;
        } else {
            return "No hay para esa cantidad"; // Si se pasa de 42, simplemente no se le da nada porque no alcanzaría
        }
    }

    /**
     * Este método comprueba si una palabra o frase es un palíndromo
     *
     * @param palabra o frase que se desea comprobar si es un palíndromo
     * @return boolean true si es palíndromo, false en caso contrario
     */
    public static boolean isPalindrome(String palabra) { // Revisar


        return false;
    }

    public static Pila_Enlazada<Integer> eliminar_dublicados(Pila_Enlazada<Integer> P1, Pila_Enlazada<Integer> P2) {
        Simple_Enlazada<Integer> Lista = new Simple_Enlazada<>(), L = new Simple_Enlazada<>();

        while (!P1.isEmpty()) {
            Lista.add(P1.pop());
        }
        while (!P2.isEmpty()) {
            Lista.add(P2.pop());
        }

        boolean b;
        do {
            b = false;


        } while (!b);

        /*for (int i = 0; i < Lista.size(); i++) {
            if (!L.contains(Lista.get(i))) {
                L.add(Lista.get(i));
            }
        }*/

        /*Pila_Enlazada<Integer> P = new Pila_Enlazada<>();
        while (!L.isEmpty()) {
            P.push(L.remove(0));
        }*/

        while (!Lista.isEmpty()) {
            P1.push(Lista.remove(0));
        }
        return P1;
    }

    public static void invertir_pila(Pila_Enlazada<Integer> P) {
        if (P.isEmpty())
            return;

        int valor = P.pop();
        invertir_pila(P);
        agregar(P, valor);
    }

    public static void agregar(Pila_Enlazada<Integer> Pila, int elemento) {
        if (!Pila.isEmpty()) {
            int valor = Pila.pop();
            agregar(Pila, elemento);
            Pila.push(valor);
        } else {
            Pila.push(elemento);
        }
    }


    public static Pila_Enlazada<Integer> devolver_impares(Pila_Enlazada<Integer> Pila) {
        Pila_Enlazada<Integer> impares = new Pila_Enlazada<>();
        while (!Pila.isEmpty()) {
            int valor_actual = Pila.pop();
            if (valor_actual % 2 != 0)
                impares.push(valor_actual);
        }
        return impares;
    }

    public static int llenar_asientos(Cola_enlazada<Integer> Cola, int cant_asientos) {
        int cant_clientes = 0;
        while (!Cola.isEmpty() && cant_asientos - Cola.peek() >= 0) {
            cant_asientos -= Cola.poll();
            cant_clientes++;
        }
        return cant_clientes;
    }

    public static boolean es_sombrero(Pila_Enlazada<Integer> P1, Pila_Enlazada<Integer> P2) {
        if (P1.size() <= P2.size()) {
            while (!P1.isEmpty()) {
                if (P1.pop() != P2.pop()) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public void tiempo_Espera(Cola_enlazada<String> Cola) {
        while (!Cola.isEmpty()) {
            System.out.println("El cliente " + Cola.peek() + " demora " + Cola.poll().length() + " segundos");
        }
    }

    public static Pila_Enlazada<Integer> insertar_Elemento(Pila_Enlazada<Integer> Pila, int nuevo, int pos) {
        if (pos >= 0 && pos < Pila.size()) {
            Pila_Enlazada<Integer> P1 = new Pila_Enlazada<>();
            int size = Pila.size();
            for (int i = 0; i < size; i++) {
                if (i == pos) {
                    P1.push(nuevo);
                }
                P1.push(Pila.pop());
            }
            while (!P1.isEmpty()) {
                Pila.push(P1.pop());
            }
            return Pila;
        }
        throw new IndexOutOfBoundsException("Index out of bounds");
    }

    public static Cola_enlazada<Integer> adicionar(Cola_enlazada<Integer> Cola, int nuevo, int pos) {
        if (pos >= 0 && pos < Cola.size()) {
            for (int i = 0; i < Cola.size(); i++) {
                Cola.add(i == pos ? nuevo : Cola.poll());
            }
            return Cola;
        }
        throw new IndexOutOfBoundsException("Index out of the range");
    }

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

    public static Pila_Enlazada<String> invertir_Pila(Pila_Enlazada<String> Pila) {
        Pila_Enlazada<String> P1 = new Pila_Enlazada<>();
        while (!Pila.isEmpty()) {
            P1.push(Pila.pop());
        }
        return P1;
    }

    public static Pila_Enlazada<String> unir_Pila(Pila_Enlazada<String> Pila, Cola_enlazada<String> Cola) {
        while (!Cola.isEmpty()) {
            Pila.push(Cola.poll());
        }
        return Pila;
    }

    public static Cola_enlazada<String> unir_Cola(Pila_Enlazada<String> Pila, Cola_enlazada<String> Cola) {
        while (!Pila.isEmpty()) {
            Cola.add(Pila.pop());
        }
        return Cola;
    }

    public static void main(String[] args) {
        Pila_Enlazada<String> Pila = new Pila_Enlazada<>();
        Cola_enlazada<String> Cola = new Cola_enlazada<String>();

        Pila.push("Yordanis");
        Pila.push("Ana");
        Pila.push("Alberto");
        Pila.push("Juan");

        Cola.add("Lazaro");
        Cola.add("Sergio");
        Cola.add("Laura");
        Cola.add("Ernesto");

        Cola = unir_Cola(Pila, Cola);

        for (String valor : Cola) {
            System.out.println(valor);
        }


    }
}
