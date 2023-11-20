public class Message {
    private String id;
    private String msg;

    public Message(String id, String msg) {
        this.id = id;
        this.msg = msg;
    }

    public String getId() {
        return id;
    }

    public String getMessage() {
        return msg;
    }
}
