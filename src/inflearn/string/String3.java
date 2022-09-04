package inflearn.string;

import java.util.Scanner;

public class String3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String totalText = scanner.nextLine();

        System.out.println(solution(totalText));
    }

    private static String solution(String totalText) {
        String[] words = totalText.split(" ");
        String maxLengthWord = words[0];

        for (String word : words) {
            if (maxLengthWord.length() < word.length()) {
                maxLengthWord = word;
            }
        }

        return maxLengthWord;
    }
}
