package Listas.Doble_Enlazada;

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

    /**
     * Crea un nuevo nodo con la información que se le pase como
     * parámetro y con sus respectivos indicadores de anterior y siguiente
     */
    public Nodo(E Info, Nodo<E> Prev, Nodo<E> Next) {
        this.Info = Info;
        this.Prev = Prev;
        this.Next = Next;
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

    @Override
    public String toString() {
        String L = "";

        try {
            L += "Prev: " + Prev.Info + " <-- ";
        } catch (Exception e) {
            L += "Prev: no hay nada <-- ";
        }

        L += "Info: " + Info;

        try {
            L += " --> Next: " + Next.Info;
        } catch (Exception e) {
            L += " --> Next: no hay nada";
        }


        return L;
    }
}
