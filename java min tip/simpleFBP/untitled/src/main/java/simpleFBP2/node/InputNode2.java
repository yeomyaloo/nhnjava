package simpleFBP2.node;

import simpleFBP2.port.InputPort;

public class InputNode2 extends ActiveNode {
    private final InputPort[] peerInputPorts;
    protected InputNode2(int count) {
        this.peerInputPorts = new InputPort[count];
    }

    public int getInputPortCount(){
        return peerInputPorts.length;
    }

    public InputPort getInputPort(int index){
        if (index > peerInputPorts.length) {
            throw new IndexOutOfBoundsException();
        } else {
            return peerInputPorts[index];
        }
    }

}
