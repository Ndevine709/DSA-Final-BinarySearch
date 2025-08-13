package com.dsa;

import jakarta.persistence.*;

@Entity
public class BinaryNode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int value;

    @OneToOne(cascade = CascadeType.ALL)
    private BinaryNode left;

    @OneToOne(cascade = CascadeType.ALL)
    private BinaryNode right;

    // Default constructor required by JPA
    public BinaryNode() {
    }

    // Constructor with value
    public BinaryNode(int value) {
        this.value = value;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public BinaryNode getLeft() {
        return left;
    }

    public void setLeft(BinaryNode left) {
        this.left = left;
    }

    public void setRight(BinaryNode right) {
        this.right = right;
    }

    public BinaryNode getRight() {
        return right;
    }

    // Helper method to check if node is a leaf
    public boolean isLeaf() {
        return left == null && right == null;
    }

    // Helper method to check if node has children
    public boolean hasChildren() {
        return left != null || right != null;
    }

    // Override toString for debugging
    @Override
    public String toString() {
        return "BinaryNode{" +
                "id=" + id +
                ", value=" + value +
                ", left=" + (left != null ? left.getValue() : "null") +
                ", right=" + (right != null ? right.getValue() : "null") +
                '}';
    }
}