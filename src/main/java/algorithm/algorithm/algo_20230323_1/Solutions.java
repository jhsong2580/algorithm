package algorithm.algorithm.algo_20230323_1;

import java.util.Stack;
/**
 * https://leetcode.com/problems/simplify-path/description/
*/
public class Solutions {


    public String simplifyPath(String path) {
        path = path.replaceAll("//", "/");

        char[] chars = path.toCharArray();
        Stack<String> stack = new Stack<>();

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '/') {
                continue;
            }
            String dummy = "";
            while (i < chars.length && chars[i] != '/') {
                dummy += chars[i];
                i++;
            }
            if (dummy.equals(".")) {
                continue;
            }
            if (dummy.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                    continue;
                }
            } else {
                stack.add(dummy);
            }
        }

        if(stack.size() == 0) {
            return "/";
        }

        String result = "/";
        for (String s : stack) {
            result += s;
            result += "/";
        }

        return result.substring(0, result.length() - 1);
    }


}
