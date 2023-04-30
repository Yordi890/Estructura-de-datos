/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package Ejercicios.PuntoEmbarque;

import Cola.Cola_enlazada;

public class Punto_Embarque_Equipajes {
    private Cola_enlazada<Equipaje>[] punto_E;

    public Punto_Embarque_Equipajes() {
        this.punto_E = new Cola_enlazada[]{new Cola_enlazada<Equipaje>(), new Cola_enlazada<Equipaje>(), new Cola_enlazada<Equipaje>()};
    }

    public void add(Equipaje E, int estera) {
        switch (estera) {
            case 0 -> punto_E[0].add(E);
            case 1 -> punto_E[1].add(E);
            case 2 -> punto_E[2].add(E);
            default ->
                    throw new UnsupportedOperationException("La estera en la que desea agregar un equipaje no existe");
        }
    }

    public Equipaje ver(int estera) {
        return switch (estera) {
            case 0 -> punto_E[0].peek();
            case 1 -> punto_E[1].peek();
            case 2 -> punto_E[2].peek();
            default -> throw new UnsupportedOperationException("La estera de la que desea ver su equipaje no existe");
        };
    }

    public Equipaje sacar(int estera) {
        return switch (estera) {
            case 0 -> punto_E[0].poll();
            case 1 -> punto_E[1].poll();
            case 2 -> punto_E[2].poll();
            default ->
                    throw new UnsupportedOperationException("La estera en la que desea agregar un equipaje no existe");
        };
    }

    private int hallar_menor() {
        double menor = Double.MAX_VALUE; // Solo un número muy grande (esto es una manera de hallar el menor)
        int pos_menor = -1;
        for (int i = 0; i < 3; i++) {
            if (!punto_E[i].isEmpty() && punto_E[i].peek().getPeso() < menor) {
                menor = punto_E[i].peek().getPeso();
                pos_menor = i;
            }
        }
        return pos_menor; // Al final devuelvo la posición de la estera que tiene el menor peso
    }

    public int llenar_Carro(double peso) {
        int cant_equipajes = 0, pos_menor;
        // El while funcionará mientras al menos una estera aún siga teniendo elementos y todavía tenga peso por subir al avión
        while (peso > 0 && (!punto_E[0].isEmpty() || !punto_E[1].isEmpty() || !punto_E[2].isEmpty())) { // Matemática Discreta
            pos_menor = hallar_menor(); // Este método devolverá la estera que tiene el menor peso
            if (pos_menor != -1) {
                if (peso - punto_E[pos_menor].peek().getPeso() >= 0) { // Porque si al restarlo da un número negativo se pasaría de peso
                    peso -= punto_E[pos_menor].poll().getPeso(); // Voy restando al peso el elemento que saque
                    cant_equipajes++; // Al mismo tiempo voy aumentando la cantidad de equipajes que subí al avión
                } else {
                    break; // Si se pasa es que ya no se puede subir más equipaje y entonces rompo el ciclo del while
                }
            }
        }
        return cant_equipajes; // Al final retorno la cantidad de equipajes que subí
    }

}
