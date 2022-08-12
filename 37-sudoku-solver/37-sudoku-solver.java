class Solution {
    public boolean solveSudoku(char[][] board) {
        return dfs(board, 0, 0, 0);
    }

    private boolean dfs(char[][] board, int x, int y, int matchCount) {
        int next_x;
        int next_y;
        if (y == board.length - 1) {
            next_x = x + 1;
            next_y = 0;
        } else {
            next_y = y + 1;
            next_x = x;
        }

        if (matchCount == board.length * board.length) {
            return true;
        }
        if (board[x][y] != '.') {
            return dfs(board, next_x, next_y, matchCount + 1);
        }
        for (int i = 1; i <= 9; i++) {
            if(checkIsValid(board, x, y, i)){
                board[x][y] = (char) ('0' +i);
                if(dfs(board, next_x, next_y, matchCount + 1)){
                    return true;
                }
                board[x][y] = '.';
            }
        }
        return false;
    }

    private boolean checkIsValid(char[][] board, int x, int y, int inputNumber) {
        return validRow(board, x, inputNumber) && validCol(board, y, inputNumber) && validRec(board,
            x, y, inputNumber);
    }

    private boolean validRow(char[][] board, int x, int inputNumber) {
        for (int i = 0; i < board.length; i++) { // row 검증
            if (board[x][i] - '0' == inputNumber) {
                return false;
            }
        }
        return true;
    }

    private boolean validCol(char[][] board, int y, int inputNumber) {
        for (int i = 0; i < board.length; i++) { // col 검증
            if (board[i][y] - '0' == inputNumber) {
                return false;
            }
        }
        return true;
    }

    private boolean validRec(char[][] board, int x, int y, int inputNumber) {
        for (int i = x / 3 * 3; i < x / 3 * 3 + 3; i++) {
            for (int j = y / 3 * 3; j < y / 3 * 3 + 3; j++) {
                if (board[i][j] - '0' == inputNumber) {
                    return false;
                }
            }
        }
        return true;
    }
}