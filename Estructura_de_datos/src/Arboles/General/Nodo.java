/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package Arboles.General;

import Listas.Simple_Enlazada.Simple_Enlazada;

public class Nodo<E> {

    private E info;

    private Simple_Enlazada<Nodo<E>> children; // Estos serían todos los nodos que puedan ser hijos de un nodo

    public Nodo(E info) {
        this.info = info;
        this.children = new Simple_Enlazada<>();
    }


    public Nodo(E info, Simple_Enlazada<Nodo<E>> children) {
        this.info = info;
        this.children = children;
    }

    public E getInfo() {
        return info;
    }

    public void setInfo(E info) {
        this.info = info;
    }

    public Simple_Enlazada<Nodo<E>> getChildren() {
        return children;
    }

    public void setChildren(Simple_Enlazada<Nodo<E>> children) {
        this.children = children;
    }
}
