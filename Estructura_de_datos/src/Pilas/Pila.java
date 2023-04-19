package Pilas;

/**
 * @param <E>
 * @author Yordanis Tejeda Rodríguez
 */
public interface Pila<E> {

    void push(E item);

    E top();

    E pop();

    boolean isEmpty();

    int size();

    void clear();
}
