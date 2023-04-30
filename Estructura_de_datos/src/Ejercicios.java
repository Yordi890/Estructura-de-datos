/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

import Ejercicios.PuntoEmbarque.Equipaje;
import Ejercicios.PuntoEmbarque.Punto_Embarque_Equipajes;
import Listas.Simple_Enlazada.Simple_Enlazada;
import Pilas.Cola;

public class Ejercicios {

    /**
     * El objetivo del método es dado una cantidad de dinero devolver cuantos billetes
     * de cada tipo hizo falta para pagarle siempre y cuando esta cantidad sea menor o igual
     * a 42, en caso de que sea mayor retorna un mensaje informando que no se puede pagar la cifra
     *
     * @param cant_a_sacar la cantidad de dinero que se quiere sacar
     * @return mensaje que indica la cantidad de billetes necesarios o respuesta de que no se pudo pagar
     */
    public static String sacar_billete(int cant_a_sacar) {

        if (cant_a_sacar <= 42) { // Según el ejercicio solo se tiene para dar hasta 42 pesos

            Cola<Integer> cinco = new Cola<>(), tres = new Cola<>(), un_peso = new Cola<>();

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

    /**
     * Este método comprueba si una palabra o frase es un palíndromo
     *
     * @param palabra o frase que se desea comprobar si es un palíndromo
     * @return boolean true si es palíndromo, false en caso contrario
     */
    public static boolean isPalindrome(String palabra) {
        /*
         * Solo no interesan las letras no los espacios
         */
        palabra.replace(" ", "");
        palabra.replace('á', 'a');
        palabra.replace('é', 'e');
        palabra.replace('í', 'i');
        palabra.replace('ó', 'o');
        palabra.replace('ú', 'u');

        for (int i = 0, j = palabra.length() - 1; i < (palabra.length() - 1) / 2; i++, j--) {
            if (!(palabra.substring(i, i + 1).equalsIgnoreCase(palabra.substring(j, j + 1)))) {
                return false;
            }
        }
        return true;
    }

    public static Simple_Enlazada<Integer> invertir_Lista(Simple_Enlazada<Integer> Lista) {
        Cola<Integer> Pila = new Cola<>(); // La pila que usaremos para invertir la lista

        int size = Lista.size(); // Se debe guardar la cantidad de elementos porque nos ayudará más adelante

        for (int i = 0; i < size; i++) {
            Pila.push(Lista.remove(0));
            /*
             * El objetivo de guardar la cantidad de elementos de la lista en una variable
             * es porque cuando se empiece a usar el método remove la lista comenzará a disminuir
             * la cantidad de elementos lo que haría que no se eliminaría todos los elementos
             */
        }

        for (int i = 0; i < size; i++) {
            Lista.add(Pila.pop());
        }

        return Lista;
    }

    public static void main(String[] args) {

        System.out.println(sacar_billete(27));
        System.out.println(isPalindrome("Hola") ? "Es palíndromo" : "No es palíndromo");

        Simple_Enlazada<Integer> Lista = new Simple_Enlazada<>();
        Lista.add(4);
        Lista.add(6);
        Lista.add(2);
        Lista.add(8);
        Lista.add(10);
        Lista.add(1);

        Lista = invertir_Lista(Lista);

        Lista.forEach(System.out::println);
    }
}
