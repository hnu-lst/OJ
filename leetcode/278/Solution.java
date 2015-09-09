/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        if (n == 1) return 1;
        int start = 0;
        int end = n;
        int mid = (start >> 1) + (end >> 1) + (start % 2 == 1 && end % 2 == 1 ? 1 : 0);
        int idx = 0;
        while (start <= end) {
            mid = (start >> 1) + (end >> 1) + (start % 2 == 1 && end % 2 == 1 ? 1 : 0);
            boolean isBad = isBadVersion(mid);
            if (isBad) {
                end = mid - 1;
                idx = mid;
            } else {
                start = mid + 1;
            }
        }
        return idx;
    }
}