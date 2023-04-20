package Cola;

/**
 * @author Yordanis Tejeda Rodríguez
 */
public class Test {

    public static void main(String[] args) {

        Cola_enlazada<Integer> Cola = new Cola_enlazada<Integer>();

        // Casos de prueba para el método add
        Cola.add(4);
        Cola.add(8);
        Cola.add(2);
        Cola.add(6);
        Cola.add(10);
        Cola.mostrar_estructura();

        for (Integer T : Cola) {
            System.out.println(T);
        }

        // Casos de prueba para el método peek
        System.out.println("\nMostrando el primero " + Cola.peek());

        System.out.println("\nEliminando " + Cola.poll());
        System.out.println("Mostrando el primero " + Cola.peek());
        System.out.println("Mostrando toda la estructura");
        Cola.mostrar_estructura();

        System.out.println("\nEliminando " + Cola.poll());
        System.out.println("Mostrando el primero " + Cola.peek());
        System.out.println("Mostrando toda la estructura");
        Cola.mostrar_estructura();

        System.out.println("\nEliminando " + Cola.poll());
        System.out.println("Mostrando el primero " + Cola.peek());
        System.out.println("Mostrando toda la estructura");
        Cola.mostrar_estructura();
    }
}
