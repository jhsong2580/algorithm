package algorithm.algorithm.algo_20220924_3;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    private int[] result; //0 : plus emot,  1: price
    public int[] solution(int[][] users, int[] emoticons) {
        result = new int[2];
        dfs(users, emoticons, new long[users.length], 0, 10);
        dfs(users, emoticons, new long[users.length], 0, 20);
        dfs(users, emoticons, new long[users.length], 0, 30);
        dfs(users, emoticons, new long[users.length], 0, 40);
        return result;
    }

    private void dfs(int[][] users, int[] emoticons, long[] userPrice, int emo_layer, int discountRate) {
        if (emo_layer == emoticons.length) {
            int plusServiceCount = 0 ;
            long emoticonSales = 0;
            for(int i=0; i< users.length; i++){
                if (userPrice[i] >= users[i][1]) {
                    plusServiceCount++;
                }else{
                    emoticonSales += userPrice[i];
                }
            }
            if((result[0] < plusServiceCount)){
                result[0] = plusServiceCount;
                result[1] = (int)emoticonSales;
            }
            if (result[0] == plusServiceCount && result[1] < emoticonSales) {
                result[1] = (int)emoticonSales;
            }
            return;
        }

        int emoticonPrice = (int)(emoticons[emo_layer] * ((100 - discountRate) / 100.0));
        List<Integer> consumer = new ArrayList<>();

        for(int i=0; i<users.length; i++){
            if(users[i][0] > discountRate){
                continue;
            }
            userPrice[i] += emoticonPrice;
            consumer.add(i);
        }
        dfs(users, emoticons, userPrice, emo_layer + 1, 10);
        dfs(users, emoticons, userPrice, emo_layer + 1, 20);
        dfs(users, emoticons, userPrice, emo_layer + 1, 30);
        dfs(users, emoticons, userPrice, emo_layer + 1, 40);

        for (Integer userIndex : consumer) {
            userPrice[userIndex] -= emoticonPrice;
        }
    }
}
