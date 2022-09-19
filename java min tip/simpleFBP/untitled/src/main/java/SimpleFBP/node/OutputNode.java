package SimpleFBP.node;

import SimpleFBP.connection.socket.InputSocket;

public abstract class OutputNode extends ActiveNode{
    protected InputSocket [] inputSockets;

    public OutputNode(int count) {
        this.inputSockets = new InputSocket[count];
    }

    public int getInputSocketCount(){
        return inputSockets.length;
    }

    public InputSocket getInputSocket(int index){

        if (inputSockets == null) {
            throw new IndexOutOfBoundsException();
        }
        return inputSockets[index];
    }


}
