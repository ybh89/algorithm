package combination;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 2668
 */
public class 숫자고르기 {
    private static int maxCount = 0;
    private static List<Integer> result = new ArrayList<>();
    private static int N;
    private static int[] numbers;
    private static Set<Integer> firstSet = new LinkedHashSet<>();
    private static Set<Integer> secondSet = new HashSet<>();
    private static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = Integer.parseInt(sc.nextLine());
        numbers = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            numbers[i] = Integer.parseInt(sc.nextLine());
        }
        visited = new boolean[N + 1];

        for (int i = 1; i <= numbers.length; i++) {
            backtracking(i, 1);
        }
        System.out.println(result.size());
        result.forEach(integer -> System.out.println(integer));
    }

    private static void backtracking(int selectNumber, int start) {
        if (selectNumber == 0) {
            if (isSameSet() && maxCount < firstSet.size()) {
                maxCount = firstSet.size();
                result = firstSet.stream().collect(Collectors.toList());
            }
            return;
        }

        for (int i = start; i < numbers.length; i++) {
            visited[i] = true;
            firstSet.add(i);
            secondSet.add(numbers[i]);
            backtracking(selectNumber - 1, i + 1);
            secondSet.remove(numbers[i]);
            firstSet.remove(i);
            visited[i] = false;
        }
    }

    private static boolean isSameSet() {
        for (Integer number : firstSet) {
            if (!secondSet.contains(number)) {
                return false;
            }
        }
        return true;
    }
}
