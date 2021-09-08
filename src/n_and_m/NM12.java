package n_and_m;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class NM12 {
    private static int N;
    private static String[] numbers;
    private static Set<String> results = new LinkedHashSet<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        numbers = sc.nextLine().split(" ");
        Arrays.sort(numbers);

        permutation(M, new StringBuilder(), 0);
        results.forEach(result -> System.out.println(result));
    }

    private static void permutation(int M, StringBuilder result, int start) {
        if (M == 0) {
            results.add(result.toString().trim());
            return;
        }

        for (int i = start; i < numbers.length; i++) {
            result.append(numbers[i] + " ");
            permutation(M - 1, result, i);
            result.delete(result.length() - numbers[i].length() - 1, result.length());
        }
    }
}
