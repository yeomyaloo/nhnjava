package simpleFBP2.node;

import SimpleFBP.message.Message;
import simpleFBP2.port.InputPort;

public class InputNode2 extends ActiveNode {
    private final InputPort [] peerInputPorts;

    public InputNode2(int count) {
        this.peerInputPorts = new InputPort[count];
    }

    public void connect(int index, InputPort port){
        connect(0, port);
    }

    public void output(Message message){

    }
}
