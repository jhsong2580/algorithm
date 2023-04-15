package algorithm.algorithm_2023.algo_04_15_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {
    static int N;
    static int[][] sortedMap;
    static boolean[][] check;
    public static void main(String[] args) throws IOException {
        init();

        Queue<Node> numbers = new PriorityQueue<Node>();

        numbers.add(new Node(N - 1, N - 1, sortedMap[N - 1][N - 1]));
        List<Integer> result = new ArrayList<>();
        while (result.size() != N) {
            Node node = numbers.poll();
            if(check[node.x][node.y]) {
                continue;
            }
            if(node.x -1 >= 0) {
                numbers.add(new Node(node.x -1, node.y, sortedMap[node.x -1][node.y]));
            }
            if(node.y -1 >=0) {
                numbers.add(new Node(node.x, node.y - 1, sortedMap[node.x][node.y - 1]));
            }
            result.add(node.val);
            check[node.x][node.y] = true;
        }
        System.out.println(result.get(result.size() - 1));
    }

    private static class Node implements Comparable<Node> {
        int x;
        int y;
        int val;

        public Node(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }

        public int compareTo(Node o) {
            return Integer.compare(this.val, o.val) * -1;
        }
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.valueOf(br.readLine());
        int[][] noneSortedMap = new int[N][N];
        check = new boolean[N][N];
        sortedMap = new int[N][N];
        for(int i=0; i<N; i++) {
            String[] arr = br.readLine().split(" ");
            for(int j=0; j<N; j++) {
                noneSortedMap[i][j] = Integer.valueOf(arr[j]);
            }
        }
        List<Integer> dummy = new ArrayList<Integer>();
        for(int i=0; i<N; i++) {
            dummy.add(noneSortedMap[N - 1][i]);
        }
        Collections.sort(dummy);
        for(int i=0; i<N; i++) {
            int targetIndex = dummy.indexOf(noneSortedMap[N - 1][i]);
            for(int j=0; j<N; j++) {
                sortedMap[j][targetIndex] = noneSortedMap[j][i];
            }
        }
    }

}
