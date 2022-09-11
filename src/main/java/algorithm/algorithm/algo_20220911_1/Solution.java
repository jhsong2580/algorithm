package algorithm.algorithm.algo_20220911_1;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Solution {
    private Map<Integer, List<Integer>> edgeInfo;
    private int max_sheep = 0;
    public int solution(int[] info, int[][] edges) {
        int answer = 0;
        edgeInfoInit(edges);
        int[][][] check = new int[info.length][info.length][info.length]; //node,sheep, wolf
        dfs(0, 0, 0, check, info);

        return max_sheep;
    }

    private void dfs(int nodeNumber, int sheep, int wolf, int[][][] check, int[] info) {
        if(check[nodeNumber][sheep][wolf] == 1){
            return;
        }
        if(info[nodeNumber] == 0){
            sheep+=1;
        }else if(info[nodeNumber] == 1){
            wolf+=1;
        }
        if(wolf >= sheep){
            return;
        }
        if(max_sheep < sheep){
            max_sheep = sheep;
        }

        List<Integer> neighbors = edgeInfo.get(nodeNumber);
        for (Integer neighbor : neighbors) {
            int tempInfo = info[nodeNumber];
            info[nodeNumber] = -1;
            check[nodeNumber][sheep][wolf] = 1;
            dfs(neighbor, sheep, wolf, check, info);
            check[nodeNumber][sheep][wolf] = 0;
            info[nodeNumber] = tempInfo;
        }
    }

    private void edgeInfoInit(int[][] edges) {
        edgeInfo = new HashMap<>();
        for (int[] edge : edges) {
            int start = edge[0];
            int end = edge[1];
            if(edgeInfo.containsKey(start)){
                edgeInfo.get(start).add(end);
            }else{
                List<Integer> nodes = new LinkedList<>();
                nodes.add(end);
                edgeInfo.put(start, nodes);
            }
            if(edgeInfo.containsKey(end)){
                edgeInfo.get(end).add(start);
            }else{
                List<Integer> nodes = new LinkedList<>();
                nodes.add(start);
                edgeInfo.put(end, nodes);
            }
        }
    }
}
