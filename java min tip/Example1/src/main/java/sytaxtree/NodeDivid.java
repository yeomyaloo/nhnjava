package sytaxtree;

import class_interface.number.MyNumber;

public class NodeDivid extends NodeBinaryOperator<MyNumber> {
    public NodeDivid(Node leftChildNode, Node rightChildNode, String operator) {
        super(leftChildNode, rightChildNode, "/");
    }

    @Override
    public Integer getValue() {
        return leftChildNode.getValue() / rightChildNode.getValue();
    }
}
