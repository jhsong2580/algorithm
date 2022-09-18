package algorithm.algorithm.algo_20220918_2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Solution {
    Map<Integer, List<Integer>> nodesInfo;
    long[][] dp;
    int minSales = Integer.MAX_VALUE;

    public int solution(int[] sales, int[][] links) {
        nodesInfo = new HashMap<>();
        dp = new long[sales.length][2];
        //dp[x][0] : x node가 회의에 참석하지 않았을때 소모되는 최소 판매량
        //dp[x][1] : x node가 회의에 참석했을때 소모되는 최소 판매량

        for (int[] link : links) {
            int key = link[0];
            int value = link[1];
            if (nodesInfo.containsKey(key)) {
                nodesInfo.get(key).add(value);
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(value);
                nodesInfo.put(key, list);
            }
        }

        List<Integer> keySet = nodesInfo.keySet().stream().collect(Collectors.toList());

        dfs(1, sales);

        return (int) Math.min(dp[0][0], dp[0][1]);
    }

    private void dfs(int node, int[] sales) {
        if (!nodesInfo.containsKey(node)) {
            dp[node - 1][0] = 0;
            dp[node - 1][1] = sales[node - 1];
        } else {
            List<Integer> childs = nodesInfo.get(node);
            for (Integer child : childs) {
                dfs(child, sales);
            }
            int sumSales = 0;
            int subMin = Integer.MAX_VALUE;
            boolean childWork = false;
            for (Integer child : childs) {
                if (dp[child - 1][0] > dp[child - 1][1]) {
                    childWork = true;
                }
                sumSales += Math.min(dp[child - 1][0], dp[child - 1][1]);
                subMin = (int) Math.min(subMin, dp[child - 1][1] - dp[child - 1][0]);
            }
            if(childWork){
                dp[node-1][0] = sumSales;
            }else{
                dp[node - 1][0] = sumSales + subMin;
            }
            dp[node - 1][1] = sumSales + sales[node - 1];
        }
    }

}
