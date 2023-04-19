package Pilas;

/**
 * @author Yordanis Tejeda Rodríguez
 */
public class Test {

    public static boolean isPalindrome(String palabra) {
        String cadena = palabra.replace(" ", "");
        for (int i = 0, j = cadena.length() - 1; i < (cadena.length() - 1) / 2; i++, j--) {
            if (!(cadena.substring(i, i + 1).equalsIgnoreCase(cadena.substring(j, j + 1)))) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        Pila_enlazada<Integer> Pila = new Pila_enlazada<>();

        System.out.println(Pila.sacar_billete(42));

        // Casos de prueba para el método push
        Pila.push(4);
        Pila.push(8);
        Pila.push(2);
        Pila.push(6);
        Pila.mostrar_estructura();

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
