package algorithm.algorithm.algo_20220911_2;

public class Solution {

    private int[] turnType = new int[]{0, -1, 1};

    public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        int[][] sum = new int[board.length + 1][board[0].length + 1];
        for (int[] turn : skill) {
            int act = turnType[turn[0]] * turn[5];
            sum[turn[1]][turn[2]] += act;
            sum[turn[1]][turn[4]+1] += act*-1;
            sum[turn[3]+1][turn[2]] += act*-1;
            sum[turn[3]+1][turn[4]+1] += act;

        }
        for(int i = 0 ; i< board.length; i++){
            for(int j=0; j<board[0].length ;j++){
                sum[i][j+1] +=sum[i][j];
            }
        }

        for(int j = 0; j<board[0].length; j++){
            for(int i = 0 ;i < board.length; i++){
                sum[i+1][j] += sum[i][j];
            }
        }

        for(int i = 0 ; i< board.length; i++){
            for(int j=0; j<board[0].length ;j++){
                if(sum[i][j] + board[i][j] > 0){
                    answer++;
                }
            }
        }

        return answer;
    }
}
