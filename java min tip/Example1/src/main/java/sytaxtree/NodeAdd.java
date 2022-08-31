package sytaxtree;

import class_interface.number.MyNumber;

public class NodeAdd extends NodeBinaryOperator<MyNumber> {

    public NodeAdd(Node leftChildNode, Node rightChildNode, String operator) {
        super(leftChildNode, rightChildNode, "+");
    }


    public NodeAdd(Node leftChildNode, Node rightChildNode) {
        super(leftChildNode,rightChildNode);
    }



    @Override
    public Integer getValue() {
        return leftChildNode.getValue() + rightChildNode.getValue();
    }


}
