package n_and_m2;

import java.util.Arrays;
import java.util.Scanner;

public class NM2 {
    private static int N, M;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] inputs = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = inputs[0];
        M = inputs[1];

        bt(1, M, 0, new StringBuilder());
    }

    private static void bt(int start, int pick, int depth, StringBuilder result) {
        if (depth == pick) {
            System.out.println(result.toString().trim());
            return;
        }

        for (int i = start; i <= N; i++) {
            result.append(i + " ");
            bt(i + 1, pick, depth + 1, result);
            result.delete(result.length() - 2, result.length());
        }
    }
}
