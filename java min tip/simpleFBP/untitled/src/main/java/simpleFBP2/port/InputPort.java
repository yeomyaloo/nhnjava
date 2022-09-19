package simpleFBP2.port;

import SimpleFBP.message.Message;
import SimpleFBP.node.InputNode;
import SimpleFBP.node.Node;
import SimpleFBP.node.OutputNode;

import java.lang.reflect.Member;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.concurrent.locks.Lock;

public class InputPort {
    Node node;
    Queue<Message> messageQueue;
    Lock locker;

    public InputPort(Node node){
        this.node = node;
        this.messageQueue = null;

    }



    public void put(Message message){
        messageQueue.add(message);
    }

    public boolean hasMessage(){
        return !(messageQueue.isEmpty());
    }

    public Message get(){

        if (messageQueue.isEmpty()){
            throw new NoSuchElementException();
        }
        return messageQueue.peek();
    }

    public void remove(){
        if (messageQueue.isEmpty()){
            throw new NoSuchElementException();
        }

        messageQueue.remove();
    }

}
