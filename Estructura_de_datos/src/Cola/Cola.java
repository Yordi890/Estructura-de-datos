package Cola;

/**
 *
 * @author Yordanis Tejeda Rodríguez
 * @param <E>
 */
public interface Cola<E> {

    void add(E item);

    E peek();

    E poll();

    boolean isEmpty();

    int size();
    
    void clear();
}
