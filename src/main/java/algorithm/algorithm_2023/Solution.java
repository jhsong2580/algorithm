package algorithm.algorithm_2023;

import algorithm.algorithm.algo_20220928_1.Solution.TreeNode;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {
    private Queue<NodeDetailInfo> queue;
    private List<List<Integer>> result = null;
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        result = new LinkedList<>();
        queue = new LinkedList<>();
        if(root == null) {
            return result;
        }
        queue.add(new NodeDetailInfo(root, 0));

        while(!queue.isEmpty()) {
            NodeDetailInfo detail = queue.poll();
            if(result.size() == detail.depth) {
                result.add(new LinkedList<>());
            }

            List<Integer> list = result.get(detail.depth);
            list.add(detail.node.val);

            if(detail.node.left != null) {
                queue.add(new NodeDetailInfo(detail.node.left, detail.depth +1));
            }
            if(detail.node.right != null) {
                queue.add(new NodeDetailInfo(detail.node.right, detail.depth +1));
            }
        }

        Collections.reverse(result);
        return result;
    }

    private static class NodeDetailInfo {
        TreeNode node;
        int depth;

        public NodeDetailInfo(TreeNode node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }
}
