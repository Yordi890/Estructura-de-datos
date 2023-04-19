package Arboles.Binario;

import Cola.Cola_enlazada;

public class Binary_Tree<E> {

    /**
     * Raíz del árbol
     */
    private Nodo<E> root;

    public Binary_Tree(Nodo<E> root) {
        this.root = root;
    }

    public Binary_Tree() {
        this.root = null;
    }

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
     * @param nodo a buscar si es una raíz
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
     * @param nodo a buscar si es hoja o no
     * @return boolean true si es hoja, en caso contrario false
     */
    public boolean isLeaf(Nodo<E> nodo) {
        return nodo.getLeft() == null && nodo.getRight() == null;
    }

    /**
     * Nos permite saber si el nodo que se le pase como parámetro es interno
     *
     * @param nodo a buscar si es interno o no
     * @return boolean si es interno, en caso contrario false
     */
    public boolean isInternal(Nodo<E> nodo) {
        return !isLeaf(nodo);
    }

    /**
     * Dado una información encontrará el nodo que la tiene
     *
     * @param info del nodo que quieres buscar
     * @return nodo que tiene la info
     */
    public Nodo<E> Buscar_Nodo(E info) {

        Cola_enlazada<Nodo<E>> cola = new Cola_enlazada<Nodo<E>>();

        cola.add(root);

        while (!cola.isEmpty()) {
            Nodo<E> nodo = cola.poll();

            if (nodo.getInfo().equals(info)) {
                return nodo;
            }

            if (nodo.getLeft() != null) {
                cola.add(nodo.getLeft());
            }
            if (nodo.getRight() != null) {
                cola.add(nodo.getRight());
            }

        }

        return null;
    }


    /**
     * Agrega un nuevo nodo dado la info, su padre y la posición derecha o izquierda
     *
     * @param info   la información del nodo
     * @param origen el nodo padre
     * @param pos    true para la derecha, false para la izquierda
     */
    public void add(E info, boolean pos, Nodo<E> origen) {
        if (root != null) {
            try {
                if (Buscar_Nodo(origen.getInfo()) != null) {
                    if (origen.getRight() != null && pos) {
                        System.out.println("La rama derecha ya está ocupada");
                    } else if (origen.getLeft() != null && !pos) {
                        System.out.println("La rama izquierda ya está ocupada");
                    } else {
                        if (pos) {
                            origen.setRight(new Nodo<>(info, origen));
                        } else {
                            origen.setLeft(new Nodo<>(info, origen));
                        }
                    }
                }
            } catch (NullPointerException e) {
                System.out.println("El padre no existe");
            }

        } else {
            root = new Nodo<>(info);
        }
    }

    public E remove(Nodo<E> nodo) {
        try {
            if (nodo == root) {
                root = null;
            } else {
                // Falta por implementar
            }
            return nodo.getInfo();
        } catch (NullPointerException e) {
            return null;
        }
    }
}
