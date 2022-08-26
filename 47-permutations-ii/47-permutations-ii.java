class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        nums = Arrays.stream(nums).sorted()
            .toArray();
        List<List<Integer>> result = new LinkedList<>();
        int[] check = new int[nums.length];
        dfs(new LinkedList<>(), 0, nums, result, check);

        return result;
    }

    private void dfs(LinkedList<Integer> curNumbers, int layer, int[] nums,
        List<List<Integer>> result, int[] check) {
        if (layer == nums.length) {
            result.add(copyList(curNumbers));
            return;
        }
        int beforeNumber = -11;
        for (int i = 0; i < nums.length; i++) {
            if(check[i] == 0 && beforeNumber != nums[i]){
                beforeNumber = nums[i];
                curNumbers.add(nums[i]);
                check[i] = 1;

                dfs(curNumbers, layer + 1, nums, result, check);
                check[i] = 0;
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