package n_and_m;

import java.util.Arrays;
import java.util.Scanner;

public class NM5 {
    private static int N;
    private static String[] numbers;
    private static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        numbers = sc.nextLine().split(" ");
        Arrays.sort(numbers);
        visited = new boolean[N];

        permutation(M, new StringBuilder());
    }

    private static void permutation(int M, StringBuilder result) {
        if (M == 0) {
            System.out.println(result);
            return;
        }

        for (int i = 0; i < numbers.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                result.append(numbers[i] + " ");
                permutation(M - 1, result);
                result.delete(result.length() - numbers[i].length() - 1, result.length());
                visited[i] = false;
            }
        }
    }
}
