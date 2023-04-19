/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package Arboles.General;

/**
 * @author Yordanis Tejeda Rodríguez
 */
public class Test {

    public static void main(String[] args) {

        Tree<Integer> tree = new Tree<>(new Nodo<>(5));

        tree.add_Nodo(6, tree.getRoot());
        tree.add_Nodo(8, tree.getRoot().getChildren().get(0));
        tree.add_Nodo(10, tree.getRoot().getChildren().get(0));
        tree.add_Nodo(2, tree.getRoot().getChildren().get(0));

        tree.eliminarNodo(tree.getRoot().getChildren().get(0), tree.getRoot().getChildren().get(0).getChildren().get(1));


        System.out.println("Hello");
    }
}
