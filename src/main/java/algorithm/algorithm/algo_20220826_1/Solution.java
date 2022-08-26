package algorithm.algorithm.algo_20220826_1;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        nums = Arrays.stream(nums).sorted()
            .toArray();
        List<List<Integer>> result = new LinkedList<>();
        int[] check = new int[nums.length];
        dfs(new LinkedList<>(),  nums, result);

        return result;
    }

    private void dfs(LinkedList<Integer> curNumbers,  int[] nums,
        List<List<Integer>> result) {
        if (curNumbers.size() == nums.length) {
            result.add(copyList(curNumbers));
            return;
        }
        int beforeNumber = -11;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != -11 && beforeNumber != nums[i]){
                beforeNumber = nums[i];
                curNumbers.add(nums[i]);
                int temp = nums[i];
                nums[i] = -11;

                dfs(curNumbers,  nums, result);
                nums[i] = temp;
                curNumbers.removeLast();
            }
        }
    }

    private List<Integer> copyList(List<Integer> source) {
        List<Integer> copy = new LinkedList<>();
        for (Integer integer : source) {
            copy.add(integer);
        }
        return copy;
    }

}
