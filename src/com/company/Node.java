package com.company;

class Node {

    long value;
    Node left;
    Node right;
    boolean onRightSide;

    Node(long value, boolean onRightSide) {
        this.value = value;
        right = null;
        left = null;
        this.onRightSide = onRightSide;
    }
}