package n_and_m;

import java.util.Scanner;

/**
 * 백준 - 15650
 */
public class NM2 {
    private static int N;
    private static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        visited = new boolean[N + 1];

        permutation(M, new StringBuilder(), 1);
    }

    private static void permutation(int M, StringBuilder result, int start) {
        if (M == 0) {
            System.out.println(result);
            return;
        }

        for (int i = start; i <= N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                result.append(i + " ");
                permutation(M - 1, result, i + 1);
                result.delete(result.length() - 2, result.length());
                visited[i] = false;
            }
        }
    }
}
