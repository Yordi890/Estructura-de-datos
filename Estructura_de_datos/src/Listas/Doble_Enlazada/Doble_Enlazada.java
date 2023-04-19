package Listas.Doble_Enlazada;

import java.util.Iterator;
import java.util.function.Consumer;

/**
 * <table>
 *     <tr>
 *         <td>Métodos</td>
 *         <td>Returns</td>
 *         <td>Throws</td>
 *     </tr>
 *
 *     <tr>
 *         <td>{@link #add(Object) add(E e)}</td>
 *         <td>void</td>
 *     </tr>
 *
 *     <tr>
 *         <td>{@link #add(Object, int) add(E e,int index)}</td>
 *         <td>void</td>
 *         <td>{@linkplain IndexOutOfBoundsException}</td>
 *     </tr>
 *
 *     <tr>
 *         <td>{@link #remove(int) remove(int index)}</td>
 *         <td>E</td>
 *         <td>{@linkplain IndexOutOfBoundsException}</td>
 *     </tr>
 *
 *       <tr>
 *           <td>{@link #get(int) get(int index)}</td>
 *           <td>E</td>
 *           <td>{@linkplain IndexOutOfBoundsException}</td>
 *       </tr>
 *
 *       <tr>
 *           <td>{@link #isEmpty()}</td>
 *           <td>boolean</td>
 *       </tr>
 *       <tr>
 *         <td>{@link #size()}</td>
 *         <td>int</td>
 *       </tr>
 *
 *     <tr>
 *         <td>{@link #clear()}</td>
 *         <td>void</td>
 *     </tr>
 *
 *
 * </table>
 *
 * @param <E> tipo de elemento de esta colección
 * @author Yordanis Tejeda Rodriguez
 * @version 4.0
 */
public class Doble_Enlazada<E> implements List<E>, Iterable<E> {

    /**
     * Indicador del primer nodo
     */
    private Nodo<E> first;

    /**
     * Indicador del último nodo
     */
    private Nodo<E> last;

    /**
     * Para saber cuantos elementos tiene la lista
     */
    private int size; // Para saber cuantos elementos tiene la lista

    /**
     * Crea una nueva lista con first y last inicializados en null, porque estaría vacía
     * y size (cantidad de elementos) en 0
     */
    public Doble_Enlazada() {
        first = last = null;
        size = 0;
    }

    /**
     * Nos permitirá conocer el primer nodo
     *
     * @return first, el primer nodo
     * @since 2.0
     */
    public Nodo<E> getFirst() { // Para lo del LinkedIterator
        return first;
    }

    /**
     * Añadirá a la lista el elemento que se le pase como parámetro
     *
     * @param e elemento que quieres agregar
     * @since 1.0
     */
    @Override
    public void add(E e) {

        if (!isEmpty()) {
            /*
               Si la lista no está vacía, indico que el siguiente de last va a ser
               un nuevo nodo del cual el anterior va a ser el last actual y el siguiente va a ser null
               luego muevo el indicador de last al siguiente del last que había hasta ese momento que
               sería el nuevo nodo que se creó
             */
            last.setNext(new Nodo<>(e, last, null));
            last = last.getNext();
        } else {
            first = last = new Nodo<>(e, null, null); // Si la lista está vacía first y last van a apuntar al mismo nodo
        }
        size++; // Siempre se incrementará size
    }

    /**
     * Añadirá el elemento en la posición que se le pase como parámetro
     *
     * @param index posición
     * @param e     elemento
     * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index > size)
     * @see #getNodo(int index)
     * @since 1.0
     */
    @Override
    public void add(E e, int index) {
        if (index >= 0 && index <= size) {
            if (index == 0) {
                /*
                   Al añadir en 0 hay que comprobar si la lista está vacía porque si lo está
                   puede darnos un error por eso hay que tratarlo de dos formas diferentes, porque sino da error!!!!
                 */
                if (!isEmpty()) {
                    first = new Nodo<>(e, null, first);
                    first.getNext().setPrev(first);
                } else {
                    first = last = new Nodo<>(e, null, null);
                }
            } else if (index == size) {
                /*
                    En caso de que size sea 0 y se quiera añadir en la posición 0, esto sería válido también,
                    pero se ejecuta la anterior primeramente. Por tanto, en otro caso cualquiera, si size es 1 y se quiera
                    añadir en la posición 1 (la segunda para nosotros) se trata de añadir como si fuera un método add normal
                    solo que para que preguntar si está vacía o no (si hace esto nunca estará vacía), por lo que siempre se iría
                    por el mismo camino por eso lo hago aquí mismo
                 */
                last.setNext(new Nodo<>(e, last, null));
                last = last.getNext();
            } else if (index == size - 1) {
                /*
                   Si vamos a añadir en la última posición este desplaza al último ocupando así la penúltima posición siempre
                   por lo que se puede aprovechar el indicador de Prev(anterior) y decir que el anterior al último va a apuntar a un
                   nuevo nodo el cual el anterior va a ser el penúltimo actual y el siguiente a este nuevo sería el último que había hasta
                   ese momento, quedando el nuevo nodo entre los dos ocupando la penúltima posición como debe ser, luego hay que actualizar el
                   puntero de last para que apunte al nuevo nodo
                 */
                last.getPrev().setNext(new Nodo<>(e, last.getPrev(), last));
                last.setPrev(last.getPrev().getNext());
            } else {
                Nodo<E> aux = getNodo(index);
                aux.getPrev().setNext(new Nodo<>(e, aux.getPrev(), aux));
                aux.setPrev(aux.getPrev().getNext());
                /*
                   Obtenemos el anterior al elemento y le decimos que su siguiente va a apuntar a un nuevo nodo que el anterior
                   va a ser el anterior a cursor y el siguiente va a ser cursor, quedando así el nuevo nodo en el medio del anterior
                   del cursor y el cursor, más tarde hay que reubicar el puntero de anterior del cursor al nuevo nodo que se creó
                 */
            }
            size++; // Siempre se incrementará en cualquiera de los casos
        } else {
            throw new IndexOutOfBoundsException("Index out of the range"); // Lanza un error si está fuera de rango
        }
    }

