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
 *           <td>{@link #remove(Object) remove(E elemento)}</td>
 *           <td>boolean</td>
 *       </tr>
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
    private int size;

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
            if (index != size) {
                if (index == 0) {
                    first = new Nodo<>(e, null, first);
                    first.getNext().setPrev(first);
                } else if (index == size - 1) {
                    last.getPrev().setNext(new Nodo<>(e, last.getPrev(), last));
                    last.setPrev(last.getPrev().getNext());
                } else {
                    Nodo<E> aux = getNodo(index);
                    aux.getPrev().setNext(new Nodo<>(e, aux.getPrev(), aux));
                    aux.setPrev(aux.getPrev().getNext());
                }
                size++; // Siempre se incrementará en cualquiera de los casos
            } else {
                add(e);
            }
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
     * Retira de la lista la primera la ocurrencia del objeto
     * especificado. Si no se encuentra se mantendrá sin cambios.
     *
     * @param elemento elemento a ser removido de la lista
     * @return true si fue removido, en caso contrario false
     * @see #remove(int) remove(int index)
     * @since 4.0
     */
    public boolean remove(E elemento) {
        Nodo<E> cursor = first;

        for (int i = 0; i < size; i++) {
            if (cursor.getInfo().equals(elemento)) {
                remove(i);
                return true;
            }
            cursor = cursor.getNext();
        }

        return false;
    }

    public void set(int index, E elemento) {
        if (index >= 0 && index < size) {
            getNodo(index).setInfo(elemento);
        } else {
            throw new IndexOutOfBoundsException("Index out of the range"); // Lanza un error si está fuera de rango
        }
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
        return (i < index) ? getNodo_Recursive(cursor.getNext(), ++i, index) : cursor;
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


    // Los métodos de a continuación son necesarios para poder usar el for each en estas estructuras
    @Override
    public Iterator<E> iterator() {
        return new LinkedIterator<>(this);
    }

    @Override
    public void forEach(Consumer<? super E> action) {
        Iterable.super.forEach(action);
    }
}
