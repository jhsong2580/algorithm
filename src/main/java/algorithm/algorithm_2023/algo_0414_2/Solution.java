package algorithm.algorithm_2023.algo_0414_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//https://www.acmicpc.net/problem/2133
public class Solution {
    static int N;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.valueOf(br.readLine());

        dp = new int[31];
        dp[2] = 3;
        dp[4] = 11;
        for(int i=6; i<=N; i++) {
            if(i%2 == 1) {
                continue;
            }
            int result = dp[i-2] * 3 + 2;
            for (int j = i - 4; j >= 2; j = j - 2) {
                result += dp[j] * 2;
            }
            dp[i] = result;
        }
        System.out.println(dp[N]);

    }
}
