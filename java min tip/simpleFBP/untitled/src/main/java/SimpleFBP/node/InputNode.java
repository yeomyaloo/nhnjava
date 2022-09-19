package SimpleFBP.node;

import SimpleFBP.message.Message;
import SimpleFBP.connection.socket.OutputSocket;

import java.util.NoSuchElementException;

public abstract class InputNode extends ActiveNode{
    private OutputSocket[] outputSockets;


    public InputNode(int count){
        this.outputSockets = new OutputSocket[count];
    }


    public int getOutputSocketCount(){
        return outputSockets.length;
    }

    public OutputSocket getOutputSocket(int index){
        if (outputSockets == null){
            throw new NoSuchElementException();
        }

        return outputSockets[index];
    }

    public void output(Message message){
        System.out.println(message);
    }

    public void main(){

    };
}
