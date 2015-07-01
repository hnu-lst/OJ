public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        int length = nums.length;
        int max = (int) Math.pow(2, length);
        for (int i = 0; i < max; i++) {
            List<Integer> set = new ArrayList<Integer>();
            for (int j = 0; j < length; j++) {
                if (((i >> j) & 1) != 0) {
                    set.add(nums[j]);
                }
            }
            if (!result.contains(set))
                result.add(set);
        }
        return result;
    }
}