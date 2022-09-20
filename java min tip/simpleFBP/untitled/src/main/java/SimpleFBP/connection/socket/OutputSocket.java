package SimpleFBP.connection.socket;

import SimpleFBP.connection.connector.InputConnector;
import SimpleFBP.message.Message;
import SimpleFBP.node.Node;



//입력 소켓은 출력 커넥터와 출력 소켓은 입력 커넥터와 연결
public class OutputSocket extends Socket {

    private InputConnector inputConnector;


    public OutputSocket(Node node) {
        super(node);
    }

    public void plug(InputConnector inputConnector){
        // 입력 커넥터와 출력 소켓 연결



    }

    public void unplug(){

    }

    public void put(Message message){

    }

    public InputSocket getInputSocket(int index) {
        if

        return
    }
}
