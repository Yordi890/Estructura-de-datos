package Listas.Circular_Simple;

/**
 * Nodo, posee una información y un indicador de siguiente
 */
public class Nodo<E> {

    /**
     * Información que contiene el nodo
     */
    private E Info;

    /**
     * Indicador de siguiente del nodo
     */
    private Nodo<E> Next;

    /**
     * Crea un nuevo nodo con la información que se le pase
     * como parámetro y con su indicador de siguiente
     */
    public Nodo(E Info, Nodo<E> Next) {
        this.Info = Info;
        this.Next = Next;
    }

    public E getInfo() {
        return Info;
    }

    public void setInfo(E info) {
        Info = info;
    }

    public Nodo<E> getNext() {
        return Next;
    }

    public void setNext(Nodo<E> next) {
        Next = next;
    }
}
