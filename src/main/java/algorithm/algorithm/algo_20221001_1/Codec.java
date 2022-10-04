package algorithm.algorithm.algo_20221001_1;

import algorithm.algorithm.algo_20220928_1.Solution;
import algorithm.algorithm.algo_20220928_1.Solution.TreeNode;
import java.util.LinkedList;

public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        LinkedList<TreeNode> childs = new LinkedList<>();
        if (root == null) {
            return "";
        }
        childs.push(root);
        LinkedList<String> result = new LinkedList<>();
        while (childs.size() != 0) {
            TreeNode node = childs.pop();
            if(node == null){
                result.add("null");
                continue;
            }
            childs.addLast(node.left);
            childs.addLast(node.right);

            result.add(String.valueOf(node.val));
        }
        return result.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.trim().equals("[]")) {
            return null;
        }
        String[] sources = null;
        try{
            sources = data.substring(1, data.length()-1).trim().split(",");
        }catch(Exception e){
            return null;
        }


        LinkedList<TreeNode> nodes = new LinkedList<>();
        if(sources.length == 0){
            return null;
        }
        TreeNode treeNode = makeTreeNode(sources[0]);
        if (sources.length == 1) {
            return treeNode;
        }
        nodes.add(treeNode);
        boolean isLeft = true;
        for(int i=1; i< sources.length; i++){
            if(isLeft){
                TreeNode node = nodes.getFirst();
                node.left = makeTreeNode(sources[i]);
                if(node.left != null){
                    nodes.addLast(node.left);
                }
            }else{
                TreeNode node = nodes.pop();
                node.right = makeTreeNode(sources[i]);
                if(node.right != null){
                    nodes.addLast(node.right);
                }
            }
            isLeft = !isLeft;
        }
        return treeNode;
    }

    private TreeNode makeTreeNode(String source){
        if (source.trim().equals("null")) {
            return null;
        }
        TreeNode treeNode = new TreeNode(Integer.parseInt(source.trim()));
        return treeNode;
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
