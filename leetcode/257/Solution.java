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
    
    List<String> result = new LinkedList<String>();

    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) return result;
        if (root.left == null && root.right == null) {
            result.add(root.val + "");
            return result;
        }
        if (root.left != null) dfs(root.left, root.val + "");
        if (root.right != null) dfs(root.right, root.val + "");
        return result;
    }

    private void dfs(TreeNode node, String path) {
        if (node.left == null && node.right == null) {
            result.add(path + "->" + node.val);
            return;
        } else {
            if (node.left != null) dfs(node.left, path + "->" + node.val);
            if (node.right != null) dfs(node.right, path + "->" + node.val);
        }
    }
}