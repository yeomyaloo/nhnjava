package simpleFBP2.node;

import SimpleFBP.message.Message;
import simpleFBP2.port.InputPort;

public class InputOutputNode2 extends ActiveNode {
    private final InputPort[] inputPorts;
    private final InputPort[] peerInputPorts;


    protected InputOutputNode2(int inputCount, int outputCount){
        this.inputPorts = new InputPort[inputCount];
        this.peerInputPorts = new InputPort[outputCount];
    }

    public void connect(int index, InputPort port){

    }

    public int getInputPortCount(){
    }



    public InputPort getInputPort(int index){

        if (index > inputPorts.length){
            throw new IndexOutOfBoundsException();
        } else{
            return inputPorts[index];
        }
    }


    public void output(Message message){

    }
}
