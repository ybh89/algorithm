package backTracking;

import java.util.Scanner;

/**
 * 12101
 */
public class 일이삼더하기2 {
    private static int k;
    private static int count;
    private static String result = null;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        int targetNumber = Integer.parseInt(input[0]);
        k = Integer.parseInt(input[1]);
        backtracking(targetNumber, 0, new StringBuilder());
        if (result == null) {
            System.out.println(-1);
        } else {
            System.out.println(result);
        }
    }

    private static void backtracking(int targetNumber, int sum, StringBuilder mathExpression) {
        if (sum == targetNumber) {
            count++;
            if (count == k) {
                result = mathExpression.substring(0, mathExpression.length() - 1);
            }
        } else if (sum > targetNumber) {
            return;
        }

        for (int i = 1; i <= 3; i++) {
            mathExpression.append(i+"+");
            backtracking(targetNumber, sum + i, mathExpression);
            mathExpression.delete(mathExpression.length() - 2, mathExpression.length());
        }
    }
}
