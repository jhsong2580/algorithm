package algorithm.algorithm.algo_20220912_4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {

    public String solution(String play_time, String adv_time, String[] logs) {
        String answer = "";
        List<Long> startWatch = new ArrayList<>();
        List<Long> endWatch = new ArrayList<>();
        Long playTime = timeToSec(play_time);
        Long advTime = timeToSec(adv_time);
        for (int i = 0; i < logs.length; i++) {
            String[] split = logs[i].split("-");
            startWatch.add(timeToSec(split[0]));
            endWatch.add(timeToSec(split[1]));
        }
        Collections.sort(startWatch);
        Collections.sort(endWatch);

        Long maxTime = 0L;
        Long advStartTime = 0L;
        Long curViewTime = 0L;
        int startIndex = 0;
        int endIndex = 0;
        int backStartIndex = 0;
        int backEndIndex = 0;
        int curViewer = 0;
        int outViewer = 0;

        for (Long curTime = 0L; curTime <= advTime; curTime++) {
            while (startIndex < startWatch.size() && curTime >= startWatch.get(startIndex)) {
                curViewer++;
                startIndex++;
            }
            while (endIndex < endWatch.size() && curTime >= endWatch.get(endIndex)) {
                curViewer--;
                endIndex++;
            }
            curViewTime += curViewer;
        }
        maxTime = curViewTime;
        for (Long curTime = advTime + 1; curTime <= playTime; curTime++) {
            if (startIndex == startWatch.size() && endIndex == endWatch.size()) {
                break;
            }
            while (startIndex < startWatch.size() && curTime >= startWatch.get(startIndex)) {
                curViewer++;
                startIndex++;
            }
            while (endIndex < endWatch.size() && curTime >= endWatch.get(endIndex)) {
                curViewer--;
                endIndex++;
            }

            while (backStartIndex < startWatch.size() && curTime - advTime >= startWatch.get(
                backStartIndex)) {
                outViewer++;
                backStartIndex++;
            }
            while (backEndIndex < endWatch.size() && curTime - advTime >= endWatch.get(backEndIndex)) {
                outViewer--;
                backEndIndex++;
            }
            curViewTime = curViewTime + curViewer - outViewer;

            if (maxTime < curViewTime) {
                maxTime = curViewTime;
                advStartTime = curTime - advTime + 1;
            }
        }
        return setToTime(advStartTime);
    }

    private Long timeToSec(String time) {
        String[] split = time.split(":");
        return Long.parseLong(split[0]) * 3600 + Long.parseLong(split[1]) * 60
            + Long.parseLong(split[2]);
    }

    private String setToTime(Long sec) {
        Long hour = sec / 3600;
        String hour_string = String.valueOf(hour);
        hour_string = hour_string.length() == 1 ? "0" + hour_string : hour_string;
        Long minute = (sec - hour * 3600) / 60;
        String minute_string = String.valueOf(minute);
        minute_string = minute_string.length() == 1 ? "0" + minute_string : minute_string;
        Long second = sec - hour * 3600 - minute * 60;
        String second_string = String.valueOf(second);
        second_string = second_string.length() == 1 ? "0" + second_string : second_string;
        return  hour_string+ ":" + minute_string + ":" + second_string;

    }
}
