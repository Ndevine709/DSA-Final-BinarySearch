package com.dsa;

public class BinarySearchTree {
    private BinaryNode root;

    public BinarySearchTree() {
        root = null;
    }

    public void insert(int value) {
        root = insertRec(root, value);
    }

    private BinaryNode insertRec(BinaryNode node, int value) {
        if (node == null) {
            return new BinaryNode(value);
        }

        if (value < node.getValue()) {
            node.setLeft(insertRec(node.getLeft(), value));
        } else if (value > node.getValue()) {
            node.setRight(insertRec(node.getRight(), value));
        }

        return node;
    }

    public BinaryNode getRoot() {
        return root;
    }

    public void inorder() {
        inorderRec(root);
    }

    private void inorderRec(BinaryNode node) {
        if (node != null) {
            inorderRec(node.getLeft());
            System.out.print(node.getValue() + " ");
            inorderRec(node.getRight());
        }
    }
}
