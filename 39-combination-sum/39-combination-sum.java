class Solution {

    private Set<String> resultSet = new HashSet<>();
    private List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new LinkedList<>();
                for(int i = 0; i<candidates.length; i++){
            for(int j=0; j<candidates.length; j++){
                if(candidates[i] > candidates[j]){
                    int temp = candidates[i];
                    candidates[i] = candidates[j];
                    candidates[j] = temp;
                }
            }
        }
        dfs(candidates, 0, new LinkedList<>(), target, 0);
        return result;
    }

    private void dfs(int[] candidates, int index, List<Integer> joinCandidates, int target, int sum){
        if(index == candidates.length){
            return;
        }
        if(sum > target){
            return;
        }
        if(sum == target){
            List<Integer> copy = new LinkedList<>();
            String a = "";
            for (Integer joinCandidate : joinCandidates) {
                copy.add(joinCandidate);
                a += joinCandidate;
            }
            if (resultSet.contains(a)) {
                return;
            }
            result.add(copy);
            resultSet.add(a);
            return;
        }

        //날 더하지 않고 다음꺼 보기
        dfs(candidates, index + 1, joinCandidates, target, sum);

        sum += candidates[index];
        joinCandidates.add(candidates[index]);
        //날 더하고 다음꺼 보기
        dfs(candidates, index + 1, joinCandidates, target, sum);
        //날 더하고 계속 날 보기
        dfs(candidates, index, joinCandidates, target, sum);
        joinCandidates.remove((Object) candidates[index]);
    }
}