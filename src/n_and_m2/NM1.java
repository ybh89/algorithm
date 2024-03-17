package n_and_m2;

import java.util.Arrays;
import java.util.Scanner;

public class NM1 {
    private static int N, M;
    private static boolean[] visited;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] inputs = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = inputs[0];
        M = inputs[1];
        visited = new boolean[N + 1];

        bt(M, 0, new StringBuilder());
    }

    private static void bt(int pick, int depth, StringBuilder result) {
        if (depth == pick) {
            System.out.println(result.toString().trim());
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                result.append(i + " ");
                bt(pick, depth + 1, result);
                result.delete(result.length() - 2, result.length());
                visited[i] = false;
            }
        }
    }
}
