package algorithm.algorithm_2023.algo_03_25_1;

import algorithm.algorithm.algo_20220928_1.Solution.TreeNode;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Solution {

    private Stack<Integer> stack;
    private List<TreeNode> visit;
    private int result = 0;
    public int sumNumbers(TreeNode root) {
        stack = new Stack<>();
        visit = new LinkedList<>();

        dfs(root);
        return result;
    }

    private void dfs(TreeNode node) {
        if(visit.contains(node)) {
            return;
        }
        if(node.left == null && node.right == null) {
           stack.add(node.val);
           result += calculator();
           stack.pop();
           return;
        }
        visit.add(node);
        stack.add(node.val);
        if(node.left != null) {
            dfs(node.left);
        }
        if(node.right != null) {
            dfs(node.right);
        }
        stack.pop();
    }

    private int calculator() {
        int size = stack.size();
        int sum = 0;
        for(int i = 0 ; i < size ; i++) {
            sum += stack.get(i)*(int)Math.pow(10, size -1 -i);
        }
        return sum;
    }
}