package algorithm.algorithm.algo_20221112_1;

import com.sun.org.apache.xalan.internal.xsltc.compiler.util.CompareGenerator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {

    public int[] twoSum(int[] nums, int target) {
        List<Nums> numsList = new ArrayList<>();
        for(int i=0; i<nums.length; i++){
            numsList.add(new Nums(nums[i], i));
        }
        Collections.sort(numsList);

        int left = 0, right = nums.length - 1;

        while(left<right){
            int sum = numsList.get(left).getNum() + numsList.get(right).getNum();
            if(sum == target) {
                return new int[]{numsList.get(left).getIndex(), numsList.get(right).getIndex()};
            }

            if(sum < target){
                left++;
                continue;
            }

            if(sum > target){
                right--;
                continue;
            }
        }
        throw new RuntimeException();
    }

    class Nums implements Comparable{
        int num;
        int index;

        public Nums(int num, int index) {
            this.num = num;
            this.index = index;
        }

        @Override
        public int compareTo(Object o) {
            return Integer.compare(num, ((Nums)o).getNum());
        }

        public int getNum() {
            return num;
        }

        public int getIndex() {
            return index;
        }
    }
}
