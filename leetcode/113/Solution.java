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
    private List<List<Integer>> result = new LinkedList<List<Integer>>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) return result;
        LinkedList<Integer> list = new LinkedList<Integer>();
        dfs(root, sum, list);
        return result;
    }

    private void dfs(TreeNode node, int remain, List<Integer> list) {
        TreeNode left = node.left;
        TreeNode right = node.right;
        int val = node.val;
        if (left == null && right == null) {
            list.add(val);
            if (remain == val) {
                LinkedList<Integer> copy = new LinkedList<Integer>(list);
                result.add(copy);
            }
            list.remove(list.size() - 1);
            return;
        }
        if (left != null) {
            list.add(val);
            dfs(left, remain - val, list);
            list.remove(list.size() - 1);
        }
        if (right != null) {
            list.add(val);
            dfs(right, remain - val, list);
            list.remove(list.size() - 1);
        }
    }
}