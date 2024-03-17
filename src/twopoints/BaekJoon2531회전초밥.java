package twopoints;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class BaekJoon2531회전초밥 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] inputs = scanner.nextLine().split(" ");
        int n = Integer.parseInt(inputs[0]);
        int d = Integer.parseInt(inputs[1]);
        int k = Integer.parseInt(inputs[2]);
        int c = Integer.parseInt(inputs[3]);
        int[] numbers = new int[n];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(scanner.nextLine());
        }

        int left = 0;
        int right = left + k - 1;
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();

        for (int i = left; i <= right; i++) {
            map.put(numbers[i], map.getOrDefault(numbers[i], 0) + 1);
        }

        int max = 0;

        while (true) {
            int count = map.size();

            if (!map.containsKey(c)) {
                count++;
            }

            if (max < count) {
                max = count;
            }

            Integer first = map.keySet().stream().findFirst().get();
            map.computeIfPresent(first, (key, value) -> {
                value--;
                if (value <= 0) {
                    return null;
                }
                return value;
            });
            left++;
            right++;
            left = left % numbers.length;
            right = right % numbers.length;
            map.put(numbers[right], map.getOrDefault(numbers[right], 0) + 1);

            if (left == 0) {
                System.out.println(max);
                break;
            }
        }
    }
}
