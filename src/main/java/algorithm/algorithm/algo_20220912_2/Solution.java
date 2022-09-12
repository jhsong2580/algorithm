package algorithm.algorithm.algo_20220912_2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    HashMap<String, List<Integer>> index = new HashMap();
    List<Integer> result = new LinkedList<>();

    public int[] solution(String[] info, String[] query) {
        String[][] info_split = new String[info.length][5];
        String[][] query_split = new String[query.length][5];
        LinkedList<Integer> result = new LinkedList<>();
        init(info, query, info_split, query_split);

        for (String[] infos : info_split) {
            dfs(infos, 0, "");
        }
        for (String key : index.keySet()) {
            Collections.sort(index.get(key));
        }
        for (String[] strings : query_split) {
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < strings.length - 1; i++) {
                builder.append(strings[i]);
            }
            List<Integer> scores = index.get(builder.toString());
            if (scores == null) {
                result.add(0);
                continue;
            }

            int targetScore = strings[strings.length - 1].equals("-") ? 0
                : Integer.parseInt(strings[strings.length - 1]);

            int start = 0;
            int end = scores.size() - 1;
            while (start <= end) {
                int mid = (start + end)/2;
                if (scores.get(mid) < targetScore) {
                    start = mid +1;
                } else if (scores.get(mid) >= targetScore) {
                    end = mid -1;
                }
            }
            result.add(scores.size() - start);
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    private void dfs(String[] source, int layer, String key) {
        if (layer == source.length - 1) {
            if (index.containsKey(key)) {
                index.get(key).add(Integer.parseInt(source[source.length - 1]));
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(Integer.parseInt(source[source.length - 1]));
                index.put(key, list);
            }
            return;
        }
        dfs(source, layer + 1, key + "-");
        dfs(source, layer + 1, key + source[layer]);

    }

    private void init(String[] info, String[] query, String[][] info_split,
        String[][] query_split) {
        for (int j = 0; j < info.length; j++) {
            String[] split = info[j].split(" ");
            for (int i = 0; i < split.length; i++) {
                info_split[j][i] = split[i].trim();
            }
        }

        for (int i = 0; i < query.length; i++) {
            String[] split = query[i].split("and");
            for (int j = 0; j < split.length - 1; j++) {
                query_split[i][j] = split[j].trim();
            }
            String[] lastInfo = split[split.length - 1].trim().split(" ");
            query_split[i][3] = lastInfo[0].trim();
            query_split[i][4] = lastInfo[1].trim();
        }
    }
}
