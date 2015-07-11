/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
     public ListNode reverseList(ListNode head) {
        if (head == null) return head;
        Stack<ListNode> stack = new Stack<ListNode>();
        ListNode cur = head;
        do {
            stack.push(cur);
            cur = cur.next;
        }
        while (cur != null);
        head = cur = stack.peek();
        while (!stack.isEmpty()) {
            cur.next = stack.pop();
            cur = cur.next;
        }
        cur.next = null;
        return head;
    }
}