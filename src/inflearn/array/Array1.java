package inflearn.array;

import java.util.Scanner;

public class Array1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        String[] numbers = scanner.nextLine().split(" ");
        System.out.println(solution(numbers));
    }

    private static String solution(String[] numbers) {
        StringBuilder result = new StringBuilder();
        result.append(numbers[0] + " ");

        for (int i = 1; i < numbers.length; i++) {
            int preNumber = Integer.parseInt(numbers[i - 1]);
            int currentNumber = Integer.parseInt(numbers[i]);
            if (currentNumber > preNumber) {
                result.append(currentNumber + " ");
            }
        }
        return result.toString().trim();
    }
}
