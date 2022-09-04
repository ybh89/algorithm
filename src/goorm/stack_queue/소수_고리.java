package goorm.stack_queue;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class 소수_고리 {
    private static int n;
    private static Set<Integer> visited = new HashSet<>();
    private static Set<Integer> primeNumbers = new HashSet<>(Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31));

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = Integer.parseInt(scanner.nextLine());
        permutation(n - 1, new StringBuilder());
    }

    private static void permutation(int length, StringBuilder result) {
        if (length == 0) {
            String sResult = "1 " + result.toString().strip();
            if (primeNumbers.contains(1 + Integer.parseInt(sResult.substring(sResult.length() - 1)))) {
                System.out.println(sResult);
            }
            return;
        }

        for (int i = 2; i <= n; i++) {
            if (!visited.contains(i)) {
                visited.add(i);
                if (result.length() > 0) {
                    int pre = Integer.parseInt((result.substring(result.length() - 2, result.length()).strip()));
                    if (!primeNumbers.contains(pre + i)) {
                        visited.remove(i);
                        continue;
                    }
                }

                result.append(i + " ");
                permutation(length - 1, result);
                int len = String.valueOf(i).length() + 1;
                result.delete(result.length() - len, result.length());
                visited.remove(i);
            }
        }
    }
}
