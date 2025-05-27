package new2025.hackerrank;

import java.io.IOException;
import java.util.List;

class Result {

    public static long getWays(int n, List<Long> c) {
        long[] dp = new long[n + 1];
        dp[0] = 1;

        for (int i = 0; i < c.size(); i++) {
            long coin = c.get(i);
            for (int j = (int)coin; j <= n; j++) {
                dp[j] += dp[(int)(j - coin)];
            }
        }

        return dp[n];
    }
}

public class CoinChange {
    public static void main(String[] args) throws IOException {
        long ways = Result.getWays(3, List.of(2L,8L,3L,1L));
        System.out.println(ways);
    }
}
