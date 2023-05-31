/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package Ejercicios.PuntoEmbarque;

import Cola.Cola_enlazada;
import Listas.Simple_Enlazada.Simple_Enlazada;

import java.util.ArrayList;

public class Punto_Embarque_Equipajes {
    private final Cola_enlazada<Equipaje>[] punto_E;
    int[] Arr = {12, 34, 66, 78};

    public Punto_Embarque_Equipajes() {
        this.punto_E = new Cola_enlazada[]{new Cola_enlazada<Equipaje>(), new Cola_enlazada<Equipaje>(), new Cola_enlazada<Equipaje>()};
    }

    public void add(Equipaje E, int estera) {
        switch (estera) { // Dependiendo de la estera agrego en la cola que corresponde el equipaje que se le pase como parámetro
            case 0 -> punto_E[0].add(E);
            case 1 -> punto_E[1].add(E);
            case 2 -> punto_E[2].add(E);
            default -> // En caso de que no sea ninguna de las esteras, lanzo una excepción
                    throw new UnsupportedOperationException("La estera en la que desea agregar un equipaje no existe");
        }
    }

    public Equipaje ver(int estera) {
        return switch (estera) { // Dependiendo de la estera muestro el elemento que le toca (recordar que son colas en un arreglo)
            case 0 -> punto_E[0].peek();
            case 1 -> punto_E[1].peek();
            case 2 -> punto_E[2].peek();
            default -> // En caso de que no sea ninguna de las esteras, lanzo una excepción
                    throw new UnsupportedOperationException("La estera de la que desea ver su equipaje no existe");
        };
    }

    public Equipaje sacar(int estera) {
        return switch (estera) { // Dependiendo de la estera saco el elemento que le toca (recordar que son colas en un arreglo)
            case 0 -> punto_E[0].poll();
            case 1 -> punto_E[1].poll();
            case 2 -> punto_E[2].poll();
            default -> // En caso de que no sea ninguna de las esteras, lanzo una excepción
                    throw new UnsupportedOperationException("La estera en la que desea agregar un equipaje no existe");
        };
    }

    /**
     * Devuelve la cantidad de equipajes necesarios para llenar el carro
     *
     * @param peso que soporta el carro y del cual no se puede sobrepasar
     * @return int que representa cantidad que fue necesaria para llenar el carro
     */
    public int llenar_Carro(double peso) {
        int cant_equipajes = 0, pos_menor;
        // El while funcionará mientras al menos una estera aún siga teniendo elementos y todavía tenga peso por subir al avión
        while (peso > 0 && check()) {
            pos_menor = hallar_menor(); // Este método devolverá la estera que tiene el menor peso
            if (peso - punto_E[pos_menor].peek().getPeso() >= 0) { // Porque el carrito no se puede sobrepasar de peso
                peso -= punto_E[pos_menor].poll().getPeso(); // Voy restando al peso el elemento que saqué
                cant_equipajes++; // Al mismo tiempo voy aumentando la cantidad de equipajes que subí al avión
            } else {
                break; // Si se pasa es que ya no se puede subir más equipaje y entonces rompo el ciclo del while
            }
        }
        return cant_equipajes; // Al final retorno la cantidad de equipajes que subí
    }

    public boolean check() { // Matemática Discreta
        return !punto_E[0].isEmpty() || !punto_E[1].isEmpty() || !punto_E[2].isEmpty(); // Si hay al menos una con elementos retornará true
    }

    private int hallar_menor() {
        double menor = Double.MAX_VALUE; // Solo un número muy grande (esto es una manera de hallar el menor)
        int pos_menor = -1; // Necesario inicializarla, pero siempre, siempre va a cambiar
        for (int i = 0; i < 3; i++) { // Hasta 3 porque son las posiciones del arreglo
            if (!punto_E[i].isEmpty() && punto_E[i].peek().getPeso() < menor) {
                menor = punto_E[i].peek().getPeso(); // Si se cumple la condición, mi menor va a hacer el valor del peso de peek en esa posición
                pos_menor = i; // Voy guardando la posición de la estera que es la menor
            }
        }
        return pos_menor; // Al final devuelvo la posición de la estera que tiene el menor peso
    }
}
