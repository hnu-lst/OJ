/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return genNode(preorder, inorder);
    }

    private TreeNode genNode(int[] preorder, int[] inorder) {
        //System.out.println("pre: " + Arrays.toString(preorder));
        // System.out.println("in: " + Arrays.toString(inorder));
        int length = preorder.length;
        if (length == 0) return null;
        if (length == 1) return new TreeNode(preorder[0]);
        length = indexOf(inorder, preorder[0]);
        TreeNode root = new TreeNode(preorder[0]);
        root.left = genNode(
                Arrays.copyOfRange(preorder, 1, 1 + length),
                Arrays.copyOfRange(inorder, 0, length));
        root.right = genNode(
                Arrays.copyOfRange(preorder, 1 + length, preorder.length),
                Arrays.copyOfRange(inorder, length + 1, inorder.length));
        return root;

    }

    private int indexOf(int[] arr, int target) {
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            if (arr[i] == target)
                return i;
        }
        return 0;
    }

}