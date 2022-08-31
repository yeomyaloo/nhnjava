package sytaxtree;

import class_interface.number.MyNumber;

public abstract class NodeBinaryOperator<T extends MyNumber> extends Node{
    Node leftChildNode;
    Node rightChildNode;
    String operator;

    public NodeBinaryOperator(Node leftChildNode, Node rightChildNode, String operator) {
        this.leftChildNode = leftChildNode;
        this.rightChildNode = rightChildNode;
        this.operator = operator;
    }

    public NodeBinaryOperator(Node leftChildNode, Node rightChildNode) {
        this.leftChildNode = leftChildNode;
        this.rightChildNode = rightChildNode;
    }

    public NodeBinaryOperator(String s) {
        super();
    }

    public Node getLeftChildNode() {
        return this.leftChildNode;
    }

    public Node getRightChildNode() {
        return this.rightChildNode;
    }

    public String getOperator() {
        return this.operator;
    }

    @Override
    public Integer getValue() {
        return null;
    }

    @Override
    public Integer getChileNodeCount() {

        int cnt = 0;

        if(this.leftChildNode != null) {
            cnt += this.leftChildNode.getChileNodeCount();
        }
        if(this.rightChildNode != null) {
            cnt += this.rightChildNode.getChileNodeCount();
        }

        return cnt;
    }

    @Override
    public String toString() {
        return "(" + getOperator() + " " + this.getLeftChildNode() + " " + this.getRightChildNode() + ")";
    }
}
