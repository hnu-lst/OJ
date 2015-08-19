public class Solution {
    public int[] singleNumber(int[] nums) {
        int len = nums.length;
        HashSet<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < len; i++) {
            if (set.contains(nums[i])) {
                set.remove(nums[i]);
            } else {
                set.add(nums[i]);
            }
        }
        int[] res = new int[2];
        Iterator it = set.iterator();
        res[0] = (Integer) it.next();
        res[1] = (Integer) it.next();
        return res;
    }
}