package algorithm.algorithm.algo_20220904_1;

public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] arr = new int[n][n];
        int top = 0;
        int left = 0;
        int right = n-1;
        int bottom = n-1;
        int number = 1;
        while(top < bottom && left < right){
            for(int i = left; i <= right; i++){
                arr[top][i] = number++;
            }
            top++;
            for(int i = top; i <= bottom; i++){
                arr[i][right] = number++;
            }
            right--;
            for(int i = right; i >= left; i--){
                arr[bottom][i] = number++;
            }
            bottom--;
            for(int i = bottom; i >= top; i--){
                arr[i][left] = number++;
            }
            left++;
        }
        if(n %2 == 1){
            arr[n/2][n/2] = (int)Math.pow(n,2);
        }
        return arr;
    }
}
