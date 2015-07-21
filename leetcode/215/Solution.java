public class Solution {
    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>(len, Collections.reverseOrder());
        for (int i = 0; i < len; i++)
            priorityQueue.offer(nums[i]);
        int head = 0;
        for (int i = 0; i < k; i++)
            head = priorityQueue.poll();
        return head;
    }
}