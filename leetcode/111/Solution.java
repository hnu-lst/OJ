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
   public int minDepth(TreeNode root) {
        if (root == null) return 0;
        dfs(root, 1);
        return min;
    }

    private int min = Integer.MAX_VALUE;

    private void dfs(TreeNode node, int num) {
        if (node.left == null && node.right == null) {
            min = num < min ? num : min;
            return;
        }
        if (node.left != null) dfs(node.left, num + 1);
        if (node.right != null) dfs(node.right, num + 1);
    }
}