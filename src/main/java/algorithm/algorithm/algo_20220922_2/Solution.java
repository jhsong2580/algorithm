package algorithm.algorithm.algo_20220922_2;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<String> generateParenthesis(int n) {
        LinkedList<String> result = new LinkedList<>();
        dfs(result, "", 0, 0, n * 2);
        return result;
    }
    private void dfs(List<String> result, String curString, int flag, int layer, int maxLayer){
        if(flag < 0){
            return;
        }
        if(layer == maxLayer){
            if(flag == 0){
                result.add(curString);
            }
            return;
        }
        dfs(result, curString + "(", flag + 1, layer + 1, maxLayer);
        dfs(result, curString + ")", flag - 1, layer + 1, maxLayer);
    }
}
