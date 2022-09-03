package algorithm.algorithm.algo_20220902_1;

import java.util.LinkedList;
import java.util.List;

public class Solution {


    public List<Integer> spiralOrder(int[][] matrix) {
        int[][] check = new int[matrix.length + 2][matrix[0].length + 2];
        initCheck(check);
        int col = 1;
        int row = 1;

        List<Integer> result = new LinkedList<>();

        dfs(matrix, check, row, col, result, 0);
        return result;
    }

    private void dfs(int[][] matrix, int[][] check, int row, int col, List<Integer> result, int flag){
        result.add(matrix[row - 1][col - 1]);
        check[row][col] = 1;
        int nextCol = getNextCol(col, flag);
        int nextRow = getNextRow(row, flag);
        if(check[nextRow][nextCol] == 1){
            flag = getGreedyFlag(row, col, check);
            if(flag == 4)
                return;
            nextCol = getNextCol(col,flag);
            nextRow = getNextRow(row, flag);
        }

        dfs(matrix,check, nextRow, nextCol, result, flag);

    }
    private int getGreedyFlag(int row, int col, int[][] check){
        if(check[row][col +1] == 0){
            return 0;
        }
        if(check[row +1][col] == 0){
            return 1;
        }
        if(check[row][col -1] == 0){
            return 2;
        }
        if(check[row -1][col] == 0){
            return 3;
        }
        return 4;
    }
    private int getNextRow(int row, int flag){
        if(flag == 0 || flag == 2){
            return row;
        }
        return row + (2 - flag);
    }

    private int getNextCol(int col, int flag){
        if(flag == 1 || flag == 3){
            return col;
        }
        return col + (1 - flag);
    }
    private void initCheck(int[][] check) {
        for (int i = 0; i < check[0].length; i++) {
            check[0][i] = 1;
            check[check.length - 1][i] = 1;
        }
        for (int i = 0; i < check.length; i++) {
            check[i][0] = 1;
            check[i][check[0].length - 1] = 1;
        }

    }
}
