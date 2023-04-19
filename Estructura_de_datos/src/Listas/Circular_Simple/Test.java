package Listas.Circular_Simple;

import Listas.Persona;

public class Test {
    public static void main(String[] args) {
        Circular_Simple<Persona> Lista = new Circular_Simple<>();

        Lista.add(new Persona("0000", "Yordanis", "Tejeda", 20));
        Lista.add(new Persona("1111", "Rafael", "Hernandez", 22));
        Lista.add(new Persona("2222", "Elizabeth", "Gomez", 21));
        Lista.add(new Persona("3333", "Miguel", "Baez", 19));
        Lista.add(new Persona("4444", "Juan", "Sanchez", 20));


        for (Persona P : Lista) {
            System.out.println(P);
        }

        Lista.mostrar_estructura();
        System.out.println("Mostrando indicadores del primero y del último");

        System.out.println("\nAgregando en la primera posición");
        Lista.add(new Persona("5555", "Ernesto", "Fernandez", 21), 0);
        Lista.mostrar_estructura();
        System.out.println("\nMostrando indicadores del primero y del último");

        System.out.println("\nAgregando en la última posición, como último, último");
        Lista.add(new Persona("6666", "Javier", "Perez", 22), 6);
        Lista.mostrar_estructura();
        System.out.println("\nMostrando indicadores del primero y del último");

        System.out.println("\nAgregando en cualquier otra posición");
        Lista.add(new Persona("7777", "Daniel", "Ferro", 20), 4);
        Lista.mostrar_estructura();
        System.out.println("\nMostrando indicadores del primero y del último");

        System.out.println("\nEliminando la primera posición");
        Lista.remove(0);
        Lista.mostrar_estructura();
        System.out.println("\nMostrando indicadores del primero y del último");

        System.out.println("\nEliminando la última posición");
        Lista.remove(6);
        Lista.mostrar_estructura();
        System.out.println("\nMostrando indicadores del primero y del último");

        System.out.println("\nEliminando cualquier otra posición");
        Lista.remove(4);
        Lista.mostrar_estructura();
        System.out.println("\nMostrando indicadores del primero y del último");
    }
}
