package algorithm.algorithm.algo_20220923_1;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    private Map<Character, Integer> maxCount;
    private Map<Character, Integer> cutLine;
    public String minWindow(String s, String t) {
        maxCount = new HashMap<>();
        cutLine = new HashMap<>();
        for(int i=0;i<t.length(); i++){
            cutLine.put(t.charAt(i), 0);
            maxCount.put(t.charAt(i), 0);
        }
        for(int i=0; i<t.length();i++){
            char curChar = t.charAt(i);
            cutLine.put(curChar, cutLine.get(curChar) + 1);
        }
        for(int i=0; i<s.length(); i++){
            char curChar = s.charAt(i);
            if(maxCount.containsKey(curChar)){
                maxCount.put(curChar, maxCount.get(curChar) + 1);
            }
        }

        int start = 0;
        int end = s.length() -1;
        String answer="";
        while(start<=end){
            char startChar = s.charAt(start);
            char endChar = s.charAt(end);
            if (!cutLine.containsKey(startChar)) {
                start++;
                continue;
            }
            if (cutLine.containsKey(startChar) && maxCount.get(startChar) > cutLine.get(
                startChar)) {
                start++;
                maxCount.put(startChar, maxCount.get(startChar) - 1);
                continue;
            }
            if (!cutLine.containsKey(endChar)) {
                end--;
                continue;
            }
            if (cutLine.containsKey(endChar) && maxCount.get(endChar) > cutLine.get(
                endChar)) {
                end--;
                maxCount.put(endChar, maxCount.get(endChar) - 1);
                continue;
            }

            answer = s.substring(start, end + 1);
            break;
        }

        return answer;
    }

}
