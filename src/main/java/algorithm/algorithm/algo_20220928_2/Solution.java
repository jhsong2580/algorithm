package algorithm.algorithm.algo_20220928_2;

import java.util.LinkedList;

public class Solution {

    public int[] maxSlidingWindow(int[] nums, int k) {
        LinkedList<Integer> arr = new LinkedList<>(); // nums의 인덱스를 가진다. 가장 왼쪽에 있는 index가 가장 큰 값을 가지는 index이다.
        int[] result = new int[nums.length - k + 1];
        int ri = 0;
        for (int i = 0; i < nums.length; i++) {
            while (arr.size() != 0 && arr.getFirst() < i- k + 1) {
                arr.removeFirst();
            }
            while (arr.size() != 0 && nums[arr.getLast()] < nums[i]) {
                arr.removeLast();
            }
            arr.addLast(i);
            if (i >= k - 1) {
                result[ri++] = nums[arr.getFirst()];
            }
        }
        return result;
    }
}
