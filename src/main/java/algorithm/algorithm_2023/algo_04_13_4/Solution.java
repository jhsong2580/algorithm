package algorithm.algorithm_2023.algo_04_13_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//https://www.acmicpc.net/problem/1756
public class Solution {

    static int D;
    static int N;
    static int d[];
    static int p[];

    static int[] table;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] data = br.readLine().split(" ");
        D = Integer.valueOf(data[0]);
        N = Integer.valueOf(data[1]);

        d = Arrays.stream(br.readLine().split(" "))
            .mapToInt(Integer::valueOf)
            .toArray();
        p = Arrays.stream(br.readLine().split(" "))
            .mapToInt(Integer::valueOf)
            .toArray();
        table = new int[d.length];
        table[0] = d[0];
        for(int i=1; i<table.length; i++) {
            table[i] = Math.min(table[i - 1], d[i]);
        }

        int depthIndex = table.length -1;
        int pizzaIndex = 0;
        for(pizzaIndex = 0; pizzaIndex < p.length; pizzaIndex++) {
            int curPizzaSize = p[pizzaIndex];
            if(depthIndex <0) {
                System.out.println(0);
                return;
            }
            while (curPizzaSize > table[depthIndex]) {
                depthIndex--;
                if(depthIndex <0) {
                    System.out.println(0);
                    return;
                }
            }
            depthIndex--;
        }

        if(pizzaIndex == p.length) {
            System.out.println(depthIndex+2);
        }
    }
}
