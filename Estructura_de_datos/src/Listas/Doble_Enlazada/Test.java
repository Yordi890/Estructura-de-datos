package Listas.Doble_Enlazada;

import Listas.Persona;

/**
 * @author Yordanis Tejeda Rodríguez
 */
public class Test {

    public static void main(String[] args) {

        Doble_Enlazada<Persona> Lista = new Doble_Enlazada<>();

        // Casos de prueba para el método add normal
        Lista.add(new Persona("0000", "Yordanis", "Tejeda", 20));
        Lista.add(new Persona("1111", "Rafael", "Hernandez", 22));
        Lista.add(new Persona("2222", "Elizabeth", "Gomez", 21));
        Lista.add(new Persona("3333", "Miguel", "Baez", 19));
        Lista.add(new Persona("4444", "Juan", "Sanchez", 20));

        Lista.add(new Persona("5555", "Ernesto", "Fernandez", 21), 3);
        Lista.mostrar_estructura();
        /*
        for (Persona P : Lista) {
            System.out.println(P);
        }

        Lista.mostrar_estructura();
        System.out.println("\nMostrando indicadores del primero y el último");

        // Casos de prueba para el método add en
        System.out.println("\nAgregando en la primera posición");
        Lista.add(new Persona("5555", "Ernesto", "Fernandez", 21), 0);
        Lista.mostrar_estructura();
        System.out.println("\nMostrando indicadores del primero y el último");

        System.out.println("\nAgregando en la última posición, como último, último");
        Lista.add(new Persona("6666", "Javier", "Perez", 22), 6);
        Lista.mostrar_estructura();
        System.out.println("\nMostrando indicadores del primero y del último");

        System.out.println("\nAgregando como penúltimo");
        Lista.add(new Persona("7777", "Daniel", "Ferro", 20), 6);
        Lista.mostrar_estructura();
        System.out.println("\nMostrando indicadores del primero y del último");

        System.out.println("\nAgregando en cualquier otra posición");
        Lista.add(new Persona("8888", "Alberto", "Portales", 20), 3);
        Lista.mostrar_estructura();
        System.out.println("\nMostrando indicadores del primero y del último");

        // Casos de prueba para el método remove
        System.out.println("\nEliminando la primera posición");
        Lista.remove(0);
        Lista.mostrar_estructura();
        System.out.println("\nMostrando indicadores del primero y del último");

        System.out.println("\nEliminando la última posición");
        Lista.remove(7);
        Lista.mostrar_estructura();
        System.out.println("\nMostrando indicadores del primero y del último");

        System.out.println("\nEliminando cualquier otra posición");
        Lista.remove(4);
        Lista.mostrar_estructura();
        System.out.println("\nMostrando indicadores del primero y del último");
         */
    }
}
