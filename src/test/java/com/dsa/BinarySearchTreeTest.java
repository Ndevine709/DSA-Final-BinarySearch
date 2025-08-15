package com.dsa;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

public class BinarySearchTreeTest {
    private BinarySearchTree bst;

    @BeforeEach
    public void setUp() {
        bst = new BinarySearchTree();
    }

    @Test
    public void testBstInsertion() {
        bst.insert(10);
        bst.insert(5);
        bst.insert(15);

        BinaryNode root = bst.getRoot();

        assertNotNull(root);
        assertEquals(10, root.getValue());

        assertNotNull(root.getLeft());
        assertEquals(5, root.getLeft().getValue());

        assertNotNull(root.getRight());
        assertEquals(15, root.getRight().getValue());
    }

    @Test
    public void testEmptyBst() {
        BinaryNode root = bst.getRoot();
        assertNull(root);

        bst.insert(42);
        root = bst.getRoot();

        assertNotNull(root);
        assertEquals(42, root.getValue());
        assertNull(root.getLeft());
        assertNull(root.getRight());
    }

    @Test
    public void testSequentialNumbers() {
        bst.insert(1);
        bst.insert(2);
        bst.insert(3);
        bst.insert(4);
        bst.insert(5);

        BinaryNode root = bst.getRoot();
        
        assertEquals(1, root.getValue());
        assertEquals(2, root.getRight().getValue());
        assertEquals(3, root.getRight().getRight().getValue());
        assertEquals(4, root.getRight().getRight().getRight().getValue());
        assertEquals(5, root.getRight().getRight().getRight().getRight().getValue());
}


}
