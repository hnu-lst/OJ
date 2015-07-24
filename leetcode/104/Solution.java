public class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        dfs(root, 1);
        return max;
    }

    private int max = Integer.MIN_VALUE;

    private void dfs(TreeNode node, int num) {
        if (node.left == null && node.right == null) {
            max = num > max ? num : max;
            return;
        }
        if (node.left != null) dfs(node.left, num + 1);
        if (node.right != null) dfs(node.right, num + 1);
    }
}