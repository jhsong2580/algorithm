package algorithm.algorithm.algo_20220911_3;

public class Solution {

    private int max_move;
    private int[] d = new int[]{0, 1, 0, -1, 0};

    public int solution(int[][] board, int[] aloc, int[] bloc) {
        max_move = 0;

        board[aloc[0]][aloc[1]] = 0;
        for (int i = 0; i <= d.length - 2; i++) {
            dfs(aloc[0] + d[i], aloc[1] + d[i + 1], bloc[0],
                bloc[1], board, 0, 0);
        }

        int answer = -1;
        return max_move;
    }

    private void dfs(int a_r, int a_c, int b_r, int b_c, int[][] board,
        int move, int target) {
        int r = -1;
        int c = -1;
        if (target == 0) {
            r = a_r;
            c = a_c;
        } else if (target == 1) {
            r = b_r;
            c = b_c;
        }
        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length) {
            return;
        }
        if (board[r][c] == 0) {
            return;
        }

        move += 1;
        if (max_move < move) {
            max_move = move;
        }

        target = (target + 1) % 2; // 0 : a, 1 : b
        int act_a = (2 - target) / 2;
        int act_b = (2 - target) % 2;

        if (target == 0) {
            if(board[a_r][a_c] == 0){
                return;
            }
            board[a_r][a_c] = 0;
        } else {
            if(board[b_r][b_c] == 0){
                return;
            }
            board[b_r][b_c] = 0;
        }
        for (int i = 0; i <= d.length - 2; i++) {
            dfs(a_r + d[i] * act_a, a_c + d[i + 1] * act_a, b_r + d[i] * act_b,
                b_c + d[i + 1] * act_b, board, move, target);
        }
        if (target == 0) {
            board[a_r][a_c] = 1;
        } else {
            board[b_r][b_c] = 1;
        }
    }

}
