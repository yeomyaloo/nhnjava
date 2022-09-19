package SimpleFBP.connection.socket;

import SimpleFBP.message.Message;
import SimpleFBP.connection.connector.OutputConnector;
import SimpleFBP.node.Node;

import java.net.Socket;
import java.util.NoSuchElementException;
import java.util.Queue;

public class InputSocket extends Socket {

    private Queue<Message> messageQueue;
    private OutputConnector outputConnector;

    public InputSocket(Node node) {

    }

    public void plug(OutputConnector outputConnector){
        this.outputConnector = outputConnector;

    }

    public void unplug(){
        this.outputConnector = null;
    }

    public void put(Message message){
        messageQueue.add(message);
    }

    public int getMessageCount(){
        return messageQueue.size();
    }

    public Message getMessage(){
        return messageQueue.remove();
    }


}
