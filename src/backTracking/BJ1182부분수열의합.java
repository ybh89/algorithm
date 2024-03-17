package backTracking;

import java.util.*;

public class BJ1182부분수열의합 {
    private static int[] numbers;
    private static int s;
    private static int count = 0;
    private static Set<Integer> visited = new HashSet<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] inputs = scanner.nextLine().split(" ");
        int n = Integer.parseInt(inputs[0]);
        s = Integer.parseInt(inputs[1]);
        numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for (int i = 1; i <= n; i++) {
            bt(i, 0, 0, new ArrayList<>());
        }
        System.out.println(count);
    }

    public static void bt(int pick, int depth, int start, List<Integer> combination) {
        if (depth == pick) {
            int sum = 0;
            for (Integer integer : combination) {
                sum += integer;
            }
            if (sum == s) {
                count++;
            }
            return;
        }

        for (int i = start; i < numbers.length; i++) {
            if (!visited.contains(i)) {
                visited.add(i);
                combination.add(numbers[i]);
                bt(pick, depth + 1, i + 1, combination);
                combination.remove(Integer.valueOf(numbers[i]));
                visited.remove(i);
            }
        }
    }
}
