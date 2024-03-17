package backTracking;

import java.util.*;

public class BJ10819차이를최대로 {
    private static int[] numbers;
    private static Set<Integer> visited = new HashSet<>();
    private static int max = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        numbers = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        bt(new ArrayList<>());
        System.out.println(max);
    }

    public static void bt(List<Integer> result) {
        if (result.size() == numbers.length) {
            System.out.println(result);
            int sum = 0;
            for (int i = 0; i < result.size() - 1; i++) {
                sum += Math.abs(result.get(i) - result.get(i + 1));
            }
            if (max < sum) {
                max = sum;
            }
            return;
        }

        for (int i = 0; i < numbers.length; i++) {
            if (!visited.contains(i)) {
                visited.add(i);
                result.add(numbers[i]);
                bt(result);
                result.remove(result.size() - 1);
                visited.remove(i);
            }
        }
    }
}
