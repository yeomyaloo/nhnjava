package sytaxtree;

public class NodeSubtract extends NodeBinaryOperator{

    public NodeSubtract(Node leftChildNode, Node rightChildNode, String operator) {
        super(leftChildNode, rightChildNode, "-");
    }

    public NodeSubtract(Node leftChildNode, Node rightChildNode) {
        super(leftChildNode, rightChildNode);
    }

    public NodeSubtract(String operator){
        super("-");
    }

    public Integer getValue(){
        return leftChildNode.getValue() - rightChildNode.getValue();
    }
}
