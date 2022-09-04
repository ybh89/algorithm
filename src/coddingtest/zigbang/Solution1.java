package coddingtest.zigbang;

import java.util.Scanner;

public class Solution1 {
    private static final String[] ALPHABETS = new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
    private static final int ASCII_NUMBER = 97;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int key = Integer.parseInt(sc.nextLine().split(" ")[1]);
        String text = sc.nextLine();
        System.out.println(encrypt(text, key));
    }

    public static String encrypt(String text, int key) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            int currentAlphabetIndex = text.charAt(i) - ASCII_NUMBER;
            int moveCount = (int) Math.pow(key, i + 1);
            int encryptAlphabetIndex = (moveCount % ALPHABETS.length) + currentAlphabetIndex;
            if (encryptAlphabetIndex >= ALPHABETS.length) {
                encryptAlphabetIndex = encryptAlphabetIndex % ALPHABETS.length;
            }

            result.append(ALPHABETS[encryptAlphabetIndex]);
        }
        return result.toString();
    }
}
