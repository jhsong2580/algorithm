package algorithm.algorithm.algo_20220922_3;

import java.util.HashMap;
import java.util.LinkedList;

public class Solution {
    public boolean isValid(String s) {
        LinkedList<Character> stack = new LinkedList<>();
        HashMap<Character, Character> render = new HashMap<>();
        render.put('}', '{');
        render.put(')', '(');
        render.put(']', '[');
        for(int i=0; i<s.length(); i++){
            char curChar = s.charAt(i);
            if (curChar == '{' || curChar == '(' || curChar == '[') {
                stack.add(curChar);
            }else{
                curChar = render.get(curChar);
                if(stack.size() == 0){
                    return false;
                }
                if(stack.getLast() == curChar){
                    stack.removeLast();
                }else{
                    return false;
                }
            }
        }
        return stack.size() == 0;
    }
}
