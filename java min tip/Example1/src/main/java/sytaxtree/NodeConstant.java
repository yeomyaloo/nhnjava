package sytaxtree;

import class_interface.number.MyNumber;

public class NodeConstant extends NodeBinaryOperator<MyNumber> {
    Integer value;

    public NodeConstant(Integer value) {
        super();
        this.value = value;
    }

    public NodeConstant(Node leftChildNode, Node rightChildNode, String operator) {
        super(leftChildNode, rightChildNode, operator);
    }



}
