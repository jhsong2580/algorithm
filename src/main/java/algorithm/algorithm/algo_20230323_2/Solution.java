package algorithm.algorithm.algo_20230323_2;

import java.util.Stack;

/**
 * https://leetcode.com/problems/maximal-rectangle/submissions/920698957/
*/

public class Solution {

    public int maximalRectangle(char[][] matrix) {
        int maxLayer = matrix.length - 1;
        int[] base = new int[matrix[0].length + 2];
        int maxWeight = -1;
        for (int i = maxLayer; i >= 0; i--) {
            char[] target = matrix[i];
            for (int j = 0; j < target.length; j++) {
                if (target[j] == '0') {
                    base[j + 1] = 0;
                } else {
                    base[j + 1] += 1;
                }
            }
            int solveWeight = solve(base);
            maxWeight = Math.max(maxWeight, solveWeight);
        }

        return maxWeight;
    }

    private int solve(int[] base) {
        int[] re = getRE(base);
        int[] le = getLE(base);
        int maxWeight = -1;
        for (int i = 1; i < base.length - 1; i++) {
            int weight = (re[i] -1) - (le[i] + 1) + 1;
            int height = base[i];
            maxWeight = Math.max(maxWeight, weight * height);
        }

        return maxWeight;
    }

    private int[] getRE(int[] base) {
        int[] re = new int[base.length];

        Stack<Integer> indexs = new Stack<>();

        for (int i = 0; i < base.length; i++) {
            if (indexs.isEmpty()) {
                indexs.add(i);
                continue;
            }
            if (base[indexs.peek()] <= base[i]) {
                indexs.add(i);
                continue;
            }
            while (!indexs.isEmpty() && base[indexs.peek()] > base[i]) {
                re[indexs.pop()] = i;
            }
            indexs.add(i);
        }
        while (!indexs.isEmpty()) {
            re[indexs.pop()] = base.length - 1;
        }

        return re;
    }

    private int[] getLE(int[] base) {
        int[] le = new int[base.length];
        Stack<Integer> indexes = new Stack<>();

        for (int i = base.length - 1; i >= 0; i--) {
            if (indexes.isEmpty()) {
                indexes.add(i);
                continue;
            }

            if (base[indexes.peek()] <= base[i]) {
                indexes.add(i);
                continue;
            }
            while (!indexes.isEmpty() && base[indexes.peek()] > base[i]) {
                le[indexes.pop()] = i;
            }
            indexes.add(i);
        }
        while (!indexes.isEmpty()) {
            le[indexes.pop()] = 0;
        }
        return le;
    }
}
