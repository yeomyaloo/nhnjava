package SimpleFBP.node;

import java.util.logging.Logger;

public abstract class Node {
    private static Integer count;
    private final String id;
    private String name;
    private Logger logger;


    public Node() {
        this.id = getId();
    }

    public Node(String name) {
        this.id = getId();
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public static Integer getCount() {
        return count;
    }

    public static void setCount(Integer count) {
        Node.count = count;
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
