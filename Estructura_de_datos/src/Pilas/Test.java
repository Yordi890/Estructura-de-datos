package Pilas;

/**
 * @author Yordanis Tejeda Rodríguez
 */
public class Test {

    public static void main(String[] args) {
        Pila_Enlazada<Integer> Pila = new Pila_Enlazada<>();

        // Casos de prueba para el método push
        Pila.push(4);
        Pila.push(8);
        Pila.push(2);
        Pila.push(6);
        Pila.mostrar_estructura();

        for (Integer T : Pila) {
            System.out.println(T);
        }

        // Casos de prueba para el método top y pop
        System.out.println("\nMostrando el tope " + Pila.top());

        System.out.println("\nEliminando " + Pila.pop());
        System.out.println("Mostrando el tope " + Pila.top());
        Pila.mostrar_estructura();

        System.out.println("\nEliminando " + Pila.pop());
        System.out.println("Mostrando el tope " + Pila.top());
        Pila.mostrar_estructura();

        System.out.println("\nEliminando " + Pila.pop());
        System.out.println("Mostrando el tope " + Pila.top());
        Pila.mostrar_estructura();

        System.out.println("\nEliminando " + Pila.pop());
        System.out.println("Mostrando el tope " + Pila.top());
        Pila.mostrar_estructura();
    }
}
