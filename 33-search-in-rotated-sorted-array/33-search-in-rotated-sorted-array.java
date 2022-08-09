class Solution {
    public int search(int[] nums, int target) {

        int startIndex = 0;
        int endIndex = nums.length - 1;

        while (startIndex <= endIndex) {
            int midIndex = (startIndex + endIndex) / 2;
            if(target == nums[midIndex]){
                return midIndex;
            }

            if (nums[startIndex] <= nums[midIndex]) {
                if(nums[midIndex] > target && nums[startIndex] <= target){ // go left
                    endIndex = midIndex -1;
                }else{
                    startIndex = midIndex +1;
                }
            }else{
                if(nums[midIndex] < target && nums[endIndex] >= target){
                    startIndex = midIndex +1;
                }else{
                    endIndex = midIndex -1;
                }
            }
        }
        return -1;
    }
}