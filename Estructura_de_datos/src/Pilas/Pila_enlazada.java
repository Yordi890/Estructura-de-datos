package Pilas;

import java.util.Iterator;
import java.util.function.Consumer;

/**
 * Lista de métodos de la clase Pila_enlazada
 * <table>
 * <tr>
 *  <td>Métodos</td>
 *  <td>Returns</td>
 * </tr>
 *
 *  <tr>
 *          <td>{@link  #push(Object) Push(e)}</td>
 *          <td>void</td>
 *  </tr>
 *
 * <tr>
 *      <td>{@link  #top()}</td>
 *      <td>E</td>
 * </tr>
 *
 * <tr>
 *     <td>{@link  #pop()}</td>
 *     <td>E</td>
 * </tr>
 *
 * <tr>
 *     <td>{@link  #isEmpty()}</td>
 *     <td>boolean</td>
 * </tr>
 *     <td>{@link  #size()}</td>
 *     <td>int</td>
 * <tr>
 *     <td>{@link  #clear()}</td>
 *     <td>void</td>
 * </tr>
 *
 * </table>
 *
 * @param <E> tipo de elemento de esta colección
 * @author Yordanis Tejeda Rodríguez
 * @version 2.0
 */
public class Pila_enlazada<E> implements Pila<E>, Iterable<E> {

    /**
     * Indicador del tope de la pila
     */
    private Nodo<E> top; // ¡Con solo esto es suficiente!

    /**
     * Para saber cuantos elementos tiene la pila
     */
    private int size;

    /**
     * Crea una nueva pila con top inicializado en null, porque estaría vacía y
     * con size (cantidad de elementos) en 0
     */
    public Pila_enlazada() {
        top = null;
        size = 0;
    }

    /**
     * Añade a la pila el elemento que se le pase como parámetro
     *
     * @param item elemento que se desea agregar
     * @since 1.0
     */
    @Override
    public void push(E item) {
        top = new Nodo<>(item, top); // Sííííííí funciona
        size++; // Para saber cuantos elementos tiene
    }

    /**
     * Devuelve el elemento superior de la pila, el que menos tiempo lleva
     *
     * @return elemento que ocupa el top
     * @since 1.0
     */
    @Override
    public E top() { // Si no está vacía retorno la info de top
        return !isEmpty() ? top.getInfo() : null; // Operador ternario
    }

    /**
     * Elimina el elemento que menos tiempo lleva en la lista
     *
     * @return elemento eliminado
     */
    @Override
    public E pop() {
        if (!isEmpty()) {
            E item = top.getInfo();
            top = top.getNext();
            size--;
            return item;
        }
        return null;
    }

    /**
     * Nos permite saber si la pila está vacía
     *
     * @return boolean true si la pila está vacía, en caso contrario false
     * @since 1.0
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Retorna la cantidad de elementos
     *
     * @return int size
     * @since 1.0
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Elimina todos los elementos de la pila
     *
     * @since 1.0
     */
    @Override
    public void clear() {
        top = null;
        size = 0;
    }

    /**
     * Muestra la estructura de la pila con todos sus enlaces
     *
     * @since 2.0
     */
    public void mostrar_estructura() {
        Nodo<E> cursor = top;

        for (int i = 0; i < size; i++) {
            System.out.print((i + 1) + "- " + cursor.getInfo() + " --> ");

            try {
                System.out.println(cursor.getNext().getInfo());
            } catch (Exception e) {
                System.out.println("no hay nada");
            }

            cursor = cursor.getNext();
        }

    }

    // Los métodos de a continuación son necesarios para poder usar el for each en estas estructuras
    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {

            Nodo<E> cursor = top;

            @Override
            public boolean hasNext() {
                return cursor != null;
            }

            @Override
            public E next() {
                if (!isEmpty()) {
                    Nodo<E> aux = cursor;
                    cursor = cursor.getNext();
                    return aux.getInfo();
                }
                return null;
            }
        };
    }

    @Override
    public void forEach(Consumer<? super E> action) {
        Iterable.super.forEach(action);
    }
}
