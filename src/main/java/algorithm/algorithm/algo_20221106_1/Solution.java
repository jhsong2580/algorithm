package algorithm.algorithm.algo_20221106_1;

public class Solution {

    public boolean canJump(int[] nums) {
        boolean[] flags = new boolean[nums.length];
        flags[nums.length-1] = true;
        for(int i = flags.length-1; i>=0; i--){
            if(i == flags.length -1)
                continue;
            flags[i] = checkAvailable(nums, flags, i);
        }
        return flags[0];
    }

    private boolean checkAvailable(int[] nums, boolean[] flags,int index){
        int availableIndex = nums[index];
        for(int i = index+1; i < nums.length && i <= index + availableIndex; i++){
                if(flags[i]){
                    return true;
                }
        }
        return false;
    }
}