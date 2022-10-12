package algorithm.algorithm.algo_20221001_2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Solution {
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        int dp[][] = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                dp[i][j] = 3 * 10000 + 1;
                if(i == j){
                    dp[i][j] = 0;
                }
            }
        }
        for(int i=0; i<edges.length; i++){
            dp[edges[i][0]][edges[i][1]] = 1;
            dp[edges[i][1]][edges[i][0]] = 1;
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<n ; j++){
                for(int k=0;k<n  ; k ++){
                    dp[i][k] = Math.min(dp[i][k], dp[i][j] + dp[j][k]);
                }
            }
        }
        int[] result = new int[n];
        for(int i=0; i<n; i++){
            result[i] = Arrays.stream(dp[i]).sum();
        }
        return result;
    }

}
