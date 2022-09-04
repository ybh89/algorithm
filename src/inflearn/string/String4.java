package inflearn.string;

import java.util.Scanner;

public class String4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfWords = Integer.parseInt(scanner.nextLine());
        String[] words = new String[numberOfWords];
        for (int i = 0; i < numberOfWords; i++) {
            words[i] = scanner.nextLine();
        }
        String[] reverseWords = solution(words);
        for (String reverseWord : reverseWords) {
            System.out.println(reverseWord);
        }
    }

    private static String[] solution(String[] words) {
        String[] reverseWords = new String[words.length];

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            StringBuilder reverseWord = new StringBuilder();
            for (int j = word.length() - 1; j >= 0; j--) {
                reverseWord.append(word.charAt(j));
            }
            reverseWords[i] = reverseWord.toString();
        }

        return reverseWords;
    }
}
