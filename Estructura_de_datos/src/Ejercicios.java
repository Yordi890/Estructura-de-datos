/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

import Pilas.Pila_enlazada;

public class Ejercicios {

    public static String sacar_billete(int cant_a_sacar) {

        if (cant_a_sacar <= 42) { // Según el ejercicio solo se tiene para dar hasta 42 pesos

            Pila_enlazada<Integer> cinco = new Pila_enlazada<>(), tres = new Pila_enlazada<>(), un_peso = new Pila_enlazada<>();

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
                /*
                  Mientras la cantidad a sacar todavía sea mayor a 5 y que todavía tenga billetes
                  de 5 en mi pila, le voy "pagando" y voy sacando los billetes de 5 que tengo en la
                  pila de billetes de 5 ...

                  *** Este mismo procedimiento se hace con los billetes de 3 y de 1
                 */
                cant_a_sacar -= cinco.pop();
                cant_billetes_cinco++; // Lo voy aumentando en cada iteración
            }

            while (cant_a_sacar >= 3 && !tres.isEmpty()) {
                cant_a_sacar -= tres.pop();
                cant_billetes_tres++; // Lo voy aumentando en cada iteración
            }

            while (cant_a_sacar >= 1 && !un_peso.isEmpty()) {
                cant_a_sacar -= un_peso.pop();
                cant_billetes_uno++; // Lo voy aumentando en cada iteración
            }
            // Al final retorno un mensaje con lo que acumuló los contadores
            return "Hizo falta " + cant_billetes_cinco + " billete(s) de 5, " + cant_billetes_tres + " billete(s) de 3 y " + cant_billetes_uno + " billete(s) de a peso";
        } else {
            return "No hay para esa cantidad"; // Si se pasa de 42, simplemente no se le da nada porque no alcanzaría
        }
    }

    public static void main(String[] args) {
        System.out.println(sacar_billete(27));
    }
}
