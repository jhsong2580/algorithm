package algorithm.algorithm.algo_20220910_2;

public class Solution {

    private int score = 0;
    private int[] score_arr = new int[11];

    public int[] solution(int n, int[] info) {
        int[] r = new int[info.length];
        dfs(n, r, info, 0);

        if(score == 0){
            return new int[]{-1};
        }
        return score_arr;
    }

    private void dfs(int arrow, int[] r, int[] a, int index) {

        if (arrow == 0 || index == 11) {
            r[r.length -1] = arrow;
            calcScore(a, r);
            r[r.length -1] = 0;
            return;
        }

        if (arrow > a[index]) {
            r[index] += a[index] + 1;
            dfs(arrow - a[index] - 1, r, a, index + 1);
            r[index] -= a[index] + 1;
        }

        dfs(arrow, r, a, index + 1);

    }

    private void calcScore(int[] a, int[] r) {
        int r_comparedWith_a = 0;
        for (int i = 0; i < 11; i++) {
            int score = 10 - i;

            if (a[i] >= r[i] && a[i] != 0) {
                r_comparedWith_a -= score;
            } else if (a[i] < r[i]) {
                r_comparedWith_a += score;
            }
        }
        if (score < r_comparedWith_a) {
            for (int i = 0; i < r.length; i++) {
                score_arr[i] = r[i];
            }
            score = r_comparedWith_a;
        } else if (score == r_comparedWith_a) {
            checkLowNumber(r);
        }
    }

    private void checkLowNumber(int[] r) {
        for (int i = r.length - 1; i >= 0; i--) {
            if (score_arr[i] < r[i]) {
                for (int j = 0; j < r.length; j++) {
                    score_arr[j] = r[j];
                }
                return;
            } else if (score_arr[i] > r[i]) {
                return;
            } else {
                continue;
            }
        }
    }
}
