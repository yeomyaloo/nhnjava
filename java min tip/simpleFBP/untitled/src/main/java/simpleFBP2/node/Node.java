package simpleFBP2.node;

import java.util.UUID;
import java.util.logging.Logger;

public abstract class Node {
    private final String id;
    private String name;
    private Logger logger;
    private Integer Count;

    public Node(){

        UUID uuid = UUID.randomUUID();
        this.id = String.valueOf(uuid);
        this.name = "user"+uuid;
    }

    public Node(String name) {
        this.name = name;
        UUID uuid = UUID.randomUUID();
        this.id = String.valueOf(uuid);
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

    public Integer getCount() {
        return Count;
    }

    public void setCount(Integer count) {
        Count = count;
    }

    public String getId() {
        return id;
    }
}
