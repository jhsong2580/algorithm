class Solution {
    public int[] searchRange(int[] nums, int target) {
        int start = 0;
        int end = nums.length -1;
        int targetIndex = -1;
        while(start <= end){
            int index = (start + end)/2;
            if(nums[index] == target){
                targetIndex = index;
                break;
            }
            if(nums[index] > target){
                end = index -1;
                continue;
            }
            if(nums[index] < target){
                start = index +1;
            }
        }
        if(targetIndex == -1){
            return new int[]{-1, -1};
        }

        start = targetIndex;
        end = targetIndex;
        while(--start >= 0 && nums[start] == target){}
        start++;
        while(++end<=nums.length -1 &&  nums[end] == target){}
        end--;
        return new int[]{start, end};
    }
}