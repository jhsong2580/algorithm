package algorithm.algorithm.algo_20220918_1;

public class Solution {


    int cardNumbers = -1;
    int minMove = 64;
    int[] direction = new int[]{0, 1, 0, -1, 0}; // Right, Down, Left, Up

    boolean isEnd = false;

    public int solution(int[][] board, int r, int c) {
        int answer = 0;
        int[][] check = new int[board.length][board[0].length];
        for (int[] sources : board) {
            for (int source : sources) {
                cardNumbers = Math.max(cardNumbers, source);
            }
        }
        dfs(board, check, r, c, -1, 0, 0, -1);
        return minMove;
    }

    private void dfs(int[][] board, int[][] check, int r, int c, int dir, int moveCount,
        int matchCount, int findCard) {
        if (r < 0 || c < 0 || r >= board.length || c >= board[0].length) {
            return;
        }
        if (isEnd) {
            return;
        }
        if (moveCount > minMove) {
            return;
        }
        if (check[r][c] != 0) {
            return;
        }
        int tempBoardNumber = board[r][c];
        if (board[r][c] != 0) {
            if (findCard == -1) {
                findCard = board[r][c];
                board[r][c] = 0;
                moveCount++;
                initCheck(check);
            } else if (findCard != -1 && board[r][c] == findCard) {
                moveCount++;
                matchCount++;
                board[r][c] = 0;
                findCard = -1;
                initCheck(check);
                if (matchCount == cardNumbers) {
                    minMove = Math.min(minMove, moveCount);
                    return;
                }
            }
        }

        if(r == 3 && c == 2){
            System.out.println("a");
        }
        check[r][c] = 1;
        for (int i = 0; i < direction.length - 1; i++) {

            if (i == dir && tempBoardNumber == 0) {
                dfs(board, check, r + direction[i], c + direction[i + 1], i, moveCount, matchCount,
                    findCard);
            } else {
                dfs(board, check, r + direction[i], c + direction[i + 1], i, moveCount + 1,
                    matchCount, findCard);
            }
        }
        check[r][c] = 0;
    }

    public void initCheck(int[][] check) {
        for (int i = 0; i < check.length; i++) {
            for (int j = 0; j < check[0].length; j++) {
                check[i][j] = 0;
            }
        }
    }
}
