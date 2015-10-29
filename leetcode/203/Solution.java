/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return head;//空链表
        if (head.next == null) {//只有一个元素
            if (head.val == val) return null;
            else return head;
        }

        ListNode H = new ListNode(0);
        H.next = head;

        ListNode prev = H;
        ListNode curr = H.next;

        while (curr != null) {
            if (curr.val == val) {
                curr = deleteNode(prev, curr);
            } else {
                prev = curr;
                curr = curr.next;
            }
        }
        return H.next;
    }

    private ListNode deleteNode(ListNode prev, ListNode curr) {//删除curr节点，并返回curr节点下一个
        prev.next = curr.next;
        return prev.next;
    }
}