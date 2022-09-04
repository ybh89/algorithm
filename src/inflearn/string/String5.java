package inflearn.string;

import java.util.Scanner;

public class String5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        System.out.println(solution(text));
    }

    private static String solution(String text) {
        int leftIndex = 0;
        int rightIndex = text.length() - 1;
        char[] chars = text.toCharArray();

        while (leftIndex < rightIndex) {
            char leftChar = chars[leftIndex];
            char rightChar = chars[rightIndex];

            if (isAlphabet(leftChar) && isAlphabet(rightChar)) {
                swap(chars, leftIndex, rightIndex);
                leftIndex++;
                rightIndex--;
                continue;
            }

            if (!isAlphabet(leftChar)) {
                leftIndex++;
                continue;
            }

            if (!isAlphabet(rightChar)) {
                rightIndex--;
                continue;
            }
        }

        return String.valueOf(chars);
    }

    private static void swap(char[] chars, int leftIndex, int rightIndex) {
        char temp = chars[leftIndex];
        chars[leftIndex] = chars[rightIndex];
        chars[rightIndex] = temp;
    }

    private static boolean isAlphabet(char character) {
        return 'a' <= character && character <= 'z' || 'A' <= character && character <= 'Z';
    }
}
