package greedy;

import java.util.*;

public class BJ10610_30 {
    private static String[] input;
    private static Set<Integer> visited = new HashSet<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        input = Arrays.stream(scanner.nextLine().split("")).sorted(Comparator.reverseOrder()).toArray(String[]::new);
        bt(0, new StringBuilder());
        System.out.println(-1);
    }

    public static void bt(int depth, StringBuilder combination) {
        if (depth == input.length) {
            int number = Integer.parseInt(combination.toString());
            if (number % 30 == 0) {
                System.out.println(number);
                System.exit(0);
            }
            return;
        }

        for (int i = 0; i < input.length; i++) {
            if (!visited.contains(i)) {
                visited.add(Integer.valueOf(i));
                combination.append(input[i]);
                bt(depth + 1, combination);
                combination.deleteCharAt(combination.length() - 1);
                visited.remove(Integer.valueOf(i));
            }
        }
    }
}
