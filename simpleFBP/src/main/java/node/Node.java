package node;

import java.util.logging.Logger;

public abstract class Node {

    private static Integer count;
    private final String id;
    private String name;
    private Logger logger;

    public Node(){
        this.count = 0;
        this.id = String.valueOf(count);
        this.name = "user" + count;
    }

    public Node(String name) {
        this.count = 0;
        this.id = String.valueOf(count);
        this.name = name;
    }

    public static Integer getCount() {
        return count;
    }

    public static void setCount(Integer count) {
        Node.count = count;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Logger getLogger() {
        return logger;
    }

    public void setLogger(Logger logger) {
        this.logger = logger;
    }
}
