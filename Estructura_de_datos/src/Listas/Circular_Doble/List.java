package Listas.Circular_Doble;

public interface List<E> {

    void add(E e);

    void add(E e, int index);

    E remove(int index);

    E get(int index);

    int size();

    void clear();

    boolean isEmpty();
}
