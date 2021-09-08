package n_and_m;

import java.util.Scanner;

/**
 * 백준 - 15649
 * 순열
 */
public class NM1 {
    private static int N;
    private static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        visited = new boolean[N + 1];

        permutation(M, new StringBuilder());
    }

    private static void permutation(int M, StringBuilder result) {
        if (M == 0) {
            System.out.println(result);
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                result.append(i + " ");
                permutation(M - 1, result);
                result.delete(result.length() - 2, result.length());
                visited[i] = false;
            }
        }
    }
}
