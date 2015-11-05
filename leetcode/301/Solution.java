public class Solution {
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        if (len <= 1) return len;
        int[] dp = new int[len];//dp[i]表示长度为i+1的子序列中末尾元素最小的值
        Arrays.fill(dp, Integer.MAX_VALUE);
        for (int i = 0; i < len; i++) {
            dp[lowerBound(dp, nums[i])] = nums[i];
        }
        return lowerBound(dp, Integer.MAX_VALUE);
    }

    private int lowerBound(int[] arr, int target) {//找到>=target的最小的下标
        int first = 0, middle;
        int half, len = arr.length;
        while (len > 0) {
            half = len >> 1;
            middle = first + half;
            if (arr[middle] < target) {
                first = middle + 1;
                len = len - half - 1;
            } else {
                len = half;
            }
        }
        return first;
    }
}