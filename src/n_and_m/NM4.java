package n_and_m;

import java.util.Scanner;

public class NM4 {
    private static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        permutation(M, new StringBuilder(), 1);
    }

    private static void permutation(int M, StringBuilder result, int start) {
        if (M == 0) {
            System.out.println(result);
            return;
        }

        for (int i = start; i <= N; i++) {
            result.append(i + " ");
            permutation(M - 1, result, i);
            result.delete(result.length() - 2, result.length());
        }
    }
}
