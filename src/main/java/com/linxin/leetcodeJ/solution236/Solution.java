package com.linxin.leetcodeJ.solution236;


public class Solution {

    private TreeNode ans;

    private boolean recurseTree(TreeNode currentNode, TreeNode p, TreeNode q) {
        if (currentNode == null) {
            return false;
        }

        int left = recurseTree(currentNode.left, p, q) ? 1 : 0;
        int right = recurseTree(currentNode.right, p, q) ? 1 : 0;

        int mid = (currentNode == p || currentNode == q) ? 1 : 0;

        if (mid + left + right >= 2) {
            this.ans = currentNode;
        }

        return (left + mid + right) > 0;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        recurseTree(root, p, q);
        return ans;
    }
}
