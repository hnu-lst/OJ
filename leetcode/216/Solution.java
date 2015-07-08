public class Solution {

    private int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        List<Integer> list = new LinkedList<Integer>();
        doSum(n, result, k, list, -1, 0);
        return result;
    }

    private void doSum(int target, List<List<Integer>> result, int k, List<Integer> list, int start, int sum) {
        if (sum == target && !result.contains(list) && list.size() == k) {
            result.add(new LinkedList<Integer>(list));
        }
        if (sum < target) {
            for (int i = start + 1; i < nums.length; i++) {
                sum += nums[i];
                list.add(nums[i]);
                doSum(target, result, k, list, i, sum);
                sum -= nums[i];
                list.remove(list.size() - 1);
            }
        }
    }
}

