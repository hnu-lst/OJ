public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int xm = obstacleGrid.length;
        int ym = obstacleGrid[0].length;
        int[][] path = new int[xm][ym];
        for (int x = 0; x < xm; x++) {
            for (int y = 0; y < ym; y++) {
                if (x == 0 && y == 0) {
                    path[x][y] = (obstacleGrid[x][y] == 1 ? 0 : 1);
                } else if (x == 0) {
                    path[x][y] = (obstacleGrid[x][y] == 1 ? 0 : path[x][y - 1]);
                } else if (y == 0) {
                    path[x][y] = (obstacleGrid[x][y] == 1 ? 0 : path[x - 1][y]);
                } else {
                    path[x][y] = (obstacleGrid[x][y] == 1 ? 0 : path[x - 1][y] + path[x][y - 1]);
                }
            }
        }
        return path[xm - 1][ym - 1];
    }
}