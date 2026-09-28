import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;

        int T = sc.nextInt();
        while (T-- > 0 && sc.hasNextInt()) {
            int N = sc.nextInt();
            long[][] grid = new long[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    grid[i][j] = sc.nextLong();
                }
            }

            long[][] dp = new long[N][N];
            dp[0][0] = grid[0][0];

            for (int j = 1; j < N; j++) {
                dp[0][j] = dp[0][j - 1] + grid[0][j];
            }

            for (int i = 1; i < N; i++) {
                dp[i][0] = dp[i - 1][0] + grid[i][0];
            }

            for (int i = 1; i < N; i++) {
                for (int j = 1; j < N; j++) {
                    dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i - 1][j]));
                }
            }

            System.out.println(dp[N - 1][N - 1]);
        }
    }
}
