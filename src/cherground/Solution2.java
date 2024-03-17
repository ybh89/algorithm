package cherground;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    private int[] gold_prices;
    private int maxBenefit = -1;

    public int solution(int[] gold_prices) {
        this.gold_prices = gold_prices;
        calculateMaxBenefit(0, new ArrayList<>());
        return maxBenefit;
    }

    public void calculateMaxBenefit(int start, List<Integer> combination) {
        if (isValid(combination)) {
            int benefit = 0;
            for (int i = 1; i < combination.size(); i += 2) {
                int purchaseAmount = gold_prices[combination.get(i - 1)];
                int salesAmount = gold_prices[combination.get(i)];

                benefit += salesAmount - purchaseAmount;
            }

            if (maxBenefit < benefit) {
                maxBenefit = benefit;
            }
        }

        for (int i = start; i < gold_prices.length; i++) {
            combination.add(i);
            calculateMaxBenefit(i + 1, combination);
            combination.remove(combination.size() - 1);
        }
    }

    private boolean isValid(List<Integer> combination) {
        if (combination.isEmpty()) {
            return false;
        }

        if (combination.size() % 2 == 1) {
            return false;
        }

        boolean hasSold;
        for (int i = 0; i < combination.size() - 1; i++) {
            if (i % 2 == 1) {
                hasSold = true;
            } else {
                hasSold = false;
            }

            if (hasSold) {
                if (combination.get(i + 1) - combination.get(i) == 1) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        //System.out.println(solution2.solution(new int[]{2,5,1,3,4}));
        // System.out.println(solution2.solution(new int[]{7,2,5,6,1,4,2,8}));
        System.out.println(solution2.solution(new int[]{7}));
    }
}
