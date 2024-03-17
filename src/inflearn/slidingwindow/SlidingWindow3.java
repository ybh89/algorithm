package inflearn.slidingwindow;

import java.util.Scanner;

public class SlidingWindow3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] NK = scanner.nextLine().split(" ");
        int k = Integer.parseInt(NK[1]);
        String[] input = scanner.nextLine().split(" ");

        int max = solution(k, input);
        System.out.println(max);
    }

    private static int solution(int k, String[] input) {
        int leftIndex = 0;
        int rightIndex = 0;
        int changeCount = 0;
        int maxLength = 0;

        while (true) {
            if (rightIndex == input.length - 1) {
                break;
            }

            if ("0".equals(input[rightIndex])) {
                changeCount++;
            }

            if (changeCount > k) {
                while (true) {
                    if ("0".equals(input[leftIndex++])) {
                        changeCount--;
                        break;
                    }
                }
            }

            if (changeCount == k) {
                int length = rightIndex - leftIndex + 1;
                if (maxLength < length) {
                    maxLength = length;
                }
            }
            rightIndex++;
        }

        return maxLength;
    }
}
