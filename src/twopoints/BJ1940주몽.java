package twopoints;

import java.util.Arrays;
import java.util.Scanner;

public class BJ1940주몽 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int m = Integer.parseInt(scanner.nextLine());
        int[] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();

        int left = 0;
        int right = numbers.length - 1;
        int count = 0;

        while (left < right) {
            int sum = numbers[left] + numbers[right];

            if (sum == m) {
                count++;
                right--;
                left++;
                continue;
            }

            if (sum > m) {
                right--;
                continue;
            }

            left++;
        }
        System.out.println(count);
    }
}
