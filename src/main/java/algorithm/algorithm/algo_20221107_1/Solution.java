package algorithm.algorithm.algo_20221107_1;

public class Solution {
    public int strStr(String haystack, String needle) {
        int[][] check = new int[needle.length()][haystack.length()];
        for(int j=0; j<haystack.length();j++){
            if(needle.charAt(0) == haystack.charAt(j)){
                check[0][j] = 1;
                if(needle.length() == 1){
                    return j;
                }
            }
        }
        for(int j = 0; j<needle.length(); j++){
            if(needle.charAt(j) == haystack.charAt(0)){
                check[j][0] = 1;
            }
        }
        for(int i=1;i<needle.length(); i++){
            char source = needle.charAt(i);
            for(int j=1;j<haystack.length(); j++){
                char dst = haystack.charAt(j);
                if(source != dst){
                    check[i][j]= 0;
                    continue;
                }
                check[i][j] = check[i-1][j-1]+1;
                if(check[i][j] == needle.length()){
                    return j - needle.length() +1;
                }

            }
        }
        return -1;
    }
}
