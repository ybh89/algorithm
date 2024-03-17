package inflearn.twopointers;

import java.util.Scanner;

public class TwoPointers3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int count = solution(n);
        System.out.println(count);
    }

    private static int solution(int n) {
        int leftNumber = 1;
        int rightNumber = 1;
        int sum = rightNumber;
        int count = 0;

        while (true) {
            if (sum < n) {
                rightNumber++;
                sum += rightNumber;
            }
            else {
                sum -= leftNumber;
                leftNumber++;
            }

            if (sum == n) {
                count++;
            }

            if (rightNumber == n || leftNumber == rightNumber) {
                break;
            }
        }

        return count;
    }
}
