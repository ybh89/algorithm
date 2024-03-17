package n_and_m2;

import java.util.Arrays;
import java.util.Scanner;

public class NM5 {
    private static int N, M;
    private static int[] numbers;
    private static boolean[] visited;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] inputs = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = inputs[0];
        M = inputs[1];

        numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
        visited = new boolean[N];

        bt(M, 0, "");
        System.out.println(sb);
    }

    private static void bt(int pick, int depth, String result) {
        if (depth == pick) {
            sb.append(result.trim() + "\n");
            return;
        }

        for (int i = 0; i < numbers.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                bt(pick, depth + 1, result + " " + numbers[i]);
                visited[i] = false;
            }
        }
    }
}
