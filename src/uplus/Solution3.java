package uplus;

import java.util.*;

public class Solution3 {
    public static void main(String[] args) {
        // System.out.println(Arrays.toString(solution(new int[]{1,3,3,2,4,3,3,2,4,2,2,4})));
        // System.out.println(Arrays.toString(solution(new int[]{1,1,3,3,3,3,1,3,3,3,3,2})));
        System.out.println(Arrays.toString(solution(new int[]{1,2,3,4})));
    }

    public static int[] solution(int[] people) {
        Map<Integer, Integer> coupons = new HashMap<>();
        List<Integer> results = new ArrayList<>();

        for (int id : people) {
            coupons.compute(id, (key, value) -> {
                if (value == null) {
                    return 1;
                }

                if (value.equals(3)) {
                    results.add(key);
                    return null;
                }

                return value + 1;
            });
        }

        if (results.isEmpty()) {
            return new int[]{-1};
        }

        return results.stream().mapToInt(value -> value).toArray();
    }
}
