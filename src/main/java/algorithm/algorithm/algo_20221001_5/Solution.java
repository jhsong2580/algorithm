package algorithm.algorithm.algo_20221001_5;

public class Solution {

    private int[] requireSticks = new int[]{6 ,2 ,5 ,5 ,4 ,5 ,6 ,3 ,7 ,6};
    boolean check[][];
    int[] checkNumbers;
    private int madeCount = 0;
    public long solution(int k) {
        checkNumbers = new int[k + 1];
        for(int i=0;i<checkNumbers.length; i++){
            checkNumbers[i] = -1;
        }
        for(int i=1; i< requireSticks.length; i++){
            if (k >= requireSticks[i]) {
                madeCount+= dfs(k - requireSticks[i]);
            }
        }
        if (k == requireSticks[0]) {
            madeCount++;
        }
        return madeCount;
    }

    private int dfs(int k){
        if(k == 0){
            return 1;
        }
        int curMadeCount = 0;
        if (checkNumbers[k] != -1) {
            return checkNumbers[k];
        }
        for(int i=0; i< requireSticks.length; i++){
            if (k >= requireSticks[i]) {
                curMadeCount+= dfs(k - requireSticks[i]);
            }
        }
        checkNumbers[k] = curMadeCount;
        return curMadeCount;
    }
}