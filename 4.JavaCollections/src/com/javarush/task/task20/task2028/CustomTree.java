package com.javarush.task.task20.task2028;

import java.io.Serializable;
import java.util.*;

/* 
Построй дерево(1)
*/
public class CustomTree extends AbstractList<String>
        implements List<String>, Cloneable, Serializable {
    int size = 0;
    Node<String> root = new Node<>("0", null);
    Node<String> parent = root;

    public static void main(String[] args) {
        List<String> list = new CustomTree();
        for (int i = 1; i < 16; i++) {
            list.add(String.valueOf(i));
        }
        System.out.println("Expected 3, actual is " + ((CustomTree) list).getParent("8"));
        list.remove("5");
        System.out.println("Expected null, actual is " + ((CustomTree) list).getParent("11"));
    }

    public Node<String> findNode(String value) {
        Queue<Node<String>> wholeTree = getSubTree(root);
        for (Node<String> node : wholeTree) {
            if (node.value == null) {
                return null;
            }
            if (node.value.equals(value)) {
                return node;
            }
        }
        return null;
    }

    public Queue<Node<String>> getSubTree(Node<String> top) {
        Queue<Node<String>> queue = new LinkedList<>();
        Queue<Node<String>> subTree = new LinkedList<>();
        if (top != root) {
            subTree.add(top);
        }
        do {
            if (top.left != null) {
                queue.add(top.left);
            }
            if (top.right != null) {
                queue.add(top.right);
            }
            if (!queue.isEmpty()) {
                top = queue.poll();
            }
            if (!subTree.contains(top)) {
                subTree.add(top);
            }
        }
        while (!queue.isEmpty());
        return subTree;
    }

    @Override
    public boolean remove(Object value) {
        Queue<Node<String>> queueForRemove = getSubTree(findNode((String) value));
        parent = findNode((String) value).parent;
        for (Node<String> node : queueForRemove) {
            if (node.parent != null && node.left != null) {
                node.parent.left = null;
            } else if (node.parent != null) {
                node.parent.right = null;
            }
            size--;
        }
        return true;
    }

    public String getParent(String value) {
        Node<String> searchingNode = findNode(value);
        if (searchingNode == null) {
            return null;
        }
        return (searchingNode.parent == null) ? null : searchingNode.parent.value;
    }

    @Override
    public boolean add(String value) {
        Node<String> newNode = new Node<>(value, parent);
        if (parent.left == null) {
            newNode.parent = parent;
            parent.left = newNode;
            size++;
        } else if (parent.right == null) {
            newNode.parent = parent;
            parent.right = newNode;
            size++;
        } else {
            Queue<Node<String>> wholeTree = getSubTree(root);
            for (Node<String> node : wholeTree) {
                if (node.left == null || node.right == null) {
                    parent = node;
                    break;
                }
            }
            add(value);
        }
        return true;
    }

    private static class Node<String> {
        String value;
        Node<String> parent, left, right;

        private Node(String value, Node<String> parent) {
            this.value = value;
            this.parent = parent;
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String get(int index) {
        throw new UnsupportedOperationException();
    }
}