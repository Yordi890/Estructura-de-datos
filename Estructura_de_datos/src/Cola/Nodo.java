package Cola;

/**
 * Nodo, posee una información y un indicador de siguiente
 *
 * @param <E>
 * @author Yordanis Tejeda Rodríguez
 */
public class Nodo<E> {

    /**
     * Información que contiene el nodo
     */
    private E Info;

    /**
     * Indicador de siguiente del nodo
     */
    private Nodo<E> next;

    /**
     * Crea un nuevo nodo con la información que se le pase como parámetro
     */
    public Nodo(E Info) {
        this.Info = Info;
    }

    public Nodo<E> getNext() {
        return next;
    }

    public void setNext(Nodo<E> next) {
        this.next = next;
    }

    public E getInfo() {
        return Info;
    }

    public void setInfo(E Info) {
        this.Info = Info;
    }
}
