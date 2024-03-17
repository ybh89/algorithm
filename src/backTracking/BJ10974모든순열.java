package backTracking;

import java.util.*;

public class BJ10974모든순열 {
    private static int n;
    private static Set<Integer> visited = new HashSet<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = Integer.parseInt(scanner.nextLine());
        bt(0, new StringBuilder());
    }

    public static void bt(int depth, StringBuilder combination) {
        if (depth == n) {
            System.out.println(combination);
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (!visited.contains(i)) {
                visited.add(i);
                combination.append(i).append(" ");
                bt(depth + 1, combination);
                combination.delete(combination.length() - 2, combination.length());
                visited.remove(i);
            }
        }
    }
}
