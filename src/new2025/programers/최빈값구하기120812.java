package new2025.programers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class 최빈값구하기120812 {
    public static void main(String[] args) {
        최빈값구하기120812 sol = new 최빈값구하기120812();
        System.out.println(sol.solution(new int[]{1, 2, 3, 3, 3, 4}));
    }

    public int solution(int[] array) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i : array) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        List<Map.Entry<Integer, Integer>> collect = map.entrySet().stream()
                .sorted((o1, o2) -> o2.getValue() - o1.getValue()).collect(Collectors.toList());

        if (collect.size() == 1) {
            return collect.get(0).getKey();
        }

        if (collect.get(0).getValue().equals(collect.get(1).getValue())) {
            return -1;
        }

        return collect.get(0).getKey();
    }
}
