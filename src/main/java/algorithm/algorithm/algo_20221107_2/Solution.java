package algorithm.algorithm.algo_20221107_2;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    private Set<Integer> row;
    private Set<Integer> col;
    public void setZeroes(int[][] matrix) {
        row = new HashSet<>();
        col = new HashSet<>();
        for(int i=0; i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j] == 0){
                    row.add(i);
                    col.add(j);
                }
            }
        }

        for(int i=0; i<matrix.length;i++){
            boolean isZero = false;
            if (row.contains(i)) {
                isZero= true;
            }
            for(int j=0;j<matrix[0].length;j++){
                if(isZero){
                    matrix[i][j] = 0;
                    continue;
                }
                if(col.contains(j)){
                    matrix[i][j] = 0;
                    continue;
                }
            }
        }
    }
}
