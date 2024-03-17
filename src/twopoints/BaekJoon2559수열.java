package twopoints;

import java.util.Arrays;
import java.util.Scanner;

public class BaekJoon2559수열 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] inputs = scanner.nextLine().split(" ");
        int n = Integer.parseInt(inputs[0]);
        int k = Integer.parseInt(inputs[1]);
        int[] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int left = 0;
        int right = left + k - 1;
        int sum = 0;

        for (int i = left; i <= right; i++) {
            sum += numbers[i];
        }

        int max = sum;

        while (true) {
            sum -= numbers[left];
            left++;
            right++;
            if (right > numbers.length - 1) break;
            sum += numbers[right];

            if (sum > max) {
                max = sum;
            }
        }

        System.out.println(max);
    }
}
