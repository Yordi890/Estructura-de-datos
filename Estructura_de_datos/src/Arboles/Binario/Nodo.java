/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package Arboles.Binario;

public class Nodo<E> {

    private E info;
    private Nodo<E> parent, left, right;

    public Nodo(E info, Nodo<E> parent, Nodo<E> right, Nodo<E> left) { // Constructor required
        this.info = info;
        this.parent = parent;
        this.right = right;
        this.left = left;
    }

    public Nodo(E info, Nodo<E> right, Nodo<E> left) { // Constructor
        this(info, null, right, left);
    }

    public Nodo(E info, Nodo<E> parent) { // Constructor
        this(info, parent, null, null);
    }

    public Nodo(E info) { // Constructor
        this(info, null, null, null);
    }

    public E getInfo() {
        return info;
    }

    public void setInfo(E info) {
        this.info = info;
    }

    public Nodo<E> getParent() {
        return parent;
    }

    public void setParent(Nodo<E> parent) {
        this.parent = parent;
    }

    public Nodo<E> getLeft() {
        return left;
    }

    public void setLeft(Nodo<E> left) {
        this.left = left;
    }

    public Nodo<E> getRight() {
        return right;
    }

    public void setRight(Nodo<E> right) {
        this.right = right;
    }
}
