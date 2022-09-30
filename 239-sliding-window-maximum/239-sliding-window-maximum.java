class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        LinkedList<Integer> arr = new LinkedList<>();
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