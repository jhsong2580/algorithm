package algorithm.algorithm_2023.algo_03_30_1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    boolean[] check;
    int maxLayer ;
    Map<Integer, List<Integer>> map;
    int nodeCount;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        maxLayer = numCourses;
        check = new boolean[numCourses];
        Arrays.fill(check, false);
        map = new HashMap<>();
        for (int[] prerequisite : prerequisites) {
            if(map.containsKey(prerequisite[0])) {
                map.get(prerequisite[0]).add(prerequisite[1]);
            }else {
                map.put(prerequisite[0], Arrays.asList(prerequisite[1]));
            }
        }

        try{
            for(int i = 0; i < numCourses; i++) {
                check[i] = true;
                List<Integer> integers = map.get(i);
                if(integers == null)
                    continue;
                for (Integer integer : integers) {
                    dfs(integer);
                }
                check[i] = false;
            }
        }catch(Exception e){
            return false;
        }

        return true;
    }

    private void dfs(int curIndex) {

        if(check[curIndex]) {
            throw new RuntimeException("can not");
        }
        check[curIndex] = true;

        List<Integer> integers = map.get(curIndex);
        if(integers == null) {
            return;
        }
        for (Integer integer : integers) {
            dfs(integer);
        }

        check[curIndex] = false;
    }
}
