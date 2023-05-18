package Listas.Simple_Enlazada;

import Listas.Circular_Doble.Circular_Doble;
import Listas.Circular_Simple.Circular_Simple;
import Listas.Doble_Enlazada.Doble_Enlazada;
import Listas.Persona;

import java.util.LinkedList;


/**
 * @author Yordanis Tejeda Rodríguez
 */
public class Test {

    public static void main(String[] args) {

        Simple_Enlazada<Integer> Lista = new Simple_Enlazada<>();
        LinkedList<Integer> L = new LinkedList<>();
        L.stream().parallel();
        Lista.add(20);
        Lista.add(12);
        Lista.add(65);
        Lista.add(8);
        Lista.mostrar_estructura();
        System.out.println();

        Lista.forEach(System.out::println);
        /*
        // Casos de prueba para el método add normal
        Lista.add(new Persona("0000", "Yordanis", "Tejeda", 20));
        Lista.add(new Persona("1111", "Rafael", "Hernandez", 22));
        Lista.add(new Persona("2222", "Elizabeth", "Gomez", 21));
        Lista.add(new Persona("3333", "Miguel", "Baez", 19));
        Lista.add(new Persona("4444", "Juan", "Sanchez", 20));

        for (Persona P : Lista) {
            System.out.println(P);
        }


        Lista.mostrar_estructura();
        System.out.println("\nMostrando indicadores del primero y del último");

        // Casos de prueba para el método add en determinada posición
        System.out.println("\nAgregando en la primera posición");
        Lista.add(new Persona("5555", "Ernesto", "Fernandez", 21), 0);
        Lista.mostrar_estructura();
        System.out.println("\nMostrando indicadores del primero y del último");

        System.out.println("\nAgregando en la última posición, como último, último");
        Lista.add(new Persona("6666", "Javier", "Perez", 22), 6);
        Lista.mostrar_estructura();
        System.out.println("\nMostrando indicadores del primero y del último");

        System.out.println("\nAgregando en cualquier otra posición");
        Lista.add(new Persona("7777", "Alberto", "Portales", 20), 3);
        Lista.mostrar_estructura();
        System.out.println("\nMostrando indicadores del primero y del último");

        // Casos de prueba para el método remove
        System.out.println("Eliminando la primera posición");
        Lista.remove(0);
        Lista.mostrar_estructura();
        System.out.println("\nMostrando indicadores del primero y del último");

        System.out.println("\nEliminando en cualquier otra posición");
        Lista.remove(3);
        Lista.mostrar_estructura();
        System.out.println("\nMostrando indicadores del primero y del último");

        System.out.println("\nEliminando en la última posición");
        Lista.remove(5);
        Lista.mostrar_estructura();
        System.out.println("\nMostrando indicadores del primero y del último");

         */

    }
}