    /**
     * Eliminará de la lista la posición que se le pase como parámetro
     *
     * @param index posición
     * @return aux elemento que fue eliminado
     * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index > size)
     * @see #getNodo(int index)
     * @since 1.0
     */
    @Override
    public E remove(int index) {
        if (index >= 0 && index < size) {
            Nodo<E> aux; // Nos va a ayudar a saber cuál fue el elemento eliminado
            if (index == 0) {
                aux = first;
                first = first.getNext();
                first.setPrev(null);
            } else if (index == size - 1) {
                aux = last;
                last = last.getPrev();
                last.setNext(null);
            } else {
                aux = getNodo(index);
                aux.getPrev().setNext(aux.getNext());
                aux.getNext().setPrev(aux.getPrev());
            }

            size--; // Siempre se decrementará, en cualquiera de los casos
            return aux.getInfo(); // Para saber cuál fue el objeto que fue eliminado
        }
        throw new IndexOutOfBoundsException("Index out of the range"); // Lanza un error si está fuera de rango
    }

    /**
     * Obtiene el dato de la posición que se le pase como parámetro
     *
     * @param index posición
     * @return E elemento
     * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index > size)
     * @see #getNodo(int index)
     * @since 1.0.0
     */
    @Override
    public E get(int index) {
        if (index >= 0 && index < size) {
            if (index == 0) { // Si es la primera posición retornamos la info de first
                return first.getInfo();
            } else if (index == size - 1) { // Si es la última posición retornamos la info de last
                return last.getInfo();
            }
            return getNodo(index).getInfo(); // Va a retornar la info del nodo que encuentre, todas las comprobaciones ya se hicieron ...
        }
        throw new IndexOutOfBoundsException("Index out of the range"); // Lanza un error si está fuera de rango
    }

    /**
     * Devuelve dado una posición el nodo que está en ella
     *
     * @param index posición del elemento
     * @return nodo que ocupa dicha posición
     * @since 3.0
     */
    private Nodo<E> getNodo(int index) {
        Nodo<E> cursor = first;
        for (int i = 0; i < index; i++) {
            cursor = cursor.getNext(); // Desplazándonos hasta el elemento
        }
        return cursor;
    }

    /**
     * Devuelve dado una posición el nodo que está en ella, funciona de manera recursiva
     *
     * @param index posición del elemento
     * @return nodo que ocupa dicha posición
     * @since 3.0
     */
    private Nodo<E> getNodo_Recursive(Nodo<E> cursor, int i, int index) {
        if (i < index) {
            cursor = cursor.getNext();
            return getNodo_Recursive(cursor, ++i, index);
        }
        return cursor;
    }

    /**
     * Nos permite saber si la lista está vacía
     *
     * @return boolean true si la lista está vacía, en caso contrario false
     * @since 1.0
     */
    @Override
    public boolean isEmpty() {
        return size == 0; // Si size es cero es porque no hay elementos y, por tanto, retornamos true
    }

    /**
     * Retorna la cantidad de elementos de la lista
     *
     * @return int cantidad de elementos de la lista
     * @since 1.0
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Eliminará todos los elementos de la lista
     *
     * @since 1.0
     */
    @Override
    public void clear() {
        first = last = null;
        size = 0;

        /*
          Recursivamente
          if (size == 1) {
               remove(size - 1);
          } else {
               remove(size - 1);
               clear();
          }
         */
    }

    /**
     * Mostrará la estructura completa de la lista con todos sus enlaces
     *
     * @since 2.0
     */
    public void mostrar_estructura() {
        Nodo<E> cursor = first;

        System.out.println("Hello");

        for (int i = 0; i < size; i++) {
            try {
                System.out.print((i + 1) + "- " + cursor.getPrev().getInfo());
            } catch (Exception e) {
                System.out.print((i + 1) + "- no hay nada");
            }

            System.out.print(" <-- " + cursor.getInfo() + " --> ");

            try {
                System.out.println(cursor.getNext().getInfo());
            } catch (Exception e) {
                System.out.println("no hay nada");
            }
            cursor = cursor.getNext();
        }
    }

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

                if (hasNext()) {
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
