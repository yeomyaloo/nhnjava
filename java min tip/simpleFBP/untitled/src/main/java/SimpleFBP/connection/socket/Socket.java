package SimpleFBP.connection.socket;

import SimpleFBP.node.Node;

import java.util.logging.Logger;

public class Socket {
    private static int count = 0;
    private String id;
    protected Node node;
    private Logger logger;

    public Socket(Node node) {
        this.node = node;
    }

    public String getId() {
        return id;
    }

    public Logger getLogger() {
        return logger;
    }
}
