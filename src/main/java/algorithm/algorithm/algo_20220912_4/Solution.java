package algorithm.algorithm.algo_20220912_4;

public class Solution {

    public String solution(String play_time, String adv_time, String[] logs) {
        String answer = "";
        int[][] timeLogs = new int[logs.length][2];
        int playTime = timeToSec(play_time);
        int advTime = timeToSec(adv_time);
        for (int i = 0; i < logs.length; i++) {
            String[] split = logs[i].split("-");
            timeLogs[i][0] = timeToSec(split[0]);
            timeLogs[i][1] = timeToSec(split[1]);
        }


        return answer;
    }

    private int timeToSec(String time) {
        String[] split = time.split(":");
        return Integer.parseInt(split[0]) * 3600 + Integer.parseInt(split[1]) * 60
            + Integer.parseInt(split[2]);
    }
}
