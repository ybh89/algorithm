package inflearn.string;

import java.util.Scanner;

public class String11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        System.out.println(solution(input));
    }

    private static String solution(String text) {
        char[] chars = text.toCharArray();
        char preChar = chars[0];
        StringBuilder result = new StringBuilder(String.valueOf(preChar));
        int count = 1;

        for (int i = 1; i < chars.length; i++) {
            char currentChar = chars[i];

            if (preChar == currentChar) {
                count++;
                if (i == chars.length - 1) {
                    appendCount(result, count);
                }
                continue;
            }

            appendCount(result, count);
            count = 1;
            result.append(currentChar);
            preChar = currentChar;
        }
        return result.toString();
    }

    private static void appendCount(StringBuilder result, int count) {
        if (count != 1) {
            result.append(count);
        }
    }
}
