package sytaxtree;

import class_interface.number.MyNumber;
public class NodeAddition<T extends MyNumber> extends NodeBinaryOperator<T> {

    public NodeAddition(Node leftChildNode, Node rightChildNode, String operator) {
        super(leftChildNode, rightChildNode, "+");
    }

    @Override
    public Integer getValue() {
        return leftChildNode.getValue();
    }
}
