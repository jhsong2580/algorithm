package algorithm.algorithm.algo_20221008.java;

import dto.request.ReplyListDTO;
import dto.request.SimulateListDTO;
import dto.response.NewRequestsListDTO;
import dto.response.ScoreDTO;
import java.util.Map;
import solution.Solution2;

public class Main {

    private static final String authToken = "5aa414fb4148365c2b5f1917569007a0";
    private static final ApiTemplate apiTemplate = new ApiTemplate();
    private static final int MAX_DATE = 200;
    private static final int PROBLEM_NUMBER = 1;
    private static String authKey; ;
    public static void main(String[] args) {
        authKey = (String) apiTemplate.getAuthToken(authToken, PROBLEM_NUMBER).get("auth_key");
        Solution2 solution = new Solution2(PROBLEM_NUMBER);
        for(int i=1; i<=10000; i++){
            //예약요청 받기
            NewRequestsListDTO requests = apiTemplate.getRequests(authKey);
            solution.settingRequest(requests);

            //예약 요청 답변하기
            ReplyListDTO replyList = solution.getReplyList(i);
            Map reply = apiTemplate.reply(authKey, replyList);

            //체크인시키기
            SimulateListDTO simulateList = solution.getSimulateList(i);
            Map simulate = apiTemplate.simulate(authKey, simulateList);

            if ((Integer) simulate.get("day")>MAX_DATE) {
                break;
            }
        }

        ScoreDTO score = apiTemplate.getScore(authKey);
        System.out.println(score);
    }


}
