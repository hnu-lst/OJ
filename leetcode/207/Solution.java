public class Solution {

    private static final int UNVISITED = 0;
    private static final int VISITED = 1;
    private static final int SEARCHING = 2;
    private int[] visited;
    private boolean[][] graph;
    private int num;
    private boolean hasLoop;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        num = numCourses;
        visited = new int[numCourses];
        graph = new boolean[numCourses][numCourses];
        for (int i = 0; i < prerequisites.length; i++)
            graph[prerequisites[i][0]][prerequisites[i][1]] = true;
        for (int i = 0; i < numCourses; i++) {
            hasLoop = false;
            hasLoop(i);
            if (hasLoop) return false;
        }
        return true;
    }

    private void hasLoop(int course) {
        visited[course] = SEARCHING;
        for (int i = 0; i < num; i++) {11
            if (graph[course][i] && visited[i] == SEARCHING) {
                hasLoop = true;
                return;
            }
            if (graph[course][i] && visited[i] == UNVISITED) {
                hasLoop(i);
                visited[i] = VISITED;
            }
        }
        visited[course] = VISITED;
    }
}