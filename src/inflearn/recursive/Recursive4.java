package inflearn.recursive;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Recursive4 {
    private static Map<Integer, Integer> cash = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <= number; i++)
        {
            System.out.print(solution(i) + " ");
        }
    }

    private static int solution(int number) {
        if (cash.containsKey(number)) {
            return cash.get(number);
        }
        if (number == 1 || number == 2) {
            cash.put(number, 1);
            return 1;
        }
        int i = solution(number - 1) + solution(number - 2);
        cash.put(number, i);
        return i;
    }
}
