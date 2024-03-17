package inflearn.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Array4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());
        System.out.println(solution(number));
    }

    private static String solution(int number) {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 1, 2));
        StringBuilder result = new StringBuilder("1 1 2 ");

        for (int i = 3; i < number; i++) {
            int add = numbers.get(i - 2) + numbers.get(i - 1);
            numbers.add(add);
            result.append(add + " ");
        }
        return result.toString().trim();
    }
}
