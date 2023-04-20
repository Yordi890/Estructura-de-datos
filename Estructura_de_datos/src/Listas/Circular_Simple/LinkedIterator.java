package Listas.Circular_Simple;

import java.util.Iterator;

public class LinkedIterator<E> implements Iterator<E> {

    Circular_Simple<E> Lista;
    private Nodo<E> cursor;
    int pos;

    public LinkedIterator(Circular_Simple<E> List) {
        this.Lista = List;
        this.cursor = List.getFirst(); // Tener en cuenta si en la clase donde se va a utilizar tiene el get de getFirst()
        pos = 0;
    }

    // Se sobreescriben de la clase Iterator original
    @Override
    public boolean hasNext() {
        return pos < Lista.size();
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
