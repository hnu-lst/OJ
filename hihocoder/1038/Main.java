import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int n, m;
        int[] need;
        int[] value;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        need = new int[n];
        value = new int[m];
        for (int i = 0; i < n; i++) {
            need[i] = sc.nextInt();
            value[i] = sc.nextInt();
        }
        Main sol = new Main();
        System.out.println(sol.solve(n, m, need, value));
        sc.close();
    }

    private int count(int n, int m, int[] need, int[] value) {
        int[][] v = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (i == 0 || j == 0) {
                    v[i][j] = 0;
                } else {
                    if (j >= need[i - 1]) {
                        v[i][j] = Math.max(v[i - 1][j - need[i - 1]] + value[i - 1], v[i - 1][j]);
                    } else {
                        v[i][j] = v[i - 1][j];
                    }
                }
            }
        }
//        for (int i = 0; i < n; i++)
//            System.out.println(Arrays.toString(v[i]));
        return v[n][m];
    }

    private int solve(int n, int m, int[] need, int[] value) {
        int[] v = new int[m + 1];
        for (int i = 0; i < n; i++) {
            for (int j = m; j >= 0; j--) {
                if (j >= need[i]) {
                    v[j] = Math.max(v[j], v[j - need[i]] + value[i]);
                }
            }
        }
        return v[m];
    }
}
