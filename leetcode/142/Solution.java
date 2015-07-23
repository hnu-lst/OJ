/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null) return null;
        HashSet<ListNode> hashSet = new LinkedHashSet<ListNode>();
        while (head != null) {
            if (hashSet.contains(head)) return head;
            hashSet.add(head);
            head = head.next;
        }
        return null;
    }
}