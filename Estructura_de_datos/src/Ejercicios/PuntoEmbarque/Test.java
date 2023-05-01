/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package Ejercicios.PuntoEmbarque;

public class Test {
    public static void main(String[] args) {

        Punto_Embarque_Equipajes P = new Punto_Embarque_Equipajes();

        P.add(new Equipaje("2222", 6), 1);
        P.add(new Equipaje("3333", 23), 1);
        P.add(new Equipaje("4444", 10), 2);
        P.add(new Equipaje("5555", 122), 2);

        System.out.println(P.check() ? "Se subieron " + P.llenar_Carro(40.00) + " equipajes" : "Las esteras están vacías");
    }
}
