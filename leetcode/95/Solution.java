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
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> res = new LinkedList<>();
        int[] in = new int[n];
        int[] pre = new int[n];
        for (int i = 0; i < n; i++)
            pre[i] = in[i] = i + 1;
        TreeNode root = buildTree(pre, in);
        if (isBST(root, null, null))
            res.add(root);
        while (hasNext(pre)) {
            next(pre);
            root = buildTree(pre, in);
            if (isBST(root, null, null))
                res.add(root);
        }
        return res;
    }

    private TreeNode buildTree(int[] preorder, int[] inorder) {
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
        root.left = genNode(Arrays.copyOfRange(preorder, 1, 1 + length), Arrays.copyOfRange(inorder, 0, length));
        root.right = genNode(Arrays.copyOfRange(preorder, 1 + length, preorder.length), Arrays.copyOfRange(inorder, length + 1, inorder.length));
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

    private boolean isBST(TreeNode node, TreeNode min, TreeNode max) {
        if (node == null) return true;
        if (min != null && node.val <= min.val) return false;
        if (max != null && node.val >= max.val) return false;
        if (!isBST(node.left, min, node)) return false;
        if (!isBST(node.right, node, max)) return false;
        return true;
    }

    private void next(int[] nums) {//寻找下一个比它大的最小排列
        int first = firstSmallerIndex(nums);
        int next = smallestBiggerIndex(nums, first);
        swap(nums, first, next);
        Arrays.sort(nums, first + 1, nums.length);
    }

    private void swap(int[] nums, int i, int j) {
        nums[i] = nums[i] ^ nums[j];
        nums[j] = nums[i] ^ nums[j];
        nums[i] = nums[i] ^ nums[j];
    }

    private boolean hasNext(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (nums[i] != len - i) return true;
        }
        return false;
    }

    private int firstSmallerIndex(int[] nums) {//从尾到头找第一个逆序的
        int length = nums.length;
        for (int i = length - 1; i > 0; i--) {
            if (nums[i - 1] < nums[i])
                return i - 1;
        }
        return -1;
    }

    private int smallestBiggerIndex(int[] nums, int smallIndex) {//找到smallIndex右边比该数大的最小的那个数的下标
        int smallValue = nums[smallIndex];
        int smallestBiggerValue = Integer.MAX_VALUE;
        int result = 0;
        for (int i = smallIndex + 1; i < nums.length; i++) {
            if (nums[i] > smallValue && nums[i] < smallestBiggerValue) {
                result = i;
            }
        }
        return result;
    }
}