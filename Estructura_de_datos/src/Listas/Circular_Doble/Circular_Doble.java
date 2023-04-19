package Listas.Circular_Doble;

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
public class Circular_Doble<E> implements List<E>, Iterable<E> {

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
    public Circular_Doble() {
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
    public void add(E e) {

        if (isEmpty()) {
            /*
               Si la lista está vacía el indicador de first y last va a apuntar a donde mismo
               y el primero al ser el último, el siguiente va a ser el mismo y su anterior igualmente
               PD: al aplicar los cambios a first también se notan en last, puesto que en realidad no son objetos
               diferentes, sino indicadores, por lo tanto, al cambiárselos a uno ya basta porque, como dije, en realidad
               no son objetos diferentes
             */
            first = last = new Nodo<>(e);
            first.setNext(last);
        } else {
            /*
               Apoyándonos en last decimos que su indicador de siguiente va a ser un nuevo Nodo
               que va a tener como anterior el last que existe actualmente y que el siguiente siempre va a ser
               first, luego movemos el indicador de last al siguiente del last que había anteriormente el cual sería
               el nuevo nodo creado y por último actualizamos el puntero de anterior de first al nuevo indicador de last
             */
            last.setNext(new Nodo<>(e, last, first));
            last = last.getNext();
        }
        first.setPrev(last); // Esto es algo común para ambos casos
        size++; // Siempre se incrementará, en cualquiera de los casos
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
                // Si la lista está vacía hay que tratarlo de una forma u otra porque sino da error!!!!
                if (isEmpty()) {
                    /* Si está vacía se hace como un método add normal, pero como siempre
                       va a ir por el mismo camino y para no volver a preguntar si la lista está vacía
                       lo hago aquí mismo
                     */
                    first = last = new Nodo<>(e);
                    first.setNext(first);
                    first.setPrev(first);
                } else {
                    /*
                      Si no está vacía digo que first va a ser un nuevo nodo que su anterior siempre va a ser last
                      y su siguiente first, luego es necesario mover el puntero del first antiguo al nuevo first
                      y actualizar el puntero de siguiente de last al nuevo first
                     */
                    first = new Nodo<>(e, last, first);
                    first.getNext().setPrev(first);
                    last.setNext(first);
                }
            } else if (index == size) {
                /*
                    En caso de que size sea 0 y se quiera añadir en la posición 0, esto sería válido también,
                    pero se ejecuta la anterior primeramente. Por tanto, en otro caso cualquiera, si size es 1 y se quiera
                    añadir en la posición 1 (la segunda para nosotros) se trata de añadir como si fuera un método add normal
                    solo que para que preguntar si está vacía o no (si hace esto nunca estará vacía), por lo que siempre se iría
                    por el mismo camino por eso lo hago aquí mismo
                 */
                last.setNext(new Nodo<>(e, last, first));
                last = last.getNext();
                first.setPrev(last);
            } else if (index == size - 1) {
                /*
                    Si vamos a añadir en la última posición este desplaza al último ocupando así la penúltima posición siempre
                    por lo que se puede aprovechar el indicador de Prev(anterior) y mediante este le decimos que el siguiente al
                    penúltimo que había hasta ese momento va a ser un nuevo nodo que va a tener como anterior el anterior al último que
                    hay en ese momento (que sería el penúltimo) y el siguiente va a ser el último quedando así el nuevo nodo entre el penúltimo
                    que había hasta ese momento y el último entonces el nuevo nodo que se creó pasa a ser el penúltimo. Luego el indicador de anterior
                    del último hay que moverlo al nuevo nodo que se creó
                 */
                last.getPrev().setNext(new Nodo<>(e, last.getPrev(), last));
                last.setPrev(last.getPrev().getNext());
            } else {
                Nodo<E> aux = getNodo(index);
                aux.getPrev().setNext(new Nodo<>(e, aux.getPrev(), aux));
                aux.setPrev(aux.getPrev().getNext());
                /*
                   Obtenemos el anterior al elemento y le dice que su siguiente va a apuntar a un nuevo nodo que el anterior
                   va a ser el anterior a cursor y el siguiente va a ser cursor, quedando así el nuevo nodo en el medio del anterior
                   del cursor y el cursor, más tarde hay que reubicar el puntero de anterior del cursor al nuevo nodo que se creó
                 */
            }
            size++; // Siempre se incrementará, en cualquiera de los casos
        } else {
            throw new IndexOutOfBoundsException(); // Lanza un error si está fuera de rango
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
                first.setPrev(last);
                last.setNext(first);
            } else if (index == size - 1) {
                aux = last;
                last = last.getPrev();
                first.setPrev(last);
                last.setNext(first);
            } else {
                aux = getNodo(index);
                aux.getPrev().setNext(aux.getNext());
                aux.getNext().setPrev(aux.getPrev());
                /*
                   Nos desplazamos hasta el elemento que ocupa la posición que queremos eliminar y
                   con ayuda del método getPrev() (obtenemos el anterior) para decir que su siguiente va a
                   ser el siguiente a cursor y conjunto a esto le decimos que el anterior al siguiente del cursor
                   va a apuntar al anterior del cursor quedando el elemento que queremos eliminar sin acceso
                 */
            }
            size--; // Siempre se decrementará, en cualquiera de los casos
            return aux.getInfo(); // Para saber cuál fue el objeto que fue eliminado
        }
        throw new

                IndexOutOfBoundsException(); // Lanza un error si está fuera de rango

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
        throw new IndexOutOfBoundsException(); // Lanza un error si está fuera de rango
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
    public void mostrar_estructura() { // Aquí ya no hay ningún caso de que sea null
        Nodo<E> cursor = first;

        for (int i = 0; i < size; i++) {
            System.out.println((i + 1) + "- " + cursor.getPrev().getInfo() + " <-- " + cursor.getInfo() + " --> " + cursor.getNext().getInfo());
            cursor = cursor.getNext();
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            Nodo<E> cursor = first;
            int pos = 0;

            @Override
            public boolean hasNext() {
                return pos < size;
            }

            @Override
            public E next() {
                if (hasNext()) {
                    Nodo<E> aux = cursor;
                    cursor = cursor.getNext();
                    pos++;
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
