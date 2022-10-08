package algorithm.algorithm.algo_20221008.java.dto.request;

public class ReplyElementDTO {
    private int id;
    private String reply;

    protected ReplyElementDTO() {
    }

    public ReplyElementDTO(int id) {
        this.id = id;
    }

    public void requestAccept(){
        this.reply = "accepted";
    }

    public void requestRefuse(){
        this.reply = "refused";
    }

    public int getId() {
        return id;
    }

    public String getReply() {
        return reply;
    }

    @Override
    public String toString() {
        return "ReplyElementDTO{" +
            "id=" + id +
            ", reply='" + reply + '\'' +
            '}';
    }
}
