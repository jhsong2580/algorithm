package algorithm.algorithm_2023.algo_04_13_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//https://www.acmicpc.net/problem/1720
//dp
public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.valueOf(br.readLine());
        int[] dp = new int[31];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= 30; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] * 2;
        }

        int dupCount = 0;
        if (N % 2 == 0) {
            dupCount = (dp[N] + dp[(N - 2) / 2] * 2 + dp[N / 2]) / 2;
        } else {
            dupCount = (dp[N] + dp[(N - 1) / 2]) / 2;
        }
        System.out.println(dupCount);

    }
}
