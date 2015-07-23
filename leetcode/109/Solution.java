/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
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
     public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return new TreeNode(head.val);
        ArrayList<ListNode> arrayList = new ArrayList<ListNode>();
        while (head != null) {
            arrayList.add(head);
            head = head.next;
        }
        return build(arrayList, 0, arrayList.size() - 1);
    }

    private TreeNode build(ArrayList<ListNode> arrayList, int s, int e) {
        TreeNode node;
        if (s + 1 == e) {
            node = new TreeNode(arrayList.get(s).val);
            node.right = new TreeNode(arrayList.get(e).val);
        } else if (s == e) {
            node = new TreeNode(arrayList.get(s).val);
        } else {
            int mid = (s + e) >>> 1;
            node = new TreeNode(arrayList.get(mid).val);
            node.left = build(arrayList, s, (mid - 1));
            node.right = build(arrayList, (mid + 1), e);
        }
        return node;
    }
}