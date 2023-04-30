package Cola;

import java.util.Iterator;
import java.util.function.Consumer;

/**
 * Lista de métodos de la clase Cola_Enlazada
 *
 * <table>
 * <tr>
 * <td>Métodos</td>
 * <td>Returns</td>
 * </tr>
 *
 * <tr>
 * <td>{@link  #add(Object) add(e)}</td>
 * <td>void</td>
 * </tr>
 *
 * <tr>
 * <td>{@link  #peek()}</td>
 * <td>E</td>
 * </tr>
 *
 * <tr>
 * <td>{@link  #poll()}</td>
 * <td>E</td>
 * </tr>
 *
 * <tr>
 * <td>{@link  #isEmpty()}</td>
 * <td>boolean</td>
 * </tr>
 *
 * <tr>
 * <td>{@link  #size()}</td>
 * <td>int</td>
 * </tr>
 *
 * <tr>
 * <td>{@link  #clear()}</td>
 * <td>void</td>
 * </tr>
 * </table>
 *
 * @param <E> tipo de elemento de esta colección
 * @author Yordanis Tejeda Rodríguez
 * @version 2.0
 */
public class Cola_enlazada<E> implements Cola<E>, Iterable<E> {

    /**
     * Indicador del primer nodo
     */
    private Nodo<E> first;
    /**
     * Indicador del último nodo
     */
    private Nodo<E> last;

    /**
     * Para saber cuantos elementos tiene la cola
     */
    private int size;

    /**
     * Crea una nueva lista con first y last inicializados en null, porque estaría vacía y size (cantidad de elementos) en 0
     */
    public Cola_enlazada() {
        first = last = null;
        size = 0;
    }

    /**
     * Agrega a la cola el elemento que se le pase como parámetro
     *
     * @param item elemento que quieres agregar
     * @since 1.0
     */
    @Override
    public void add(E item) {

        if (!isEmpty()) {
            last.setNext(new Nodo<>(item));
            last = last.getNext();
            /*
                 Si no está vacía significa que tiene al menos uno, por lo tanto,
                 apoyándome en el indicador de last le indico que va a tener un nuevo
                 nodo siguiente que va a tener como información ¨e¨ que viene como parámetro
                 y el siguiente va a ser null y luego muevo el indicador de last
             */
        } else {
            first = last = new Nodo<>(item); // Si la lista está vacía, creo un nuevo nodo el cual va a ser mi primero y mi último al mismo tiempo
        }
        size++; // Siempre se incrementará, en cualquiera de los dos casos
    }

    /**
     * Devuelve el elemento que lleva más tiempo en la cola, el primero
     *
     * @return elemento first
     * @since 1.0
     */
    @Override
    public E peek() {
        return !isEmpty() ? first.getInfo() : null; // Operador ternario // Si la lista no está vacía ...
    }

    /**
     * Elimina el elemento que más tiempo lleva en la cola, el primero
     *
     * @return elemento eliminado
     * @since 1.0
     */
    @Override
    public E poll() {
        if (!isEmpty()) { // Si no está vacía
            E item = first.getInfo(); // Nos ayudará a saber cuál fue el elemento eliminado
            first = first.getNext(); // Es suficiente con decir que el first va a ser el siguiente del first que había hasta ese momento
            size--; // Necesario decrementar la cantidad de elementos

            /*
               Aunque se quite este otro if que puse aquí abajo el programa seguirá funcionando normalmente,
               pero cuando se estén eliminando los elementos, cuando se eliminen todos el va a seguir diciendo
               que last era el que tenía aunque al estar vacía debe ser null, pero como dije el seguirá funcionando
               pero tendrá ese detalle
             */
            if (size == 0)
                first = last = null;

            return item;
        }
        return null; // Si está vacía retorno null
    }

    /**
     * Nos permite saber si la cola está vacía
     *
     * @return boolean true si la cola está vacía, en caso contrario false
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
     * Elimina todos los elementos de la cola
     *
     * @since 1.0
     */
    @Override
    public void clear() {
        first = last = null;
        size = 0;
    }

    /**
     * Muestra la estructura de la cola con todos sus enlaces
     *
     * @since 2.0
     */
    public void mostrar_estructura() {
        Nodo<E> cursor = first;

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

            Nodo<E> cursor = first;

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
