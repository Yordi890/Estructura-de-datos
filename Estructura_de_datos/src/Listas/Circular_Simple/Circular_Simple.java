package Listas.Circular_Simple;

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
 *           <td>{@link #remove_Obj(Object) remove(E elemento)}</td>
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
public class Circular_Simple<E> implements List<E>, Iterable<E> {

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
    public Circular_Simple() {
        first = last = null;
        size = 0;
    }

    /**
     * Nos permitirá conocer el primer nodo
     *
     * @return first, el primer nodo
     * @since 2.0
     */
    public Nodo<E> getFirst() { // Para poder usar lo del Iterator
        return first;
    }

    /**
     * Añadirá a la lista el elemento que se le pase como parámetro
     *
     * @param e elemento
     * @since 1.0
     */
    @Override
    public void add(E e) { // Método para añadir un elemento en la lista

        if (isEmpty()) {
            /*
                Si la lista está vacía first y last tendrían la misma información porque
                apuntan a donde mismo y el siguiente será null, pero como estamos en una lista
                circular simple el puntero de siguiente de last debe apuntar al primero
             */
            first = last = new Nodo<>(e, null);
            last.setNext(first);
        } else {
            /*
                Apoyándonos en last, decimos que su siguiente va a ser un nuevo nodo que siempre el siguiente
                de este nuevo va a ser el primero y luego decimos que last va a ser el siguiente del antiguo
                last es decir el nuevo nodo que hemos creado
             */
            last.setNext(new Nodo<>(e, first));
            last = last.getNext();
        }
        size++; // Siempre se incrementará en cualquiera de los casos
    }

    /**
     * Añadirá el elemento en la posición que se le pase como parámetro
     *
     * @param index posición
     * @param e     elemento
     * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index > size)
     * @since 1.0
     */
    @Override
    public void add(E e, int index) {
        checkElementIndex(index);
        if (index == size) {
            add(e);
            return;
        } else if (index == 0) {
            first = new Nodo<>(e, first);
            last.setNext(first);
        } else {
            Nodo<E> aux = getNodo(index - 1);
            aux.setNext(new Nodo<>(e, aux.getNext()));
        }
        size++; // Siempre se incrementará, en cualquiera de los casos
    }

    /**
     * Eliminará de la lista la posición que se le pase como parámetro
     *
     * @param index posición
     * @return aux elemento que fue eliminado
     * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index > size)
     * @since 1.0
     */
    @Override
    public E remove(int index) {
        checkElementIndex(index + 1);
        Nodo<E> aux; // Nos va a ayudar a saber cuál fue el elemento eliminado
        if (index == 0) {
            aux = first;
            first = first.getNext();
            last.setNext(first);
        } else if (index == size - 1) {
            aux = last;
            last = getNodo(size - 2);
            last.setNext(first);
        } else {
            Nodo<E> cursor = getNodo(index - 1);
            aux = cursor.getNext();
            cursor.setNext(aux.getNext()); // Nos apoyamos en aux para no tener que hacer un doble uso del método getNext()
        }
        size--; // Siempre se decrementará, en cualquiera de los casos
        return aux.getInfo(); // Para saber cuál fue el objeto que fue eliminado
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
    public boolean remove_Obj(E elemento) {

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
        checkElementIndex(index);
        getNodo(index).setInfo(elemento);
    }

    /**
     * Obtiene el dato de la posición que se le pase como parámetro
     *
     * @param index posición
     * @return E elemento
     * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index > size)
     * @since 1.0.0
     */
    @Override
    public E get(int index) {
        checkElementIndex(index);
        return getNodo(index).getInfo(); // Una vez ubicados retornamos la info del cursor
    }

    private void checkElementIndex(int index) {
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException("Index out of the range"); // Lanza un error si está fuera de rango
    }

    public Nodo<E> getNodo(int index) {
        Nodo<E> cursor = first;
        for (int i = 0; i < index; i++) {
            cursor = cursor.getNext(); // Nos estamos desplazando hasta la posición del elemento
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
    public boolean isEmpty() { //Método para saber si la lista está vacía
        return size == 0;
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
            System.out.println((i + 1) + "- " + cursor.getInfo() + " --> " + cursor.getNext().getInfo());
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
