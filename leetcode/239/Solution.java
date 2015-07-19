public class Solution {
     public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        if (len == 0) return new int[0];
        int[] result = new int[len - k + 1];
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(k, Collections.reverseOrder());
        for (int i = 0; i < k; i++)
            pq.offer(nums[i]);
        result[0] = pq.peek();
        for (int i = k; i < len; i++) {
            pq.remove(nums[i - k]);
            pq.add(nums[i]);
            result[i - k + 1] = pq.peek();
        }
        return result;
    }
}