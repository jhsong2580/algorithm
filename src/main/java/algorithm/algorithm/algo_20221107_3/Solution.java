package algorithm.algorithm.algo_20221107_3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.boot.autoconfigure.amqp.RabbitProperties.Stream;

public class Solution {

    public int threeSumClosest(int[] nums, int target) {
        int gap = Integer.MAX_VALUE;
        int result = 0;
        Arrays.sort(nums);
        for(int i=0; i<nums.length; i++){
            int base = nums[i];
            int l = 0, r = nums.length-1;
            while(l < r){
                if(l == i){
                    l++;
                    continue;
                }
                if(r == i){
                    r--;
                    continue;
                }
                int sum = base + nums[l] + nums[r];
                if(sum < target){
                    l++;
                }else{
                    r--;
                }
                if (gap > Math.abs(target - sum)) {
                    gap = Math.abs(target - sum);
                    result = sum;
                }
            }
        }
        return result;
    }


}
