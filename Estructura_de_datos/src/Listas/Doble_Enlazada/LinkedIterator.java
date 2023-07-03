package Listas.Doble_Enlazada;

import java.util.Iterator;

/**
 * @param <E>
 * @author Yordanis Tejeda Rodríguez
 */
public class LinkedIterator<E> implements Iterator<E> {

    private Nodo<E> cursor;

    public LinkedIterator(Doble_Enlazada<E> List) {
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
            cursor = cursor.getNext();
            return cursor.getPrev().getInfo();
        }
        return null;
    }
}
