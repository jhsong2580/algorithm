package algorithm.algorithm.algo_20220921_3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Solution {
    Map<Character, List<String>> sources;

    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0){
            return new LinkedList<>();
        }
        sources = new HashMap<>();
        sources.put('2', Arrays.asList(new String[]{"a", "b", "c"}));
        sources.put('3', Arrays.asList(new String[]{"d", "e", "f"}));
        sources.put('4', Arrays.asList(new String[]{"g", "h", "i"}));
        sources.put('5', Arrays.asList(new String[]{"j", "k", "l"}));
        sources.put('6', Arrays.asList(new String[]{"m", "n", "o"}));
        sources.put('7', Arrays.asList(new String[]{"p", "q", "r", "s"}));
        sources.put('8', Arrays.asList(new String[]{"t", "u", "v"}));
        sources.put('9', Arrays.asList(new String[]{"w", "x", "y", "z"}));

        List<String> results = new LinkedList<>();
        dfs(digits, 0, results, "");
        return results;
    }
    private void dfs(String digits, int index, List<String> results, String curString){
        if(index == digits.length()){
            results.add(curString);
            return;
        }
        List<String> spellings = sources.get(digits.charAt(index));
        for(int i=0; i< spellings.size(); i++){
            dfs(digits, index + 1, results, curString + spellings.get(i));
        }
    }
}
