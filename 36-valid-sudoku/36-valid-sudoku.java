class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<String> row = new HashSet<>();
        HashSet<String> col = new HashSet<>();
        HashSet<String> rec = new HashSet<>();
        int totalNumberCount = 0;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                totalNumberCount++;
                row.add("" + i + '_' + board[i][j]);
                col.add("" + j + '_' + board[i][j]);
                rec.add("" + i / 3 + '_' + j / 3 + '_' + board[i][j]);
            }
        }
        return totalNumberCount * 3 == (row.size() + col.size() + rec.size());
    }
}