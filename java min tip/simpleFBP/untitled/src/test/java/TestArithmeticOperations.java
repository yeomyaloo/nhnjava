import simpleFBP2.node.AdditionNode2;
import simpleFBP2.node.InputNode2;
import simpleFBP2.node.RNGNode2;
import simpleFBP2.node.StandardOutNode2;
import sun.net.ftp.FtpClient;

public class TestArithmeticOperations {
    public static void main(String[] args) {
        int interval = 1000;

        RNGNode2 v1 = new RNGNode2(interval);
        RNGNode2 v2 = new RNGNode2(interval);

        AdditionNode2 additionNode = new AdditionNode2();

        StandardOutNode2 outNode = new StandardOutNode2();


        InputNode2 inNode1 = new InputNode2(interval);
        InputNode2 inNode2 = new InputNode2(interval);

        inNode1.connect(0,additionNode.getInputPort(0));
        inNode2.connect(0,additionNode.getInputPort(1));


        additionNode.connect(0,outNode.getInputPort);
    }

}
