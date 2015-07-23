public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int xm = matrix.length;
        int ym = matrix[0].length;
        if (xm == 0 && ym == 0) return false;
        if (target < matrix[0][0] && target > matrix[xm - 1][ym - 1]) return false;
        for (int x = 0; x < xm; x++) {
            if (matrix[x][0] <= target && target <= matrix[x][ym - 1]) {
                int start = 0, end = ym - 1;
                int mid;
                while (start <= end) {
                    mid = (start + end) >>> 1;
                    if (matrix[x][mid] < target) {
                        start = mid + 1;
                    } else if (matrix[x][mid] > target) {
                        end = mid - 1;
                    } else {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}