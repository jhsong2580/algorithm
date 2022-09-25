package algorithm.algorithm.algo_20220924_1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    public int[] solution(String today, String[] terms, String[] privacies) {
        int[] todayDate = dateToList(today);
        Map<String, Integer> termsInfo = new HashMap<>();
        List<int[]> privacyInfo = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        for (String term : terms) {
            String[] info = term.split(" ");
            termsInfo.put(info[0], Integer.parseInt(info[1]));
        }
        for (String privacy : privacies) {
            String[] info = privacy.split(" ");
            String date = info[0];
            String term = info[1];
            privacyInfo.add(plusMonth(dateToList(date), termsInfo.get(term)));
        }

        for(int i=0;i<privacyInfo.size(); i++){
            if (isNotValid(todayDate, privacyInfo.get(i))) {
                result.add(i+1 );
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    private boolean isNotValid(int[] today, int[] target) {
        int todayDates = (today[0] - 1) * 12 * 28 + (today[1] - 1) * 28 + today[2];
        int targetDates = (target[0] - 1) * 12 * 28 + (target[1] - 1) * 28 + target[2];
        return todayDates > targetDates;

    }

    private int[] plusMonth(int[] date, int plusMonth) {
        date[1] = date[1] + plusMonth;
        date[2] = date[2] - 1;
        if (date[2] < 1) {
            date[2] = 28;
            date[1] = date[1] - 1;
        }
        if (date[1] < 1) {
            date[1] = 12;
            date[0] = date[0] - 1;
        }
        if (date[1] > 12) {
            int plusYear = date[1] / 12;
            date[1] = date[1] - 12 * plusYear;
            date[0] = date[0] + plusYear;
        }
        return date;
    }

    private int[] dateToList(String date) {
        int[] dateInfo = new int[3];
        String[] split = date.split("\\.");
        for (int i = 0; i < split.length; i++) {
            dateInfo[i] = Integer.parseInt(split[i]);
        }
        return dateInfo;
    }
}
