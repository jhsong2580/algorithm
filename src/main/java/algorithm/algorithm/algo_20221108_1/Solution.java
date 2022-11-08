package algorithm.algorithm.algo_20221108_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Solution {

    List<List<Integer>> result = new LinkedList<>();
    private Set<String> joinSet = new HashSet<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(candidates, target, 0, 0, new LinkedList<>());
        return result;
    }

    private void dfs(int[] candidates, int target, int index, int sum,
        LinkedList<Integer> contains) {
        if(sum == target){
            result.add(new ArrayList<>(contains));
            return;
        }
        if(sum > target){
            return;
        }
        if(index == candidates.length){
            return;
        }
        //include
        contains.addLast(candidates[index]);
        dfs(candidates, target, index + 1, sum + candidates[index], contains);
        contains.removeLast();

        //exclude
        index++;
        while(index < candidates.length && candidates[index] == candidates[index-1]){
            index++;
        }
        dfs(candidates, target, index, sum, contains);
    }

}
