public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new LinkedList<String>();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int start = nums[i];
            while (i + 1 < len && nums[i + 1] == nums[ i ] + 1) i++;
            if (nums[i] != start) res.add(start + "->" + nums[i]);
            else res.add(start + "");
        }
        return res;
    }
}