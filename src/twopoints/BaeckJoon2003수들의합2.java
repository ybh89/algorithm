package twopoints;

import java.util.Arrays;
import java.util.Scanner;

public class BaeckJoon2003수들의합2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] inputs = scanner.nextLine().split(" ");
        int n = Integer.parseInt(inputs[0]);
        int m = Integer.parseInt(inputs[1]);
        int[] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int left = 0;
        int right = 0;
        int sum = numbers[left];
        int count = 0;

        while (right <= numbers.length - 1) {
            if (sum == m) {
                count++;
                right++;
                if (right > numbers.length - 1) break;
                sum += numbers[right];
                continue;
            }
            if (sum > m) {
                sum -= numbers[left];
                left++;
                if (left > numbers.length - 1) break;
                continue;
            }
            if (sum < m) {
                right++;
                if (right > numbers.length - 1) break;
                sum += numbers[right];
            }
        }

        System.out.println(count);
    }
}
