package twopoints;

import java.util.Arrays;
import java.util.Scanner;

public class BaekJoon3273두수의합 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
        int x = Integer.parseInt(scanner.nextLine());

        int left = 0;
        int right = numbers.length - 1;
        int count = 0;

        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == x) {
                count++;
                left++;
                right--;
                continue;
            }

            if (sum > x) {
                right--;
                continue;
            }

            left++;
        }

        System.out.println(count);
    }
}
