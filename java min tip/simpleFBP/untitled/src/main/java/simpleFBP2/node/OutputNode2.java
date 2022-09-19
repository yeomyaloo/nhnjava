package simpleFBP2.node;

import simpleFBP2.node.ActiveNode;
import simpleFBP2.port.InputPort;

public class OutputNode2 extends ActiveNode {
    protected InputPort[] inputPorts;
    protected OutputNode2(int count){

    }

    public int getInputPortCount(){
        return inputPorts.length;
    }

    public InputPort getInputPort(int index) {
        return inputPorts[index];
    }

}
