/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    private int sum;
    private boolean exists = false;

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        this.sum = sum;
        dfs(root, root.val);
        return exists;
    }

    private void dfs(TreeNode node, int sum) {
        if (node.left == null && node.right == null) {
            if (sum == this.sum) exists = true;
            return;
        }
        if (node.left != null) dfs(node.left, sum + node.left.val);
        if (node.right != null) dfs(node.right, sum + node.right.val);
    }
}