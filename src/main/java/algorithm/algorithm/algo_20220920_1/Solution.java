package algorithm.algorithm.algo_20220920_1;

public class Solution {
    private boolean isEnd = false; ;
    public boolean isMatch(String s, String p) {
        boolean[] dp = new boolean[s.length() + 1]; // 시작. p는 0번째,
        dp[0] = true; // p도 하나도 안보고 s도 하나도 보지 않는다

        for(int i = 1; i<= p.length(); i++){
            boolean[] temp = new boolean[s.length()+1]; //p는 i번째
            for(int j = 0; j<= s.length(); j++){
                if(p.charAt(i -1) == '*'){
                    if(j == 0){ //s는 하나도 안보고, p는 보았네. 근데 p가 아무거나 들어올수 있는것.
                        temp[j] = dp[j];
                    }else{
                        temp[j] = dp[j-1] || dp[j] || temp[j-1]; // [s-1][p-1](현재 인덱스부터 * 시작) || [s-1][p](s-1과 동일하게 *탐색) || [s][p-1](전 p에서 공백으로)
                    }
                }else{
                    if(j == 0){
                        temp[j] = false;
                    }else{
                        if(p.charAt(i-1) == '?'){
                            temp[j] = dp[j-1]; // [s-1][p-1]
                        }else{
                            temp[j] = dp[j - 1] && p.charAt(i - 1) == s.charAt(j - 1); // [s-1][p-1] && 글자가 맞는지
                        }
                    }

                }
            }
            dp = temp;
        }
        return dp[s.length()];
    }

}
