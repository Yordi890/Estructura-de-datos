package Arboles.Binario_Búsqueda;

public class Binary_Search_Tree<E extends Comparable<E>> {

    /**
     * Raíz del árbol
     */
    private Nodo<E> root;

    /**
     * Retorna la raíz del árbol
     *
     * @return Nodo<E> raíz
     */
    public Nodo<E> getRoot() {
        return root;
    }

    /**
     * Nos permite saber si el nodo es una raíz
     *
     * @param nodo a saber si es una raíz
     * @return boolean true si es una raíz, false en caso contrario
     */
    public boolean isRoot(Nodo<E> nodo) {
        return root == nodo;
    }

    /**
     * Permite saber si el árbol tiene algún nodo
     *
     * @return boolean true si el árbol está vacío
     */
    public boolean isEmpty() {
        return root == null;
    }

    /**
     * Nos permite saber si el nodo que se le pase como parámetro es una hoja
     *
     * @param nodo a saber si es hoja
     * @return boolean true si es hoja, en caso contrario false
     */
    public boolean isLeaf(Nodo<E> nodo) {
        return nodo.getLeft() == null && nodo.getRight() == null;
    }

    /**
     * Nos permite saber si el nodo que se le pase como parámetro es interno
     *
     * @param nodo a saber si es interno
     * @return boolean si es interno, en caso contrario false
     */
    public boolean isInternal(Nodo<E> nodo) {
        return !isLeaf(nodo);
    }

    // Método adicionar de forma iterativa

    public Nodo<E> add(E info) {
        Nodo<E> nodo = null;


        if (root != null) {

            Nodo<E> aux = root;
            boolean insertado = false;

            while (!insertado) {

                if (aux.getInfo().compareTo(info) > 0) {

                    if (aux.getLeft() == null) {
                        nodo = new Nodo<>(info);
                        nodo.setParent(aux);
                        aux.setLeft(nodo);
                        insertado = true;
                    } else {
                        aux = aux.getLeft();
                    }

                } else {

                    if (aux.getRight() == null) {
                        nodo = new Nodo<>(info);
                        nodo.setParent(aux);
                        aux.setRight(nodo);
                        insertado = true;
                    } else {
                        aux = aux.getRight();
                    }

                }

            }
        } else {
            root = nodo = new Nodo<>(info);
        }

        return nodo;
    }

    // Método adicionar de manera recursiva

    public Nodo<E> add(E info, Nodo<E> origen) {
        Nodo<E> nodo = null;


        if (root == null) {
            root = nodo = new Nodo<>(info);
        } else if (origen == null) {
            System.out.println("El origen es nulo");
        } else {


            if (origen.getInfo().compareTo(info) > 0) {


                if (origen.getLeft() == null) {
                    nodo = new Nodo<>(info);
                    nodo.setParent(origen);
                    origen.setLeft(nodo);
                } else {
                    nodo = add(info, origen.getLeft());
                }


            } else {

                if (origen.getRight() == null) {
                    nodo = new Nodo<>(info);
                    nodo.setParent(origen);
                    origen.setRight(nodo);
                } else {
                    nodo = add(info, origen.getRight());
                }


            }


        }

        return nodo;
    }

}
