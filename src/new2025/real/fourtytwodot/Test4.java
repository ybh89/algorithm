package new2025.real.fourtytwodot;

import java.util.HashMap;
import java.util.Map;

public class Test4 {
    private int minPrice = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Test4 sol = new Test4();
        System.out.println(sol.solution(50, new int[][]{{10, 100000}, {4, 35000}, {1, 15000}}));
        //System.out.println(sol.solution(20, new int[][]{{6, 30000}, {3, 18000}, {4, 28000}, {1, 9500}}));
    }

    public int solution(int n, int[][] battery) {
        combination(0, 0, n, battery, new HashMap<>());
        return minPrice;
    }

    public void combination(int currentPrice, int currentCount, int n, int[][] battery, Map<Integer, Integer> memoization) {
        if (minPrice < currentPrice) {
            return;
        }
        if (currentCount >= n) {
            minPrice = Math.min(minPrice, currentPrice);
            return;
        }
        Integer cache = memoization.get(currentCount);
        if (cache != null && cache <= currentPrice) {
            return;
        }

        memoization.put(currentCount, currentPrice);

        for (int i = 0; i < battery.length; i++) {
            combination(currentPrice + battery[i][1], currentCount + battery[i][0], n, battery, memoization);
        }
    }
}
