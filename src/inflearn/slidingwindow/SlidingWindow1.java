package inflearn.slidingwindow;

import java.util.Arrays;
import java.util.Scanner;

public class SlidingWindow1 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String[] NK = scanner.nextLine().split(" ");
        int k = Integer.parseInt(NK[1]);
        String[] input = scanner.nextLine().split(" ");
        int[] sales = Arrays.stream(input)
                .mapToInt(Integer::parseInt)
                .toArray();

        int max = solution(k, sales);
        System.out.println(max);
    }

    private static int solution(int k, int[] sales) {
        int basis = 0;
        for (int i = 0; i < k; i++) {
            basis += sales[i];
        }

        int max = basis;
        for (int i = 1; i <= sales.length - k; i++) {
            basis = basis - sales[i - 1];
            basis = basis + sales[i + k - 1];

            if (max < basis) {
                max = basis;
            }
        }

        return max;
    }
}
