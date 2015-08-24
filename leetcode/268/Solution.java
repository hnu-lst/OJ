import java.math.BigInteger;
public class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        BigInteger bi = new BigInteger(String.valueOf(n));
        bi = bi.multiply(new BigInteger(String.valueOf(n + 1)));
        bi = bi.divide(new BigInteger(String.valueOf(2)));
        for (int i = 0; i < n; i++) {
            bi = bi.subtract(new BigInteger(String.valueOf(nums[i])));
        }
        return bi.intValue();
    }
}