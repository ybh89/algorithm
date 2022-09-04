package goorm;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class HappyNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = Integer.parseInt(sc.nextLine());
        Set<Integer> results = new HashSet<>();
        int result = number;
        results.add(result);

        while (true) {
            result = calculate(result);
            if (result == 1) {
                System.out.println(number + " is Happy Number.");
                return;
            }

            if (results.contains(result)) {
                System.out.println(number + " is Unhappy Number.");
                return;
            }

            results.add(result);
        }
    }

    private static int calculate(int number) {
        String[] sNumbers = String.valueOf(number).split("");
        int result = 0;

        for (int i = 0; i < sNumbers.length; i++) {
            if ("0".equals(sNumbers[i])) {
                continue;
            }
            result += Math.pow(Integer.parseInt(sNumbers[i]), 2);
        }

        return result;
    }
}
