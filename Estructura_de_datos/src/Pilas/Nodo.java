package Pilas;

/**
 * Nodo, posee una información y un indicador de siguiente
 *
 * @param <E>
 * @author Yordanis Tejeda Rodríguez
 */
public class Nodo<E> {

    private E Info;
    private Nodo<E> next;

    /**
     * Crea un nuevo nodo con la información que se le pase como parámetro
     * y con su respectivo indicador de siguiente
     */
    public Nodo(E Info, Nodo<E> next) {
        this.Info = Info;
        this.next = next;
    }

    public E getInfo() {
        return Info;
    }

    public void setInfo(E Info) {
        this.Info = Info;
    }

    public Nodo<E> getNext() {
        return next;
    }

    public void setNext(Nodo<E> next) {
        this.next = next;
    }
}
