package algorithm.algorithm.algo_20220928_1;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    private int maxSum = Integer.MIN_VALUE;
    private int curSum = 0;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return maxSum;
    }

    private int dfs(TreeNode node){
        int left = 0;
        int right = 0;
        if(node.left != null){
            left = dfs(node.left);
        }
        if(node.right != null){
            right = dfs(node.right);
        }
        int sum = left + right + node.val;
        maxSum = Math.max(sum, maxSum);
        return Math.max(node.val + Math.max(left, right), 0);
    }


    public class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
