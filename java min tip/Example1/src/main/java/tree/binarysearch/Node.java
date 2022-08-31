package tree.binarysearch;

import java.util.List;

public abstract class Node<T,K> implements Comparable<K> {

    T value;
    Node leftChildNode;
    Node rightChildNode;

    public Node(T root){
        this.value = root;
        this.leftChildNode = null;
        this.rightChildNode = null;
    }

    public Node(Node leftChildNode, Node rightChildNode){
        this.leftChildNode = leftChildNode;
        this.rightChildNode = rightChildNode;
    }

    public Node(T root, Node leftChildNode, Node rightChildNode) {
        this.value = root;
        this.leftChildNode = leftChildNode;
        this.rightChildNode = rightChildNode;
    }

    public abstract T search(T value);
    public abstract void getList(List<T> list);

    public abstract void add(Node node);
    public abstract void remove(K key);

    public T getValue() {
        return this.value;
    }

    public Node getLeftChildNode() {
        return this.leftChildNode;
    }

    public Node getRightChildNode() {
        return this.rightChildNode;
    }
}
