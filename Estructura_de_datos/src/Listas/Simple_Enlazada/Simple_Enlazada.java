package Listas.Simple_Enlazada;


import java.util.Iterator;
import java.util.LinkedList;
import java.util.function.Consumer;

/**
 * <table>
 * <tr>
 * <td>Métodos</td>
 * <td>Returns</td>
 * <td>Throws</td>
 * </tr>
 *
 * <tr>
 * <td>{@link #add(Object) add(E e)}</td>
 * <td>void</td>
 * </tr>
 *
 * <tr>
 * <td>{@link #add(Object, int) add(E e,int index)}</td>
 * <td>void</td>
 * <td>{@linkplain IndexOutOfBoundsException}</td>
 * </tr>
 *
 * <tr>
 * <td>{@link #remove(int) remove(int index)}</td>
 * <td>E</td>
 * <td>{@linkplain IndexOutOfBoundsException}</td>
 * </tr>
 *
 * <tr>
 * <td>{@link #remove_Obj(Object) remove(E elemento)}</td>
 * <td>boolean</td>
 * </tr>
 *
 * <tr>
 * <td>{@link #get(int) get(int index)}</td>
 * <td>E</td>
 * <td>{@linkplain IndexOutOfBoundsException}</td>
 * </tr>
 *
 * <tr>
 * <td>{@link #isEmpty()}</td>
 * <td>boolean</td>
 * </tr>
 * <tr>
 * <td>{@link #size()}</td>
 * <td>int</td>
 * </tr>
 *
 * <tr>
 * <td>{@link #clear()}</td>
 * <td>void</td>
 * </tr>
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
     * Crea una nueva lista con first y last inicializados en null, porque estaría vacía y size (cantidad de elementos) en 0
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

    public void setFirst(Nodo<E> first) {
        this.first = first;
    }

    public Nodo<E> getLast() {
        return last;
    }

    public void setLast(Nodo<E> last) {
        this.last = last;
    }

    public void setSize(int size) {
        this.size = size;
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
        checkElementIndex(index);

        if (index != size) {
            if (index == 0) {
                first = new Nodo<>(e, first);
            } else {
                Nodo<E> aux = getNodo(index - 1);
                aux.setNext(new Nodo<>(e, aux.getNext()));
            }
            size++; // Siempre se incrementará, en cualquiera de los casos
        } else {
            add(e);
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
        checkElementIndex(index + 1);

        Nodo<E> aux; // Nos va a ayudar a saber cuál fue el elemento eliminado
        if (index == 0) {
            aux = first; // Para luego saber cuál fue el elemento eliminado
            first = first.getNext(); // Si es la primera posición, basta con mover el indicador de first al siguiente
        } else if (index == size - 1) {
            aux = last;
            last = getNodo(size - 2);
            last.setNext(null);
        } else {
            Nodo<E> cursor = getNodo(index - 1);
            aux = cursor.getNext();
            cursor.setNext(aux.getNext());
        }

        size--; // Siempre se decrementará, en cualquiera de los dos casos
        return aux.getInfo(); // Para saber cuál fue el elemento eliminado
    }

    /**
     * Retira de la lista la primera la ocurrencia del objeto especificado. Si no se encuentra se mantendrá sin cambios.
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

    private void checkElementIndex(int index) {
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException("Index out of the range"); // Lanza un error si está fuera de rango
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

    public boolean contains(E e) {
        Nodo<E> cursor = first;
        while (cursor != null) {
            if (cursor.getInfo().equals(e)) {
                return true;
            }
            cursor = cursor.getNext();
        }
        return false;
    }

    private Nodo<E> getNodo(int index) {
        Nodo<E> cursor = first;
        for (int i = 0; i < index; i++) {
            cursor = cursor.getNext();
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
    public void bubble_sort(Simple_Enlazada<Integer> Lista) { // Funciona, está listo
        Nodo<Integer> cursor = Lista.getFirst(), cursor2;
        Integer aux; // Nos ayudará a intercambiar los elementos

        for (int i = 0; i < size - 1; i++) {
            cursor2 = cursor.getNext();
            for (int j = i + 1; j < size; j++) {
                if (cursor.getInfo() < cursor2.getInfo()) { // Para cambiar el orden solo hay que cambiar el signo de comparación
                    aux = cursor.getInfo();
                    cursor.setInfo(cursor2.getInfo());
                    cursor2.setInfo(aux);
                }
                cursor2 = cursor2.getNext();
            }
            cursor = cursor.getNext();
        }
    }

    public void bubble_sort2(Simple_Enlazada<Integer> Lista) {
        Nodo<Integer> cursor = Lista.getFirst(), cursor2;
        Integer aux; // Nos ayudará a intercambiar los elementos
        int T = -1;
        boolean b;
        do {
            cursor2 = cursor.getNext();
            b = false;
            T++;
            for (int i = T; i < size - 1; i++) {
                if (cursor.getInfo() < cursor2.getInfo()) { // Para cambiar el orden solo hay que cambiar el signo de comparación
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

    public void recursive_bubble_sort(Nodo<Integer> cursor, Nodo<Integer> cursor2, int pos) {
        if (pos < size - 1) {
            Integer aux; // Nos ayudará a intercambiar los elementos
            for (int i = pos; i < size - 1; i++) {
                if (cursor.getInfo() < cursor2.getInfo()) { // Para cambiar el orden solo hay que cambiar el signo de comparación
                    aux = cursor.getInfo();
                    cursor.setInfo(cursor2.getInfo());
                    cursor2.setInfo(aux);
                }
                cursor2 = cursor2.getNext();
            }
            cursor = cursor.getNext();
            recursive_bubble_sort(cursor, cursor.getNext(), ++pos);
        }
    }

    public void selection_sort(Simple_Enlazada<Integer> Lista) { // Funciona, está listo
        Nodo<Integer> cursor = Lista.getFirst(), cursor2, min_max;
        Integer aux; // Nos ayudará a intercambiar los elementos

        for (int i = 0; i < size - 1; i++) {

            min_max = cursor; // Le llamé min_max para no tener que estar cambiándole el nombre cada vez que quiera cambiar el sentido de la ordenación
            cursor2 = cursor.getNext();

            for (int j = i + 1; j < Lista.size(); j++) {
                if (min_max.getInfo() < cursor2.getInfo()) { // Para cambiar el orden solo hay que cambiar el signo de comparación
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

    public void insertion_sort(Simple_Enlazada<Integer> Lista) { // Funciona, está listo  /// Tratar de mejorarlo
        Nodo<Integer> cursor = Lista.getFirst().getNext(), cursor2;
        int pos;

        for (int i = 1; i < Lista.size(); i++) { // Se puede empezar en 1 porque comienzo en first.getNext(), o sea el segundo que para nosotros sería en 1

            cursor2 = Lista.getFirst();
            pos = 0;

            while (cursor2.getInfo() < cursor.getInfo()) { // Para cambiar el orden solo hay que cambiar el signo de comparación
                cursor2 = cursor2.getNext();
                pos++;
            }

            if (i != pos) // No tiene sentido hacer el procedimiento si el cursor2 llego a donde mismo el cursor
                Lista.add(Lista.remove(i), pos);

            cursor = cursor.getNext(); // Tener en cuenta lo que pasa con este cursor (que no cambia cuando se elimina)
        }
    }

    public void counting_sort(Simple_Enlazada<Integer> Lista) { // Funciona, está listo
        Nodo<Integer> cursor = Lista.getFirst().getNext(), max = Lista.getFirst();

        for (int i = 1; i < Lista.size(); i++) {
            if (cursor.getInfo() > max.getInfo()) {
                max = cursor;
            }
            cursor = cursor.getNext();
        }

        int[] Arr = new int[max.getInfo() + 1];

        int T = Lista.size();
        for (int i = 0; i < T; i++) {
            Arr[Lista.remove(0)]++;
        }

        for (int i = 0; i < Arr.length; i++) { // De menor a mayor --> int i = 0; i < Arr.length; i++ || De mayor a menor --> int i = Arr.length - 1; i > 0; i--
            if (Arr[i] != 0) {
                for (int j = 0; j < Arr[i]; j++) {
                    Lista.add(i);
                }
            }
        }
    }

    public void cocktail_sort(Simple_Enlazada<Integer> Lista) { // Está listo, funciona
        int izq = 0, der = Lista.size() - 1, aux; // Nos ayudará a intercambiar los elementos
        /*
            Para establecer un orden de ordenamiento correcto las condiciones de los if
            dentro de cada for deben estar en sentido contrario

            De mayor a menor :
            Condición 1er if : <
            Condición 2nd if : >

            De menor a mayor:
            Condición 1er if : >
            Condición 2nd if : <
         */
        do {
            for (int i = izq; i < der; i++) {
                if (Lista.get(i) > Lista.get(i + 1)) {
                    aux = Lista.get(i + 1);
                    Lista.getNodo(i + 1).setInfo(Lista.get(i));
                    Lista.getNodo(i).setInfo(aux);
                }
            }
            izq++;

            for (int i = der - 1; i >= izq; i--) {
                if (Lista.get(i) < Lista.get(i - 1)) {
                    aux = Lista.get(i);
                    Lista.getNodo(i).setInfo(Lista.get(i - 1));
                    Lista.getNodo(i - 1).setInfo(aux);
                }
            }
            der--;
        } while (izq < der);
    }

    public void shell_sort(Simple_Enlazada<Integer> Lista) {
        int salto = Lista.size() / 2, j, k, aux;

        while (salto > 0) {
            for (int i = salto; i < Lista.size(); i++) {
                j = i - salto;
                while (j >= 0) {
                    k = j + salto;
                    if (Lista.get(j) > Lista.get(k)) {
                        aux = Lista.get(j);
                        Lista.getNodo(j).setInfo(Lista.get(k));
                        Lista.getNodo(k).setInfo(aux);
                        j -= salto;
                    } else {
                        j--;
                    }
                }
            }
            salto /= 2;
        }

    }

    public void bucket_sort(Simple_Enlazada<Integer> Lista) { // Todavía no está listo
        int menor = Lista.get(0), mayor = Lista.get(0), size = Lista.size();

        for (Integer valor : Lista) {
            if (valor > mayor) {
                mayor = valor;
            }
            if (valor < menor) {
                menor = valor;
            }
        }
        int C = (mayor - menor) / 10;
        int cant_casilleros = mayor / C;

        Simple_Enlazada<Simple_Enlazada<Integer>> casilleros = new Simple_Enlazada<>();

        for (int i = 0; i < cant_casilleros; i++) {
            casilleros.add(new Simple_Enlazada<>());
        }

        Lista.remove_Obj(menor);
        casilleros.get(0).add(menor);
        for (int i = 0; i < cant_casilleros; i++) {
            for (int j = 0; j < Lista.size(); j++) {
                if (Lista.get(j) > menor && Lista.get(j) < menor + C) {
                    casilleros.get(i).add(Lista.remove(j));
                }
            }
            menor += C;
        }
        for (Simple_Enlazada<Integer> L : casilleros) {
            if (!L.isEmpty()) {
                insertion_sort(L);
                if (Lista.isEmpty()) {
                    Lista.setFirst(L.getFirst());
                } else {
                    Lista.getLast().setNext(L.getFirst());
                }
                Lista.setLast(L.getLast());
            }
        }

        Lista.setSize(size);
        /*for (int i = 0; i < cant_casilleros; i++) {
            if (!casilleros.get(i).isEmpty()) {
                for (int j = 0; j < casilleros.get(i).size(); j++) {
                    System.out.println(casilleros.get(i).get(j));
                }
            }
        }
        System.out.println("Hola");*/

    }

    public static void mergeSort(LinkedList<Integer> list, int izq, int der) {
        if (izq >= der) {
            return;
        }
        int middle = (izq + der) / 2;
        mergeSort(list, izq, middle);
        mergeSort(list, middle + 1, der);
        merge(list, izq, middle, der);
    }

    private static void merge(LinkedList<Integer> list, int low, int middle, int high) {
        int IstList_end = middle, IIndList_start = middle + 1, l = low;

        // Aquí empece a hacer los cambios
        while ((l <= IstList_end) && (IIndList_start <= high)) {
            if (list.get(low) < list.get(IIndList_start)) {
                low++;
            } else {
                int temp = list.get(IIndList_start);
                for (int j = IIndList_start - 1; j >= low; j--) {
                    list.set(list.get(j), j + 1);
                }
                list.set(temp, low); // Verificar esto cuando lo haga para mis propias estructuras
                low++;
                IstList_end++;
                IIndList_start++;
            }
        }
    }

    public void slow_sort() {
        /*     List<Integer> L = new ArrayList<>();
        L.add(45);
        L.add(3);
        L.add(1);
        L.add(23);


        //     while (!isListSorted(L)) {
        ///     Collections.shuffle(L);
        //   }

         */
    }

    private static boolean isListSorted(List<Integer> numberList) {
        if (numberList == null) return true;

        int length = numberList.size();
        if (length <= 1) return true;

        for (int i = 0; i < length - 1; i++) {
            if (numberList.get(i) > numberList.get(i + 1)) {
                return false;
            }

        }
        return true;
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