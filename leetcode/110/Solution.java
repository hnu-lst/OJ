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
    private boolean isBalanced = true;

    public boolean isBalanced(TreeNode root) {
        height(root, 1);
        return isBalanced;
    }

    private int height(TreeNode root, int height) {
        if (!isBalanced || root == null) return height - 1;
        int heightLeft = height(root.left, height + 1);
        int heightRight = height(root.right, height + 1);
        if (Math.abs(heightLeft - heightRight) > 1)
            isBalanced = false;
        return Math.max(heightLeft, heightRight);
    }
}