package algorithm.algorithm.algo_20220817_1;

import java.util.LinkedList;
import org.springframework.core.annotation.AnnotationUtils;

public class Solution {

    public void nextPermutation(int[] nums) {
        int i = -1;
        for (i = nums.length -1; i > 0; i--) {
            if (nums[i] <= nums[i - 1]) {
                continue;
            } else {
                break;
            }
        }
        if(i == 0){
            reverse(nums);
            return;
        }
        int min = 101;
        int minIndex = -1;
        for(int j = i ; j < nums.length; j++) {
            if(nums[j] > nums[i-1] && nums[j] < min) {
                min = nums[j];
                minIndex = j;
            }
        }

        int dummy = nums[minIndex];
        nums[minIndex] = nums[i-1];
        nums[i-1] = dummy;

        sort(nums, i);

    }

    private void reverse(int[] nums){
        int[] clone = nums.clone();
        for(int i = nums.length -1; i >= 0; i--){
            nums[nums.length -1 -i] = clone[i];
        }
    }




    private void sort(int[] clone, int start) {
        for(int i=start;i< clone.length;i++){
            for(int j=start;j< clone.length;j++){
                if(clone[i] < clone[j]){
                    int dummy = clone[i];
                    clone[i] = clone[j];
                    clone[j] = dummy;
                }
            }
        }
    }
}
