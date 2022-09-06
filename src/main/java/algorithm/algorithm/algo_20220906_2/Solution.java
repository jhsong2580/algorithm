package algorithm.algorithm.algo_20220906_2;

public class Solution {
    public int firstMissingPositive(int[] nums) {
        int[] check = new int[nums.length];
        int max = 1;
        for(int i = 0 ; i < nums.length; i++){
            if(nums[i] == nums.length){
                max = nums.length;
                check[nums.length -1] = 1;
            }
        }
        for(int i = 0; i < nums.length; i++){
            if (nums[i] > 0 && nums[i] < nums.length) {
                check[nums[i] -1] = 1;
                if(max < nums[i]){
                    max = nums[i];
                }
            }
        }
        for(int i = 0 ; i<check.length;i++){
            if(check[i] == 0){
                return i + 1;
            }
        }
        return max + 1;
    }
}
