package greedy;

import java.util.Arrays;
import java.util.Scanner;

public class BJ2217로프 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[] lopes = new int[n];

        for (int i = 0; i < lopes.length; i++) {
            lopes[i] = Integer.parseInt(scanner.nextLine());
        }

        int[] sortedLopes = Arrays.stream(lopes).sorted().toArray();
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < sortedLopes.length; i++) {
            max = Math.max((sortedLopes.length - i) * sortedLopes[i], max);
        }

        System.out.println(max);
    }
}
