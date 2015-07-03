public class Solution {

    private static List<List<Integer>> solutions;
    private static int length;

    public List<List<Integer>> permuteUnique(int[] nums) {
        solutions = new LinkedList<List<Integer>>();
        length = nums.length;
        if (length == 0) return solutions;
        Arrays.sort(nums);
        do {
            List<Integer> line = new ArrayList<Integer>(length);
            for (int i = 0; i < length; i++)
                line.add(nums[i]);
            solutions.add(line);
        } while (next(nums));
        return solutions;
    }

    private boolean next(int[] nums) {
        int first = firstSmallerIndex(nums);
        if (first == -1) return false;
        int next = smallestBiggerIndex(nums, first);
        swap(nums, first, next);
        Arrays.sort(nums, first + 1, length);
        return true;
    }

    private void swap(int[] nums, int i, int j) {
        nums[i] = nums[i] ^ nums[j];
        nums[j] = nums[i] ^ nums[j];
        nums[i] = nums[i] ^ nums[j];
    }

    private int firstSmallerIndex(int[] nums) {
        length = nums.length;
        for (int i = length - 1; i > 0; i--) {
            if (nums[i - 1] < nums[i])
                return i - 1;
        }
        return -1;
    }

    private int smallestBiggerIndex(int[] nums, int smallIndex) {//找到smallIndex右边比该数大的最小的那个数的下标
        int smallValue = nums[smallIndex];
        int smallestBiggeValue = Integer.MAX_VALUE;
        int result = 0;
        for (int i = smallIndex + 1; i < nums.length; i++) {
            if (nums[i] > smallValue && nums[i] < smallestBiggeValue) {
                result = i;
            }
        }
        return result;
    }

}