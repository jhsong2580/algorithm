package algorithm.algorithm_2023.algo_04_13_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
//https://www.acmicpc.net/problem/1405
//dfs

public class Solution {
    static List<Node> check = new ArrayList<>();
    static double R;
    static int N;
    static double L;
    static double B;
    static double T;
    static double resultProb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] datas = br.readLine().split(" ");
        N = Integer.valueOf(datas[0]);
        R = Double.valueOf(datas[1]);
        L = Double.valueOf(datas[2]);
        B = Double.valueOf(datas[3]);
        T = Double.valueOf(datas[4]);
        resultProb = 0;


        dfs(new Node(0, 0), 0, 1);
        System.out.println(resultProb);

    }

    private static void dfs(Node node, int curN, double curProb) {
        if(check.contains(node)) {
            return;
        }
        if(curN == N) {
            resultProb += curProb;
            return;
        }

        check.add(node);
        if(R != 0) {
            Node nextNode = new Node(node.x, node.y + 1);
            dfs(nextNode, curN + 1, curProb * R / 100.0);
        }
        if(L != 0) {
            Node nextNode = new Node(node.x, node.y - 1);
            dfs(nextNode, curN + 1, curProb * L / 100.0);
        }
        if(B != 0) {
            Node nextNode = new Node(node.x - 1, node.y);
            dfs(nextNode, curN + 1, curProb * B / 100.0);
        }
        if(T != 0 ){
            Node nextNode = new Node(node.x + 1, node.y);
            dfs(nextNode, curN + 1, curProb * T / 100.0);
        }

        check.remove(node);
    }

    private static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof Node)) {
                return false;
            }
            Node node = (Node) o;
            return x == node.x && y == node.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}
