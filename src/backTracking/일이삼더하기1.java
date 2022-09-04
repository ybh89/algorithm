package backTracking;

import java.util.Scanner;

/**
 * 9095
 */
public class 일이삼더하기1 {
    private static int count;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < T; i++) {
            int targetNumber = Integer.parseInt(sc.nextLine());
            count = 0;
            backtracking(targetNumber, 0);
            System.out.println(count);
        }
    }

    private static void backtracking(int targetNumber, int sum) {
        if (sum == targetNumber) {
            count++;
        } else if (sum > targetNumber) {
            return;
        }

        for (int i = 1; i <= 3; i++) {
            backtracking(targetNumber, sum + i);
        }
    }
}
