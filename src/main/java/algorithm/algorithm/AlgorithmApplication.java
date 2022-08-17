package algorithm.algorithm;


import algorithm.algorithm.algo_20220817_1.Solution;
import java.util.LinkedList;
import java.util.List;
import sun.awt.image.ImageWatched.Link;

public class AlgorithmApplication {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {3,2,1};
        solution.nextPermutation(arr);
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }

}