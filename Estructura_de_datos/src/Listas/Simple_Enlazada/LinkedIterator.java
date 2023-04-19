package Listas.Simple_Enlazada;

import java.util.Iterator;

/**
 * @param <E>
 */
public class LinkedIterator<E> implements Iterator<E> {

    private Nodo<E> cursor;

    public LinkedIterator(Simple_Enlazada<E> List) {
        this.cursor = List.getFirst(); // Tener en cuenta si en la clase donde se va a utilizar tiene el get de getFirst()
    }

    // Se sobreescriben de la clase Iterator original
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

}
