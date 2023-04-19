package Listas.Circular_Doble;

/**
 * Nodo, posee una información y un indicador de anterior y de siguiente
 */
public class Nodo<E> {

    /**
     * Información que contiene el nodo
     */
    private E Info;

    /**
     * Indicador de anterior del nodo
     */
    private Nodo<E> Prev;

    /**
     * Indicador de siguiente del nodo
     */
    private Nodo<E> Next;


    public Nodo(E Info, Nodo<E> Prev, Nodo<E> Next) {
        this.Info = Info;
        this.Prev = Prev;
        this.Next = Next;
    }

    public Nodo(E Info) {
        this(Info, null, null);
    }

    public E getInfo() {
        return Info;
    }

    public void setInfo(E info) {
        Info = info;
    }

    public Nodo<E> getPrev() {
        return Prev;
    }

    public void setPrev(Nodo<E> prev) {
        Prev = prev;
    }

    public Nodo<E> getNext() {
        return Next;
    }

    public void setNext(Nodo<E> next) {
        Next = next;
    }
}
