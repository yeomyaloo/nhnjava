package SimpleFBP.connection.wire;

import SimpleFBP.connection.connector.InputConnector;
import SimpleFBP.connection.connector.OutputConnector;
import SimpleFBP.message.Message;
import SimpleFBP.connection.socket.InputSocket;
import SimpleFBP.connection.socket.OutputSocket;
import SimpleFBP.node.Node;

import java.util.logging.Logger;

public class Wire implements InputConnector, OutputConnector {
    private static int count = 0;
    private final String id;
    private OutputSocket outputSocket;
    private InputSocket inputSocket;

    private Logger logger;

    public Wire() {
        this.id = getId();
    }

    public String getId() {
        return id;
    }
    public void connect(InputSocket inputSocket){
        //connect = 양 끝단을 의미하고 소켓과 연결되는 인터페이스이다.
        this.inputSocket = inputSocket;


    }
    public void disconnect(InputSocket inputSocket){
        this.inputSocket = null;
    }
    public void connect(OutputSocket outputSocket){
        this.outputSocket = outputSocket;
    }
    public void disconnect(OutputSocket outputSocket){
        this.outputSocket= null;
    }

    @Override
    public void put(Message message){
        //출력노드의 입력 소켓으로..
    }

    public Logger getLogger() {
        return logger;
    }
}
