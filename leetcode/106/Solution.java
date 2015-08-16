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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return genNode(inorder, postorder);
    }

    private TreeNode genNode(int[] inorder, int[] postorder) {
        //System.out.println("pre: " + Arrays.toString(preorder));
        //System.out.println("in: " + Arrays.toString(inorder));
        int length = inorder.length;
        if (length == 0) return null;
        if (length == 1) return new TreeNode(inorder[0]);

        length = indexOf(inorder, postorder[postorder.length - 1]);//找出后续根节点下标
        TreeNode root = new TreeNode(postorder[postorder.length - 1]);

        root.left = genNode(Arrays.copyOfRange(inorder, 0, length),
                            Arrays.copyOfRange(postorder, 0, length));

        root.right = genNode(Arrays.copyOfRange(inorder, 1 + length, inorder.length),
                             Arrays.copyOfRange(postorder, length, postorder.length - 1));

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