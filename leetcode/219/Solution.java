public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int len = nums.length;
        if (len < 2) return false;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();// value, index
        for (int i = 0; i < len; i++) {
            int ni = nums[i];
            if (map.containsKey(ni)) {
                if (i - map.get(ni) <= k) {
                    return true;
                } else {
                    map.put(ni, i);
                }
            } else {
                map.put(ni, i);
            }
        }
        return false;
    }
}