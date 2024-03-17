package inflearn.slidingwindow;

import java.util.Arrays;
import java.util.Scanner;

public class SlidingWindow2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] NM = scanner.nextLine().split(" ");
        int m = Integer.parseInt(NM[1]);
        String[] input = scanner.nextLine().split(" ");
        int[] numbers = Arrays.stream(input)
                .mapToInt(Integer::parseInt)
                .toArray();

        int count = solution(m, numbers);
        System.out.println(count);
    }

    private static int solution(int m, int[] numbers) {
        int leftIndex = 0;
        int rightIndex = 0;
        int sum = numbers[rightIndex];
        int count = 0;

        while (true) {
            if (rightIndex == numbers.length - 1 && sum < m) {
                break;
            }

            if (sum < m) {
                rightIndex++;
                sum += numbers[rightIndex];
            }
            else {
                sum -= numbers[leftIndex];
                leftIndex++;
            }

            if (sum == m) {
                count++;
            }
        }

        return count;
    }
}
