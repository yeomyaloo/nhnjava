package SimpleFBP.message;

public class Message {
    private Integer count;
    private final String id;
    private final long creationTime;
    private Object payload;

    public Message() {
        this.id = getId();
        this.creationTime = getCreationTime();
    }

    public Message(Object payload) {
        this.payload = payload;
        this.id = getId();
        this.creationTime = getCreationTime();

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
