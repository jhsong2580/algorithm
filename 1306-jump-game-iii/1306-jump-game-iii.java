class Solution {
    public boolean canReach(int[] arr, int start) {
        int[] check = new int[arr.length];
        int target = findZero(arr);
        if(target == -1)
            return false;
        return dfs(start, target, check, arr);

    }

    private int findZero(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                return i;
            }
        }
        return -1;
    }

    private boolean dfs(int index, int target, int[] check, int[] arr) {
        if (index >= check.length) {
            return false;
        }
        if (index < 0) {
            return false;
        }
        if (arr[index] == 0) {
            return true;
        }
        if (check[index] == 1) {
            return false;
        }
        check[index] = 1;
        if (dfs(index + arr[index], target, check, arr)) {
            return true;
        }
        if (dfs(index - arr[index], target, check, arr)) {
            return true;
        }
        return false;

    }
}