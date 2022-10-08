package algorithm.algorithm.algo_20221008.java.dto.request;

import java.util.LinkedList;
import java.util.List;

public class ReplyListDTO {



    private List<ReplyElementDTO> replies = new LinkedList<>();

    public void addReply(ReplyElementDTO replyElementDTO){
        this.replies.add(replyElementDTO);
    }

    public List<ReplyElementDTO> getReplies() {
        return replies;
    }

    @Override
    public String toString() {
        return "ReplyListDTO{" +
            "replies=" + replies.toString() +
            '}';
    }
}
