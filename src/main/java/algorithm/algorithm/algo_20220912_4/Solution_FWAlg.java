package algorithm.algorithm.algo_20220912_4;

//플로이드워셜
public class Solution_FWAlg {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int MAX = 100001 * n;
        int[][] weight = new int[n][n];
        int[][] path = new int[n][n];
        for(int i = 0; i<weight.length; i++){
            for(int j = 0; j<weight[0].length; j++){
                if(i == j) {
                    weight[i][j] = 0;
                    path[i][j] = i;
                }
                else{
                    weight[i][j] = MAX;
                    path[i][j] = -1;
                }

            }
        }
        for (int[] fare : fares) {
            int x = fare[0];
            int y = fare[1];
            int money = fare[2];

            weight[x-1][y-1] = money;
            weight[y-1][x-1] = money;
            path[x-1][y-1] = x;
            path[y-1][x-1] = y;
        }

        for(int k = 0; k< n; k++){
            for(int i = 0; i < n; i++){
                for(int j = 0; j<n; j++){
                    weight[i][j] = Math.min(weight[i][j], weight[i][k]+weight[k][j]);
                }
            }
        }
        int minPath = MAX;
        for(int i = 0 ; i < n; i++){
            minPath = Math.min(minPath, weight[s-1][i] + weight[i][a-1] + weight[i][b-1]);
        }

        return minPath;
    }

}
