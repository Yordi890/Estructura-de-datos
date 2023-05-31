/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package Arboles.General;

import Cola.Cola_enlazada;

import Listas.Simple_Enlazada.Simple_Enlazada;

/**
 * @param <E> tipo de elemento de esta colección
 * @author Yordanis Tejeda Rodríguez
 * @version 1.0
 */
public class Tree<E> {

    /**
     * Raíz del árbol
     */
    private Nodo<E> root;

    /**
     * Constructor con la raíz inicializada
     */
    public Tree(Nodo<E> root) {
        this.root = root;
    }

    /**
     * Constructor con la raíz null, o sea, el árbol estará vacío
     */
    public Tree() {
        this.root = null;
    }

    public Nodo<E> getRoot() {
        return root;
    }

    public void setRoot(Nodo<E> root) {
        this.root = root;
    }


    public Nodo<E> BuscarNodo(E info) {
        Cola_enlazada<Nodo<E>> cola = new Cola_enlazada<Nodo<E>>();

        cola.add(root); // Agrego la raíz a mi cola y por aquí comienza todo

        while (!cola.isEmpty()) {
            Nodo<E> nodo = cola.poll();

            if (nodo.getInfo().equals(info)) {
                return nodo;
            }
            /*
                Entonces mientras la cola no esté vacía si el nodo padre que esté analizando
                en ese momento es igual a la info que ando buscando retorno ese nodo, de lo contrario
                agrego a la lista todos los nodos hijos que tenga ese nodo padre, luego de agregarlos
                como la cola no está vacía simplemente vuelvo a repetir el proceso hasta encontrarlo,
                si luego de analizarlos todos si no lo encontré, retorno null, o sea, que no lo encontré
              */
            for (Nodo<E> hijo : nodo.getChildren()) {
                cola.add(hijo);
            }
        }
        return null;
    }

    public void add_Nodo(E info, Nodo<E> padre) {
        if (BuscarNodo(padre.getInfo()) != null) {
            padre.getChildren().add(new Nodo<>(info));
             /*
               Si encuentro el nodo padre al cual le quiero agregar un nodo
               obtengo la lista de hijos y le agrego un nuevo
                 */
        } else {
            System.out.println("El padre no existe"); // Si no está el padre digo que este no existe
        }
    }

    public void eliminarNodo(Nodo<E> root, Nodo<E> nodo_a_eliminar) {
        if (root == null || nodo_a_eliminar == null) return;

        if (root != nodo_a_eliminar) { // Si no es la raíz
            for (Nodo<E> hijo : root.getChildren()) {
                if (hijo == nodo_a_eliminar) {
                    root.getChildren().remove_Obj(nodo_a_eliminar); // Esto es una lista, así que simplemente uso el remove de las listas
                    return;
                } else {
                    /*
                       Si el nodo que estoy analizando en ese momento no es el que quiero eliminar
                       me detengo y ese de manera recursiva le envío como padre de otros y le analizo
                       todos los hijos que tenga (si no tiene ninguno simplemente la función recursiva regresaría
                       por donde nos quedamos) y procede a analizar los nodos por los que se quedó
                      */
                    eliminarNodo(hijo, nodo_a_eliminar);
                }
            }
        } else {
            root = null; // Sería el nodo padre de todo, o raíz
        }
    }

    public boolean isEmpty() {
        return root == null;
    }

}
