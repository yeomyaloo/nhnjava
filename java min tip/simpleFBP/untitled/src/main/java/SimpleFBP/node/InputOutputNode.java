package SimpleFBP.node;

import SimpleFBP.connection.socket.InputSocket;
import SimpleFBP.connection.socket.OutputSocket;
import SimpleFBP.message.Message;

import java.util.NoSuchElementException;

public abstract class InputOutputNode extends ActiveNode{

    private InputSocket[] inputSockets;
    private OutputSocket[] outputSockets;

    public InputOutputNode(int inputCount, int outputCount){
        this.inputSockets = new InputSocket[inputCount];
        this.outputSockets = new OutputSocket[outputCount];
    }

    public int getOutputSocketCount() {
        return this.outputSockets.length;
    }

    public OutputSocket getOutputSocket(int index){
        if (this.outputSockets.length == 0){
            throw new NoSuchElementException();
        }

        return outputSockets[index];
    }

    public int getInputSocketCount(){
        return this.inputSockets.length;
    }

    public InputSocket getInputSocket(int index){
        if (this.inputSockets.length == 0){
            throw new NoSuchElementException();
        }

        return inputSockets[index];
    }

    public void output(Message message) {


    }
}
