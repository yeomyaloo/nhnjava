package tree.binarysearch;

import java.util.List;

public abstract class Node {

    Integer value;
    Node leftChildNode;
    Node rightChildNode;

    public Node(Integer root){
        this.value = root;
        this.leftChildNode = null;
        this.rightChildNode = null;
    }

    public Node(Node leftChildNode, Node rightChildNode){
        this.leftChildNode = leftChildNode;
        this.rightChildNode = rightChildNode;
    }

    public Node(Integer root, Node leftChildNode, Node rightChildNode) {
        this.value = root;
        this.leftChildNode = leftChildNode;
        this.rightChildNode = rightChildNode;
    }

    public abstract Integer search(Integer value);
    public abstract void getList(List<Integer> list);

    public Integer getValue() {
        return value;
    }

    public Node getLeftChildNode() {
        return this.leftChildNode;
    }

    public Node getRightChildNode() {
        return this.rightChildNode;
    }
}
