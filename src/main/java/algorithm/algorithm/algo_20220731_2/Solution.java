package algorithm.algorithm.algo_20220731_2;

public class Solution {

    private static int result = 0;

    public int totalNQueens(int n) {
        result = 0;
        int[] check = new int[n];
        if (n == 1) {
            return 1;
        }
        if (n == 2 || n == 3) {
            return 0;
        }

        for (int i = 0; i < n; i++) {
            int left = getLeft(i);
            int right = getRight(i, n);
            check[i] = 1;
            dfs(check, 1, n, left, right);
            check[i] = 0;
        }
        return result;
    }

    private void dfs(int[] check, int layer, int maxLayer, int left, int right) {
        if (layer == maxLayer) {
            result += 1;
            return;
        }

        for (int i = 0; i < maxLayer; i++) {
            if (check[i] == 1) {
                continue;
            }
            if (isIn(left, i) || isIn(right, i)) {
                continue;
            }

            int copyLeft = left >> 1;
            int copyRight = (int) ((right << 1) % Math.pow(2, maxLayer));
            if (!isIn(copyLeft, i - 1)) {
                copyLeft = copyLeft + getLeft(i);
            }

            if (!isIn(copyRight, i + 1)) {
                copyRight = copyRight + getRight(i, maxLayer);
            }
            check[i] = 1;
            dfs(check, layer + 1, maxLayer, copyLeft, copyRight);
            check[i] = 0;
        }
    }

    private boolean isIn(int source, int index) {
        return (source >> index) % 2 == 1;
    }

    private int getLeft(int index) {
        if (index <= 0) {
            return 0;
        }
        return (int) Math.pow(2, index - 1);
    }

    private int getRight(int index, int maxLength) {
        if (index == maxLength - 1) {
            return 0;
        }

        return (int) Math.pow(2, index + 1);
    }
}
