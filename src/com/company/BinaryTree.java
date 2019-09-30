package com.company;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {

    Node root;
    long max = 0;

    public void add(long value) {
        root = addRecursively(root, value);
    }

    private Node addRecursively(Node current, long value) {

        Queue<Node> q = new LinkedList<>();
        if (current == null) {
            return new Node(value, true);
        }
        q.add(current);

        while (!q.isEmpty()) {
            Node n = q.remove();
            if (n.left != null) {
                addToQueueUnique(q, n.left);
            } else {
                n.left = new Node(value, false);
                break;
            }
            if (n.right != null) {
                addToQueueUnique(q, n.right);
            } else {
                n.right = new Node(value, n.onRightSide);
                addSharedChildNode(q, n);
                break;
            }
        }
        return current;
    }

    private void addSharedChildNode(Queue<Node> q, Node n) {
        if (!n.onRightSide) {
            Node nr = q.remove();
            nr.left = n.right;
        }
    }

    private void addToQueueUnique(Queue<Node> q, Node node) {
        if (!q.contains(node)) {
            q.add(node);
        }
    }

    public void getMax(Node node, long sum) {
        if (node == null) {
            if(sum > max) {
                max = sum;
            }
            return;
        }
        getMaxByRules(node, sum);
    }


    private void getMaxByRules(Node node, long sum) {
        if (applyOddEvenRule(node, node.left)) {
            getMax(node.left, sum + node.value);

        }

        if (applyOddEvenRule(node, node.right)) {
            getMax(node.right, sum + node.value);
        }
    }

    private boolean applyOddEvenRule(Node node, Node right) {
        return right == null || node.value % 2 == 0 && right.value % 2 != 0 ||
                node.value % 2 != 0 && right.value % 2 == 0;
    }
}
