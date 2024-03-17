package inflearn.recursive;

import java.util.Scanner;

public class Recursive3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());
        System.out.println(solution2(number));
    }

    private static int solution(int number) {
        if (number == 1) {
            return 1;
        }

        return number * solution(number - 1);
    }

    private static int solution2(int number) {
        int result = 1;

        for (int i = number; i >= 1; i--) {
            result = result * i;
        }

        return result;
    }
}
