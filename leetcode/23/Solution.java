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
        ListNode head;
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode n1, ListNode n2) {
                return n1.val - n2.val;
            }
        });
        for (int i = 0; i < len; i++) {
            head = lists[i];
            while (head != null) {
                pq.offer(head);
                head = head.next;
            }
        }
        ListNode newhead = head = pq.peek();
        while (!pq.isEmpty()) {
            head = pq.poll();
            head.next = pq.peek();
        }
        return newhead;
    }
}