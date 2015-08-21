public class Solution {

    public int[] searchRange(int[] nums, int target) {
        int[] range = new int[2];
        range[0] = findFirst(nums, target);
        range[1] = findLast(nums, target);
        return range;
    }

    private int findFirst(int[] nums, int target) {
        int idx = -1;
        int start = 0, end = nums.length - 1, mid = (start + end) >> 1;
        while (start <= end) {
            mid = (start + end) >> 1;
            if (nums[mid] < target) {
                start = mid + 1;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                end = mid - 1;
            }
            if (nums[mid] == target) idx = mid;
        }
        return idx;
    }

    private int findLast(int[] nums, int target) {
        int idx = -1;
        int start = 0, end = nums.length - 1, mid = (start + end) >> 1;
        while (start <= end) {
            mid = (start + end) >> 1;
            if (nums[mid] < target) {
                start = mid + 1;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
            if (nums[mid] == target) idx = mid;
        }
        return idx;
    }
}