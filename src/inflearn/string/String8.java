package inflearn.string;

import java.util.Scanner;

public class String8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        String solution = solution(text);
        System.out.println(solution);
    }

    private static String solution(String text) {
        char[] chars = text.toLowerCase().toCharArray();
        StringBuilder alphabet = new StringBuilder();

        for (char aChar : chars) {
            if (isAlphabet(aChar)) {
                alphabet.append(aChar);
            }
        }

        String s = alphabet.toString();
        if (alphabet.reverse().toString().equals(s)) {
            return "YES";
        }

        return "NO";
    }

    private static boolean isAlphabet(char character) {
        return 'a' <= character && character <= 'z' || 'A' <= character && character <= 'Z';
    }
}
