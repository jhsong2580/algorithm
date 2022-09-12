package algorithm.algorithm.algo_20220912_3;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Solution {
    private Map<String, Integer> countPerMenu;
    private Map<Integer, List<String>> result;
    public String[] solution(String[] orders, int[] course) {
        String[] answer = {};
        Map<Integer, Integer> max = new HashMap<>();
        Map<Integer, List<String>> max_source = new HashMap<>();
        ;
        for(int i= 0;i<course.length; i++){
            max.put(course[i], -1);
            max_source.put(course[i], new LinkedList<>());
        }
        countPerMenu = new HashMap<>();
        result = new HashMap<>();
        for (String order : orders) {
            for (int limit : course) {
                dfs(order, 0, "", limit);
            }
        }

        for (String key : countPerMenu.keySet()) {
            if (countPerMenu.get(key) < 2) {
                continue;
            }
            int thisCourse = key.length();
            if(countPerMenu.get(key) > max.get(thisCourse)){
                max.put(thisCourse, countPerMenu.get(key));
                List newSource = new LinkedList();
                newSource.add(key);
                max_source.put(thisCourse, newSource);
            }else if (countPerMenu.get(key) == max.get(thisCourse)){
                max_source.get(thisCourse).add(key);
            }
        }

        LinkedList<String> result = new LinkedList<>();
        for (List<String> value : max_source.values()) {
            for (String s : value) {
                result.add(s);
            }
        }
        Collections.sort(result);

        return result.stream().toArray(String[]::new);

    }

    private void dfs(String order, int index, String key, int limit) {
        if (key.length() == limit) {
            key = sort(key);
            if(countPerMenu.containsKey(key)){
                countPerMenu.put(key, countPerMenu.get(key) + 1);
            }else{
                countPerMenu.put(key, 1);
            }
            return;
        }
        if(index == order.length()){
            return;
        }
        dfs(order, index + 1, key, limit);
        dfs(order, index + 1, key + order.charAt(index), limit);
    }
    private String sort(String a){
        char[] chars = a.toCharArray();
        for(int i = 0; i<chars.length; i++){
            for(int j = 0; j<chars.length; j++){
                if (chars[i] < chars[j]) {
                    char temp = chars[i];
                    chars[i] = chars[j];
                    chars[j] = temp;
                }
            }
        }
        return String.valueOf(chars);
    }
}
