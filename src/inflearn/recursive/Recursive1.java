package inflearn.recursive;

import java.util.Scanner;

public class Recursive1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());
        solution(number);
    }

    private static void solution(int number) {
        if (number == 0) {
            return;
        }
        solution(number - 1);
        System.out.println(number);
    }
}
