package com.company;

class Node {

    int value;
    Node left;
    Node right;
    boolean onRightSide;

    Node(int value, boolean onRightSide) {
        this.value = value;
        right = null;
        left = null;
        this.onRightSide = onRightSide;
    }
}