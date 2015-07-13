public class Solution {
   public int minPathSum(int[][] grid) {
        int xm = grid.length;
        int ym = grid[0].length;
        int[][] pathSum = new int[xm][ym];
        for (int x = 0; x < xm; x++) {
            for (int y = 0; y < ym; y++) {
                if (x == 0 && y == 0) {
                    pathSum[x][y] = grid[x][y];
                } else if (x == 0) {
                    pathSum[x][y] = grid[x][y] + pathSum[x][y - 1];
                } else if (y == 0) {
                    pathSum[x][y] = grid[x][y] + pathSum[x - 1][y];
                } else {
                    pathSum[x][y] = grid[x][y] + Math.min(pathSum[x][y - 1], pathSum[x - 1][y]);
                }
            }
        }
        return pathSum[xm - 1][ym - 1];
    }
}