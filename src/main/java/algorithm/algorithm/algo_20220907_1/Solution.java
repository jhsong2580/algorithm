package algorithm.algorithm.algo_20220907_1;

public class Solution {

    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int left_max = height[0];
        int right_max = height[right];
        int water = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                left++;
                if (left_max < height[left]) {
                    left_max = height[left];
                } else {
                    water += left_max - height[left];
                }
            } else {
                right--;
                if (right_max < height[right]) {
                    right_max = height[right];
                } else {
                    water += right_max - height[right];
                }
            }
        }
        return water;
    }
}
