package new2025.programers;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class 할인행사131127 {
    public static void main(String[] args) {
        할인행사131127 sol = new 할인행사131127();
        System.out.println(sol.solution(new String[]{"banana", "apple", "rice", "pork", "pot"}, new int[]{3, 2, 2, 2, 1}, new String[]{"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"}));
    }

    public int solution(String[] want, int[] number, String[] discount) {
        Map<String, Integer> wantMap = new HashMap<>();
        Map<String, Integer> currentMap = new LinkedHashMap<>();

        for (int i = 0; i < want.length; i++) {
            wantMap.put(want[i], number[i]);
        }

        for (int i = 0; i < 10; i++) {
            currentMap.put(discount[i], currentMap.getOrDefault(discount[i], 0) + 1);
        }

        int left = 0;
        int right = 9;
        int count = 0;

        while (right < discount.length) {
            if (equals(wantMap, currentMap)) {
                count++;
            }

            if (right == discount.length - 1) {
                break;
            }

            currentMap.compute(discount[left], (s, integer) -> {
                integer -= 1;
                if (integer <= 0) {
                    return null;
                }
                return integer;
            });
            left++;
            right++;
            currentMap.put(discount[right], currentMap.getOrDefault(discount[right], 0) + 1);
        }

        return count;
    }

    public boolean equals(Map<String, Integer> map1, Map<String, Integer> map2) {
        if (map1.size() != map2.size()) {
            return false;
        }

        for (Map.Entry<String, Integer> entry : map1.entrySet()) {
            Integer value = map2.get(entry.getKey());
            if (value == null || !value.equals(entry.getValue())) {
                return false;
            }
        }

        return true;
    }
}
