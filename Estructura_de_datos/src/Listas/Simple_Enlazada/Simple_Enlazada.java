package Listas.Simple_Enlazada;

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
public class Simple_Enlazada<E> implements List<E>, Iterable<E> {

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
    public Simple_Enlazada() {
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
     * @param e elemento
     * @since 1.0
     */
    @Override
    public void add(E e) {
        if (!isEmpty()) {
            /*
                 Si no está vacía significa que tiene al menos uno, por lo tanto,
                 apoyándome en el indicador de last le indico que va a tener un nuevo
                 nodo siguiente que va a tener como información ¨e¨ que viene como parámetro
                 y el siguiente va a ser null y luego muevo el indicador de last
             */
            last.setNext(new Nodo<>(e, null));
            last = last.getNext();
        } else {
            first = last = new Nodo<>(e, null); // Si la lista está vacía, creo un nuevo nodo el cual va a ser mi primero y mi último al mismo tiempo
        }
        size++; // Siempre se incrementará, en cualquiera de los dos casos
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
        if (index >= 0 && index <= size) {
            if (index == 0) {
                /*
                  Si la lista esta vacía tengo que hacer como si fuera un método add normal, si no lo está digo
                  que first va a ser un nuevo nodo que va a tener como siguiente el indicador de first que había hasta
                  ese momento, hay que hacerlo así porque sino da error!!!!
                 */
                first = isEmpty() ? last = new Nodo<>(e, null) : new Nodo<>(e, first); // Operador ternario
            } else if (index == size) {
                /*
                   Si index == size significa que estaríamos haciendo como si fuera un método
                   añadir normal, entonces apoyándome en el indicador de last, digo que va a tener como
                   siguiente un nuevo nodo con la información que viene por parámetro y el siguiente va a ser null
                   luego muevo el puntero de last (esto es como el método add, pero no lo llamo porque sería preguntar si
                   está vacía para siempre irse por el mismo camino)
                 */
                last.setNext(new Nodo<>(e, null));
                last = last.getNext();
            } else {
                /*
                  Declaramos un nodo que le llamaremos cursor para ir desplazándonos
                  hasta la posición anterior en la cual queremos agregar un nuevo nodo,
                  una vez ahí, decimos que al nodo sobre el cual está posicionado nuestro
                  cursor va a tener un nuevo siguiente con la información que viene como parámetro y que este
                  nuevo nodo va a tener como siguiente el siguiente a cursor, que constituiría la posición en la
                  que queremos añadir un nuevo nodo, de esta forma se desplazan las posiciones y queda que el nuevo
                  nodo ocupa la decisión deseada porque desplaza al siguiente
                 */
                Nodo<E> cursor = first;
                for (int i = 0; i < index - 1; i++) {
                    cursor = cursor.getNext();
                }
                cursor.setNext(new Nodo<>(e, cursor.getNext()));
            }
            size++; // Siempre se incrementará, en cualquiera de los casos
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
     * @since 1.0
     */
    @Override
    public E remove(int index) {
        if (index >= 0 && index < size) { // Para verificar que index esté en el rango posible
            Nodo<E> aux; // Nos va a ayudar a saber cuál fue el elemento eliminado
            if (index != 0) {
                Nodo<E> cursor = first;
                for (int i = 0; i < index - 1; i++) {
                    cursor = cursor.getNext(); // Desplazándonos
                }
                aux = cursor.getNext(); // Para luego saber cuál fue el elemento eliminado
                /*
                  Nos desplazamos hasta el elemento que ocupa la posición anterior a la que queremos
                  eliminar y una vez ahí indicamos el siguiente nodo del nodo sobre el cual estamos
                  posicionados será el siguiente del siguiente, quedando fuera el nodo intermedio entre
                  el nodo cursor y el siguiente de siguiente

                  Si ya tenemos que aux es el siguiente del cursor para no tener que poner cursor.getNext().getNext()
                  podemos apoyarnos en aux, para hacer uso del método getNext() una sola vez y ya, entonces le pasamos en la
                  siguiente línea aux.getNext() // Y nos ahorramos trabajo
                 */
                cursor.setNext(aux.getNext());

                if (index == size - 1) // Necesario porque si estamos eliminando la última posición hay que mover el puntero de last
                    last = cursor;
            } else {
                aux = first; // Para luego saber cuál fue el elemento eliminado
                first = first.getNext(); // Si es la primera posición, basta con mover el indicador de first al siguiente
            }

            size--; // Siempre se decrementará, en cualquiera de los dos casos
            return aux.getInfo(); // Para saber cuál fue el elemento eliminado
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

        if (index >= 0 && index < size) {

            if (index == 0) { // Si es la primera posición retornamos la info de first
                return first.getInfo();
            } else if (index == size - 1) { // Si es la última posición retornamos la info de last
                return last.getInfo();
            }
            /*
              Declaramos un nodo al cual le llamaremos cursor para ir desplazándonos hasta
              llegar al elemento de la posición a la cual queremos obtener su información,
              una vez ahí retornamos la información de dicho cursor
             */
            Nodo<E> cursor = first;
            for (int i = 0; i < index; i++) {
                cursor = cursor.getNext(); // Nos estamos desplazando hasta la posición del elemento
            }

            return cursor.getInfo(); // Una vez ubicados retornamos la info del cursor
        }
        throw new IndexOutOfBoundsException("Index out of the range"); // Lanza un error si está fuera de rango
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
            System.out.print((i + 1) + "- " + cursor.getInfo() + " --> ");
            try {
                System.out.println(cursor.getNext().getInfo());
            } catch (Exception e) {
                System.out.println("no hay nada");
            }
            cursor = cursor.getNext();
        }
    }


    // Métodos de ordenamiento

    public void bubblesort() { // Funciona, está listo


        Nodo<E> cursor = first, cursor2;

        E aux; // Nos ayudará a intercambiar los elementos

        for (int i = 0; i < size - 1; i++) {

            cursor2 = cursor.getNext();
            for (int j = i + 1; j < size; j++) {
                if ((int) cursor.getInfo() < (int) cursor2.getInfo()) { // Para cambiar el orden solo hay que cambiar el signo de comparación
                    aux = cursor.getInfo();
                    cursor.setInfo(cursor2.getInfo());
                    cursor2.setInfo(aux);
                }
                cursor2 = cursor2.getNext();
            }
            cursor = cursor.getNext();
        }
    }

    public void burbuja() {
        boolean b;
        Nodo<E> cursor = first, cursor2;
        E aux;
        int T = -1;
        do {
            b = false;

            cursor2 = cursor.getNext();
            T++;

            for (int i = T; i < size - 1; i++) {
                if ((int) cursor.getInfo() < (int) cursor2.getInfo()) { // Para cambiar el orden solo hay que cambiar el signo de comparación
                    aux = cursor.getInfo();
                    cursor.setInfo(cursor2.getInfo());
                    cursor2.setInfo(aux);
                    b = true;
                }
                cursor2 = cursor2.getNext();
            }

            cursor = cursor.getNext();
        } while (b);

    }

    public void selectionsort() { // Funciona, está listo

        Nodo<E> cursor = first, cursor2, min_max;
        E aux;

        for (int i = 0; i < size - 1; i++) {

            min_max = cursor; // Le llamé min_max para no tener que estar cambiándole el nombre cada vez que quiera cambiar el sentido de la ordenación
            cursor2 = cursor.getNext();

            for (int j = i + 1; j < size; j++) {
                if ((int) min_max.getInfo() < (int) cursor2.getInfo()) { // Para cambiar el orden solo hay que cambiar el signo de comparación
                    min_max = cursor2;
                }
                cursor2 = cursor2.getNext();
            }

            aux = cursor.getInfo();
            cursor.setInfo(min_max.getInfo());
            min_max.setInfo(aux);

            cursor = cursor.getNext();
        }

    }

    public void insertionsort() { // Funciona, está listo
        Nodo<E> cursor = first.getNext(), cursor2;

        int pos;

        for (int i = 1; i < size; i++) { // Se puede empezar en 1 porque comienzo en first.getNext(), o sea el segundo que para nosotros sería en 1

            cursor2 = first;
            pos = 0;

            while ((int) cursor.getInfo() > (int) cursor2.getInfo()) { // Para cambiar el orden solo hay que cambiar el signo de comparación
                cursor2 = cursor2.getNext();
                pos++;
            }

            add(remove(i), pos);

            cursor = cursor.getNext();
        }
    }


    public void countingsort() { // Todavía le falta, no está listo
        Nodo<E> cursor = first, min = first, max = first;

        for (int i = 0; i < size; i++) {

            if ((int) cursor.getInfo() < (int) min.getInfo()) {
                min = cursor;
            }

            if ((int) cursor.getInfo() > (int) max.getInfo()) {
                max = cursor;
            }

            cursor = cursor.getNext();
        }


    }


    public void bucketsort() {

        /*
           Consiste en dividir la lista por casilleros y luego aplicar un método de ordenamiento
           en cada uno de ellos y luego concatenarlos (puede ser uno diferente en cada casillero)
         */


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
