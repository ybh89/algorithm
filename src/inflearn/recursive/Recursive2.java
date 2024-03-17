package inflearn.recursive;

import java.util.Scanner;

public class Recursive2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());
        solution(number);
    }

    private static void solution(int number) {
        if (number == 0)
        {
            return;
        }

        int mod = number % 2;
        int mock = number / 2;

        solution(mock);
        System.out.print(mod);
    }

    private static void solution2(int number) {
        StringBuilder result = new StringBuilder();
        int n = number;

        while (n > 0)
        {
            result.insert(0, n % 2);
            n = n / 2;
        }

        System.out.println(result);
    }
}
