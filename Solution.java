import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;

        int T = sc.nextInt();
        while (T-- > 0 && sc.hasNextInt()) {
            int V = sc.nextInt();
            int N = sc.nextInt();

            int[] C = new int[N];
            for (int i = 0; i < N; i++) {
                C[i] = sc.nextInt();
            }

            int[] dp = new int[V + 1];
            int[] parent = new int[V + 1];
            int[] coinUsed = new int[V + 1];

            Arrays.fill(dp, 1000000000);
            dp[0] = 0;

            for (int i = 1; i <= V; i++) {
                for (int coin : C) {
                    if (coin <= i && dp[i - coin] != 1000000000) {
                        if (dp[i - coin] + 1 < dp[i]) {
                            dp[i] = dp[i - coin] + 1;
                            parent[i] = i - coin;
                            coinUsed[i] = coin;
                        }
                    }
                }
            }

            if (dp[V] >= 1000000000) {
                System.out.println("-1");
            } else {
                List<Integer> resultCoins = new ArrayList<>();
                int curr = V;
                while (curr > 0) {
                    resultCoins.add(coinUsed[curr]);
                    curr = parent[curr];
                }

                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < resultCoins.size(); i++) {
                    sb.append(resultCoins.get(i));
                    if (i < resultCoins.size() - 1) {
                        sb.append(" ");
                    }
                }
                System.out.println(sb.toString());
                System.out.println(dp[V]);
            }
        }
    }
}
