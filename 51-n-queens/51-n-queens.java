class Solution {
    private int max_n;
    private List<List<String>> result;


    public List<List<String>> solveNQueens(int n) {
        max_n = n;
        result = new LinkedList<>();
        int[][] monitor = new int[n][n];
        String[] map = new String[n];
        dfs(map, monitor, 0, 0, "", 0);
        return result;
    }

    private void dfs(String[] map, int[][] monitor, int r, int c, String curString, int curQueen) {
        if (r == max_n) {
            if (curQueen == max_n) {
                ArrayList<String> copy = new ArrayList<>();
                for (String s : map) {
                    copy.add(s);
                }

                result.add(copy);
            }
            return;
        }
        if(c == max_n){
            map[r] = curString;
            dfs(map, monitor, r + 1, 0, "", curQueen);
            map[r] = "";
            return;
        }

        if (validate(r, c, monitor)) {
            monitor[r][c] = 1;
            dfs(map, monitor, r, c + 1, curString + "Q", curQueen + 1);
            monitor[r][c] = 0;
        }
        dfs(map, monitor, r, c + 1, curString + ".", curQueen);

    }

    private boolean validate(int r, int c, int[][] map) {

        //validate left/top
        for (int i = 0; i <= r - 1; i++) {
            for (int j = 0; j <= c - 1; j++) {

                if (map[i][j] == 1 && r - i == c - j) {
                    return false;
                }
            }
        }

        //validate right/top
        for (int i = 0; i <= r - 1; i++) {
            for (int j = c + 1; j < max_n; j++) {
                if (map[i][j] == 1 && r - i == j - c) {
                    return false;
                }
            }
        }

        //validate left
        for (int j = 0; j <= c - 1; j++) {
            if (map[r][j] == 1){
                return false;
            }
        }

        //validate top
        for(int i=0; i<=r-1; i++){
            if(map[i][c] == 1){
                return false;
            }
        }
        return true;
    }
}