package simpleFBP2.message;

import java.util.UUID;

public class Message {
    private static Integer count;
    private final String id;
    private final long creationTime;
    private Object payload;

    public Message(){
        this.count = 0;
        this.id = null;
        this.creationTime = System.currentTimeMillis();
    }
    public Message(Object payload){
        this.count = 0;
        this.id = null;
        this.creationTime = System.currentTimeMillis();
        this.payload = payload;
    }

    public String getId() {
        return id;
    }

    public long getCreationTime() {
        return creationTime;
    }

    public Object getPayload() {
        return payload;
    }

    public void setPayload(Object payload) {
        this.payload = payload;
    }
}
