/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package Arboles.Binario;

public class Test {


    public static void main(String[] args) {
        Binary_Tree<Integer> tree = new Binary_Tree<>(new Nodo<>(5));

        tree.add(4, false, tree.getRoot());
        tree.add(6, true, tree.getRoot().getLeft());

        tree.remove(tree.getRoot().getLeft());


    }


}
