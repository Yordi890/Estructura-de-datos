/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicios;

import Cola.Cola_enlazada;
import Pilas.Pila_Enlazada;

/**
 *
 * @author Yordi
 */
public class Controladora {

    public Pila_Enlazada<Integer> devolver_impares(Pila_Enlazada<Integer> pila) {

        Pila_Enlazada<Integer> P = new Pila_Enlazada<>();

        while (!pila.isEmpty()) {

            if (pila.top() % 2 == 0) {
                pila.pop();
            } else {
                P.push(pila.pop());
            }

        }

        return P;
    }

    public int llenar_asientos(Cola_enlazada<Integer> Cola, int cant_asientos) {

        int cant_clientes = 0;

        while (cant_asientos - Cola.peek() >= 0) {
            cant_asientos = cant_asientos - Cola.poll();
            cant_clientes++;
        }

        return cant_clientes;
    }

    public void tiempo_de_espera(Cola_enlazada<String> Cola) {

        while (!Cola.isEmpty()) {
            System.out.println("Para el cliente " + Cola.peek() + " se necesito " + Cola.poll().length());
        }

    }

}
