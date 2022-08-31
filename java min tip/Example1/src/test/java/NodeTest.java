import sytaxtree.*;

public class NodeTest {



    public static void main(String[] args) {
        Node ex = new NodeConstant(1);
        Node ex2 = new NodeConstant(2);
        Node ex3 = new NodeConstant(3);



        Node node = new NodeAdd(ex,ex2);
        System.out.println(node);

        String[] expression = {"1", "-", "2", "+","3"};
        for(String token: expression) {
            if (token.equals("+")) {
                operator = token;
            } else if (token.equals("-")){
                operator = token;
            } else {
                if (leftOperand == null){
                    leftOperand = new NodeConstant(Integer.valueOf(token));
                }
                else{
                    Node rightOperand = new NodeConstant(Integer.valueOf(token));
                    if (operator.equals("+")){
                        leftOperand = new NodeAdd(leftOperand, rightOperand);
                    } else if (operator.equals("-")){
                        leftOperand = new NodeSubtract(leftOperand, rightOperand);
                    }
                }
            }
            System.out.println(leftOperan + " = " + leftOperand.getValue());
        }
    }
}
