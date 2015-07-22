/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        int len = lists.length;
        if (len == 0) return null;
        if (len == 1) return lists[0];
        if (len == 2) return merge(lists[0], lists[1]);
        while (len > 1) {
            for (int i = 0; i < len / 2; i++) {
                lists[i] = merge(lists[i], lists[len - 1 - i]);
            }
            len = (len / 2 + len % 2);
        }
        return lists[0];
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) return null;
        ListNode pre = new ListNode(0);
        ListNode node = pre;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                node.next = l1;
                node = l1;
                l1 = l1.next;
            } else {
                node.next = l2;
                node = l2;
                l2 = l2.next;
            }
        }
        if (l1 == null && l2 != null) {
            node.next = l2;
        } else if (l1 != null && l2 == null) {
            node.next = l1;
        }
        return pre.next;
    }
}