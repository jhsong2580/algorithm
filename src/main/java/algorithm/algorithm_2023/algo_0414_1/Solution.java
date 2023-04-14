package algorithm.algorithm_2023.algo_0414_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://www.acmicpc.net/problem/1759
//dfs
public class Solution {
    static int L;
    static int C;
    static String[] alphabet;

    static int[] table;
    static List<String> result;
    static List<String> moumList = Arrays.asList("a", "e", "i", "o", "u");
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] data = br.readLine().split(" ");
        L = Integer.valueOf(data[0]); //
        C = Integer.valueOf(data[1]);
        alphabet = br.readLine().split(" ");
        Arrays.sort(alphabet);
        result = new ArrayList<>();

        dfs(0, 0, 0, "");
        for (String s : result) {
            System.out.println(s);
        }
    }

    private static void dfs(int alphabetIndex, int moumCount, int jaumCount, String curString) {
        if(curString.length() == L) {
            if(moumCount>= 1 && jaumCount >= 2) {
                result.add(curString);
            }
            return;
        }
        if (alphabetIndex == alphabet.length) {
            return;
        }
        boolean isMoum = moumList.contains(alphabet[alphabetIndex]);

        if(isMoum) {
            dfs(alphabetIndex + 1, moumCount + 1, jaumCount, curString + alphabet[alphabetIndex]);
        } else {
            dfs(alphabetIndex + 1, moumCount, jaumCount+1, curString + alphabet[alphabetIndex]);
        }
        dfs(alphabetIndex + 1, moumCount, jaumCount, curString);
    }


}
