package algorithm.algorithm.algo_20220924_6;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    boolean[][][] check ;
    String[][] board;
    List<String> result = new LinkedList<>();

    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        check = new boolean[n][m][k];
        board = new String[n][m];

        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                board[i][j] = "";
            }
        }
        board[r - 1][c - 1] = "E";
        for(int i=0; i< n; i++){
            for(int j=0; j<m; j++){
                for(int q=0;q<k;q++){
                    check[i][j][q] = false;
                }
            }
        }
        dfs(x - 1, y - 1, "", 0, k);
        Collections.sort(result);
        if(result.size() == 0){
            return "impossible";
        }else{
            return result.get(0);
        }
    }

    private void dfs(int r, int c, String strings, int k, int k_limit) {
        if (r == board.length || c == board[0].length || r < 0 || c < 0) {
            return;
        }

        if (board[r][c].equals("E") && k == k_limit) {
            result.add(strings);
            return;
        }
        if (k == k_limit) {
            return;
        }
        if (check[r][c][k]) {
            return;
        }
        check[r][c][k] =true;
        dfs(r + 1, c, strings + "d", k + 1, k_limit);
        dfs(r , c-1, strings + "l", k + 1, k_limit);
        dfs(r , c+1, strings + "r", k + 1, k_limit);
        dfs(r - 1, c, strings + "u", k + 1, k_limit);

    }
}
