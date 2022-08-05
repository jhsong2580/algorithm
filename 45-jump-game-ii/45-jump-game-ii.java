class Solution {
    private static final int THIS_PATH_ERROR = 1001;
    public int jump(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }

        int[] check = new int[nums.length];
        check[nums.length - 1] = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] == 0) {
                check[i] = THIS_PATH_ERROR;
            } else if (nums[i] + i < nums.length - 1) {
                check[i] = getMinBetween(i, i + nums[i], check) + 1;
            } else {
                check[i] = 1;
            }
        }
        return check[0];
    }

    int getMinBetween(int a, int b, int[] check) {
        int min = Integer.MAX_VALUE;
        for (int i = a+1; i <= b; i++) {
            min = Math.min(min, check[i]);
        }
        return min;
    }
}