package algorithm.algorithm.algo_20220909_1;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        Set<String> report_nonDup = Arrays.stream(report).collect(Collectors.toSet());
        Map<String, List<String>> reportPerPerson = new LinkedHashMap<>();
        Map<String, Integer> reportSuccessCount = new LinkedHashMap<>();
        for (String id : id_list) {
            reportPerPerson.put(id, new LinkedList<>());
            reportSuccessCount.put(id, 0);
        }
        for (String reportInfo : report_nonDup) {
            String reporter = reportInfo.split(" ")[0];
            String target = reportInfo.split(" ")[1];
            reportPerPerson.get(target).add(reporter);
        }
        for (List<String> reporters : reportPerPerson.values()) {
            if(reporters.size() >= k){
                for (String reporter : reporters) {
                    reportSuccessCount.put(reporter, reportSuccessCount.get(reporter) + 1);
                }
            }
        }

        int i = 0;
        for (Integer value : reportSuccessCount.values()) {
            answer[i++] = value;
        }

        return answer;
    }
}
