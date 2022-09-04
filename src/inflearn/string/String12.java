package inflearn.string;

import java.util.Scanner;

public class String12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());
        String text = scanner.nextLine();
        System.out.println(solution(text, number));
    }

    private static String solution(String text, int number) {
        String[] splitText = splitByNumber(text, number);
        StringBuilder result = new StringBuilder();
        for (String s : splitText) {
            result.append(decryption(s));
        }
        return result.toString();
    }

    private static char decryption(String s) {
        String numberString = decryptionNumberString(s);
        int decimal = decryptionDecimal(numberString);
        return (char) decimal;
    }

    private static int decryptionDecimal(String numberString) {
        return Integer.parseInt(numberString, 2);
    }

    private static String decryptionNumberString(String s) {
        char[] chars = s.toCharArray();
        StringBuilder result = new StringBuilder();
        for (char aChar : chars) {
            if (aChar == '#') {
                result.append("1");
                continue;
            }
            if (aChar == '*') {
                result.append("0");
            }
        }
        return result.toString();
    }

    private static String[] splitByNumber(String text, int number) {
        String[] splitText = new String[number];
        int beginIndex = 0;
        int endIndex = text.length() / number;
        int count = endIndex;
        for (int i = 0; i < number; i++) {
            splitText[i] = text.substring(beginIndex, endIndex);
            beginIndex = endIndex;
            endIndex = beginIndex + count;
        }
        return splitText;
    }
}
