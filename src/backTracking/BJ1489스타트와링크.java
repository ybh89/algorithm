package backTracking;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class BJ1489스타트와링크 {
    private static int n;
    private static int m;
    private static int[][] map;
    private static List<Integer> result = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = Integer.parseInt(scanner.nextLine());
        m = n / 2;
        map = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            int[] inputs = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            System.arraycopy(inputs, 0, map[i], 1, inputs.length);
        }

        bt(0, 1,  new LinkedHashSet<>());

        int left = 0;
        int right = result.size() - 1;
        int min = Integer.MAX_VALUE;

        while (left < right) {
            int abs = Math.abs(result.get(left) - result.get(right));
            min = Math.min(abs, min);
            left++;
            right--;
        }

        System.out.println(min);
    }

    public static void bt(int depth, int start, LinkedHashSet<Integer> combination) {
        if (depth == m) {
            AtomicInteger score = new AtomicInteger();
            combination.forEach(integer -> combination.forEach(integer1 -> score.addAndGet(map[integer][integer1])));
            result.add(score.get());
            return;
        }

        for (int i = start; i <= n; i++) {
            if (!combination.contains(i)) {
                combination.add(i);
                bt(depth + 1, i + 1, combination);
                combination.remove(i);
            }
        }
    }
}
