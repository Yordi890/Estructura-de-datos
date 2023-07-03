
/**
 * @author Yordanis Tejeda Rodríguez
 */
public class Recursividad {

    int resultado; // Esto es para ver como funciona el de la potencia

    /**
     * Calcula la potencia de un número elevado a otro
     *
     * @param base número al que le quieres hallar su potencia
     * @param potencia exponente al que se desea elevar la base
     * @return resultado de elevar la base a la potencia dada
     */
    public int potencia(int base, int potencia) {
        if (potencia == 0 || base == 1) {
            return 1;
        }
        return resultado = base * potencia(base, potencia - 1);
    }

    public void fibbonacci() {

    }

    /**
     * El número octal es el resto de las divisiones en sentido inverso
     *
     * @param n número al que se le quiere hallar el octal
     * @return octal del número dado
     */
    public static String octal(int n) {
        /*
         *  Ejemplo, octal de 100 sería
         *
         * 100 / 8 = 12 con resto 4
         * 12 / 8 = 1 con resto 4
         * 1 / 8 = 0 con resto 1
         *
         * Entonces queda que el octal es 144
         *
         */
        if (n / 8 == 0) {
            return Integer.toString(n % 8);
        }
        return octal(n / 8) + Integer.toString(n % 8);
    }

    /**
     * Calcula el factorial de un número
     *
     * @param n número al que se le desea hacer el factorial
     * @return factorial del número dado
     */
    public double factorial(int n) {
        if (n == 0) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    /**
     * Halla el producto de dos números cualesquiera, de forma recursiva
     * teniendo en cuenta que esto está dado por la suma del primer número
     * tantas veces como lo indique el segundo
     *
     * @param primer número
     * @param segundo número
     * @return producto entre ambos números
     */
    public double producto(int primer, int segundo) {
        if (primer == 0 || segundo == 0) {
            return 0;
        }
        return primer + producto(primer, segundo - 1);
    }

    /**
     * Calcula la suma de los primeros números naturales
     *
     * @param n número hasta donde se desea sumar
     * @return resultado de sumar los primeros "n" números
     */
    public int suma(int n) {
        if (n == 0) {
            return 0;
        }
        return n + suma(n - 1);
    }

    public int Buscar(int n, int Arr[], int i) {
        return (i < Arr.length) ? ((Arr[i] != n) ? Buscar(n, Arr, ++i) : i) : -1;
    }

    public static void main(String[] args) {
        Recursividad R = new Recursividad();

        System.out.println(R.potencia(2, 7));
        /*
        int Arr[] = {2, 4, 6, 8, 10};
        int pos = R.Buscar(8, Arr, 0);
        System.out.println(pos != -1 ? "Está en la posición " + (pos + 1) : "No se encontró");

        System.out.println(R.potencia(2, 3));
        System.out.println(R.factorial(5));
        System.out.println(R.producto(2, 412));
        System.out.println(R.suma(20));
        System.out.println(R.octal(100));
         */
    }
}
