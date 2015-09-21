public class Solution {
    public void moveZeroes(int[] nums) {
        int len = nums.length;
        int idx = 0;//非0元素下标
        for (int i = 0; i < len; i++) {
            if (nums[i] == 0) {
                continue;
            } else {
                nums[idx] = nums[i];
                idx++;
            }
        }
        for (int i = idx; i < len; i++)
            nums[i] = 0;
    }
}