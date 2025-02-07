package new2025.programers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class 귤고르기138476 {
    public static void main(String[] args) {
        귤고르기138476 sol = new 귤고르기138476();
        System.out.println(sol.solution(6, new int[]{5,5,1,4,3,5,5}));
    }

    public int solution(int k, int[] tangerine) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i : tangerine) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        List<Map.Entry<Integer, Integer>> sortedEntry = map.entrySet().stream()
                .sorted((o1, o2) -> o2.getValue() - o1.getValue())
                .collect(Collectors.toList());

        int count = 1;
        int k2 = k;

        if (k <= sortedEntry.get(0).getValue()) {
            return 1;
        }
        for (Map.Entry<Integer, Integer> entry : sortedEntry) {
            k2 -= entry.getValue();
            count++;

            if (k2 <= 0) {
                return count - 1;
            }
        }

        return count;
    }
}
