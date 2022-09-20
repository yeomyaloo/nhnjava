package simpleFBP2.node;

import SimpleFBP.message.Message;
import org.w3c.dom.NodeList;
import simpleFBP2.port.InputPort;

import java.net.Socket;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;


public class InputOutputNode2 extends ActiveNode {

    Socket
    public static void main(String[] args) {

        List list = new ArrayList<Integer>();
        List list2 = new LinkedList<Integer>();

        list.add(3);
        list2.add(3);

        System.out.println(list2);
        System.out.println(list);
    }

    private final InputPort[] inputPorts;
    private final InputPort[] peerInputPorts;


    protected InputOutputNode2(int inputCount, int outputCount){
        this.inputPorts = new InputPort[inputCount];
        this.peerInputPorts = new InputPort[outputCount];
    }

    public void connect(int index, InputPort port){
        connect(0,getInputPort(0));
    }

    public int getInputPortCount(){
        int cnt = 0;

        if (inputPorts == null || inputPorts.length == 0){
            throw new NoSuchElementException();
        }

        for (int i = 0; i < inputPorts.length; i++){
            if (inputPorts[i] != null){
                cnt ++;
            }
        }
        return cnt;

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
