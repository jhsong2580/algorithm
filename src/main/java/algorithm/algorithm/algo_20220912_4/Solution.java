package algorithm.algorithm.algo_20220912_4;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    private int MAX = 0;
    public int solution(int n, int s, int a, int b, int[][] fares) {
        MAX = 100_000 * n+1;
        int[][] weight = new int[n + 1][n + 1];
        boolean[] checked = new boolean[n];



        for(int i = 0 ;i< checked.length; i++){
            checked[i] = false;
        }

        for (int i = 0; i < weight.length; i++) {
            for (int j = 0; j < weight[0].length; j++) {
                if (i == j) {
                    weight[i][j] = 0;
                } else {
                    weight[i][j] = MAX;
                }
            }
        }

        for (int[] fare : fares) {
            int x = fare[0];
            int y = fare[1];
            int w = fare[2];
            weight[x][y] = w;
            weight[y][x] = w;
        }
        for(int i = 1; i<=n ;i++){
            dijstra(n, weight,  i);
        }

        int minPath = MAX;
        for(int i = 1 ; i <= n; i++){
            minPath = Math.min(minPath, weight[s][i] + weight[i][a] + weight[i][b]);
        }

        return minPath;
    }

    private void dijstra(int n, int[][] weight,  int startNode) {
        boolean checked[] = new boolean[n];
        List<Integer> joinNode = new LinkedList<>();
        joinNode.add(startNode);

        checked[startNode - 1] = true;
        while(joinNode.size() != n){
            int min = MAX;
            int selectedNode = -1;
            for (Integer node : joinNode) {
                for(int i = 1; i< weight[node].length; i++){
                    if(weight[node][i] < min && checked[i-1] == false){
                        min = weight[node][i];
                        selectedNode = i;
                    }
                }
            }
            if(selectedNode == -1){
                for (int i = 0; i < checked.length; i++) {
                    if(checked[i] == false){
                        selectedNode = i+1;
                        break;
                    }
                }
            }
            joinNode.add(selectedNode);
            checked[selectedNode - 1] = true;

            int minPath = MAX;
            for (Integer node : joinNode) {
                minPath = Math.min(minPath, weight[startNode][node] + weight[node][selectedNode]);
            }
            minPath = Math.min(minPath, weight[startNode][selectedNode]);

            weight[startNode][selectedNode] = minPath;
            weight[selectedNode][startNode] = minPath;
        }
    }

}
