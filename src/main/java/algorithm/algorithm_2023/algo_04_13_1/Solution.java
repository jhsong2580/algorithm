package algorithm.algorithm_2023.algo_04_13_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
//https://www.acmicpc.net/status?user_id=jhsong2580&problem_id=1174&from_mine=1
//DFS
public class Solution {
    static int[] source = new int[]{9,8,7,6,5,4,3,2,1,0};
    static List<Long> data = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.valueOf(br.readLine());


        dfs(0,0);

        Collections.sort(data);

        if(N >= data.size()) {
            System.out.println(-1);
            return;
        }
        System.out.println(data.get(N-1));

    }

    private static void dfs(long num, int i) {
        if(!data.contains(num)) {
            data.add(num);
        }

        if(i == source.length) {
            return;
        }
        dfs( num * 10 + source[i], i + 1);
        dfs(num , i + 1);

    }
}
