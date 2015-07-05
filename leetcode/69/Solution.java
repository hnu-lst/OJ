public class Solution {
    
    public int mySqrt(int x) {
        if (x == 0) return 0;
        int left = 0;
        int mid = x;
        int right = x;
        while (left < right - 1) {
            mid = left + (right - left) / 2;
            if (mid < x / mid) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return (right <= x / right ? right : left);
    }

}