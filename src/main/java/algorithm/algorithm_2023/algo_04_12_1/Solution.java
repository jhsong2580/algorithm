package algorithm.algorithm_2023.algo_04_12_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//https://www.acmicpc.net/problem/1331
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean[][] check = new boolean[6][6];
        int a_start = -1;
        int b_start = -1;
        int a_before = -1;
        int b_before = -1;
        String arg = "";
        for (int i=0; i<36; i++) {
            arg = br.readLine();
            int a_now = arg.charAt(0) - 'A';
            int b_now = arg.charAt(1) - '1';
            if(check[a_now][b_now]) {
                System.out.println("Invalid");
                return;
            }
            check[a_now][b_now] = true;
            if(a_before == -1) {
                a_start = a_now;
                b_start = b_now;
                a_before = a_now;
                b_before = b_now;
                continue;
            }

            int absA = Math.abs(a_now - a_before);
            int absB = Math.abs(b_now - b_before);
            if(Math.abs(absA - absB) == 1 && absA + absB == 3) {
                a_before = a_now;
                b_before = b_now;
                continue;
            } else {
                System.out.println("Invalid");
                return;
            }
        }
        int a_now = arg.charAt(0) - 'A';
        int b_now = arg.charAt(1) - '1';
        int absA = Math.abs(a_now - a_start);
        int absB = Math.abs(b_now - b_start);
        if(Math.abs(absA - absB) == 1 && absA + absB == 3) {
            System.out.println("Valid");
        } else {
            System.out.println("Invalid");
        }

    }
}
