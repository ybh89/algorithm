package inflearn.hash;

import java.util.*;

public class Hash3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] NK = scanner.nextLine().split(" ");
        int k = Integer.parseInt(NK[1]);
        String[] input = scanner.nextLine().split(" ");

        List<Integer> result = solution(k, input);
        StringBuilder stringBuilder = new StringBuilder();
        for (Integer integer : result) {
            stringBuilder.append(integer + " ");
        }
        System.out.println(stringBuilder.toString().trim());
    }

    private static List<Integer> solution(int k, String[] input) {
        List<Integer> results = new ArrayList<>();
        Map<Integer, Integer> type = new HashMap<>();
        for (int i = 0; i < k; i++) {
            type.put(Integer.valueOf(input[i]), type.getOrDefault(Integer.valueOf(input[i]), 0) + 1);
        }
        results.add(type.size());

        int leftIndex = 0;
        int rightIndex = k - 1;
        while (rightIndex < input.length - 1) {
            rightIndex++;
            type.put(Integer.valueOf(input[rightIndex]), type.getOrDefault(Integer.valueOf(input[rightIndex]), 0) + 1);
            type.computeIfPresent(Integer.valueOf(input[leftIndex]), (key, value) -> value - 1);
            if (type.get(Integer.valueOf(input[leftIndex])).equals(0)) {
                type.remove(Integer.valueOf(input[leftIndex]));
            }
            leftIndex++;
            results.add(type.size());
        }

        return results;
    }
}
