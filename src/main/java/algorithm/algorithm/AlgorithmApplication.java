package algorithm.algorithm;


import algorithm.algorithm.algo_20220905_1.Solution;

public class AlgorithmApplication {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] ints = solution.spiralMatrixIII(
            5,6,1,4
        );
        for (int[] anInt : ints) {
            for (int i : anInt) {
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }

}