package Listas.Circular_Doble;

import java.util.Iterator;

/**
 * @param <E>
 */
public class LinkedIterator<E> implements Iterator<E> {

    private Nodo<E> cursor;
    private int pos, size;

    public LinkedIterator(Circular_Doble<E> List) {
        this.cursor = List.getFirst(); // Tener en cuenta si en la clase donde se va a utilizar tiene el get de getFirst()
        this.size = List.size();
        pos = 0;
    }

    // Se sobreescriben de la clase Iterator original
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

}
