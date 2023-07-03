/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */
package Ejercicios.Pilas;

import Cola.Cola_enlazada;
import Listas.Simple_Enlazada.Simple_Enlazada;
import Pilas.Pila_Enlazada;

public class Test {

    public static Pila_Enlazada<Integer> devolver_impares(Pila_Enlazada<Integer> Pila) {
        Pila_Enlazada<Integer> impares = new Pila_Enlazada<>();
        while (!Pila.isEmpty()) {
            if (Pila.top() % 2 != 0)
                impares.push(Pila.top());
            Pila.pop();
        }
        return impares;
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

    /**
     * Este método comprueba si una palabra o frase es un palíndromo
     *
     * @param palabra o frase que se desea comprobar si es un palíndromo
     * @return boolean true si es palíndromo, false en caso contrario
     */
    public static boolean isPalindrome(String palabra) { // Hola
        Pila_Enlazada<Character> Pila = new Pila_Enlazada<>();
        for (char letra : palabra.toCharArray()) {
            Pila.push(letra);
        }
        String palabra_invertida = "aloH";
        while (!Pila.isEmpty()) {
            palabra_invertida += Pila.pop();
        }
        if (!palabra.equalsIgnoreCase(palabra_invertida)) {
            return false;
        } else {
            return true;
        }
    }

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

    /**
     * @param P pila que se desea invertir
     */
    public static void invertir_pila(Pila_Enlazada<Integer> P) {
        if (P.isEmpty())
            return;

        int valor = P.pop();
        invertir_pila(P);
        agregar(P, valor);
    }

    /**/
    public static void agregar(Pila_Enlazada<Integer> Pila, int elemento) {
        if (!Pila.isEmpty()) {
            int valor = Pila.pop();
            agregar(Pila, elemento);
            Pila.push(valor);
        } else {
            Pila.push(elemento);
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

    public static Pila_Enlazada<Integer> invertir_Pila(Pila_Enlazada<Integer> Pila) {
        int size = Pila.size();
        if (Pila.isEmpty()) {
            return null;
        }
        int valor = Pila.pop();
        invertir_Pila(Pila);

        Pila_Enlazada<Integer> P1 = new Pila_Enlazada<>();
        agregar(P1, valor);
        invertir_Pila(P1);
        return P1;
    }

    public static Pila_Enlazada<String> unir_Pila(Pila_Enlazada<String> Pila, Cola_enlazada<String> Cola) {
        while (!Cola.isEmpty()) {
            Pila.push(Cola.poll());
        }
        return Pila;
    }

    public static boolean validar_parentesis(String ecuacion) {
        Pila_Enlazada<Character> Pila = new Pila_Enlazada<>();
        char[] parentesis = {'(', '[', '{', ')', ']', '}'};
        ecuacion = ecuacion.replaceAll("[\\d +-/*]", ""); // Remueve los números, los espacios en blanco y los números signos
        for_externo:
        for (char c : ecuacion.toCharArray()) {
            for (int i = 3; i < 6; i++) {
                if ((!Pila.isEmpty() && parentesis[i] == c) && (parentesis[i - 3] == Pila.top())) {
                    Pila.pop();
                    continue for_externo;
                }
            }
            Pila.push(c);
        }
        return Pila.isEmpty();
    }

    public static void main(String[] args) {

        System.out.println(validar_parentesis("{[(5+4 * 3 / 2) 4 - 3}"));
        String[] Arr = {"((3+2)*(5-1))/4", "{5+2*(3-4]}", "{4+4[10+(40*20)](8+12)}", "()",
                "(((5+4)+ 10) + [(5+2)) + (4*6)])", "{4+4[10+(40*20)](8+12)}",
                "((5+4)+(2*6))", "{({(})5+4))}", "{((}5+4))}", "{(({}))}", "{((}5+4))}",
                "(7)((5+4)+ 3)", "[[(5 + 5)]+ [9 +3]]", "{5+2*(3-4]}", "{({(5+4})}+ {3+5})",
                "{({(5+4)}+ {3+5})", "((5+4)}+ {3+5})", "((5+4)+(2*6))", "((3+2)*(5-1))/4"};

        System.out.println("Se evaluaran " + Arr.length + " ecuaciones");
        for (String ecuacion : Arr) {
            System.out.println(ecuacion + ": " + validar_parentesis(ecuacion));
        }
    }
}
