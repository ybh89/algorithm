package inflearn.string;

import java.util.Scanner;

public class String2 {
    public static class Main {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            String totalText = scanner.nextLine();

            System.out.println(solution(totalText));
        }

        private static String solution(String totalText) {
            StringBuilder stringBuilder = new StringBuilder();

            for (int i = 0; i < totalText.length(); i++) {
                Character currentChar = totalText.charAt(i);

                if (Character.isLowerCase(currentChar)) {
                    stringBuilder.append(Character.toUpperCase(currentChar));
                } else {
                    stringBuilder.append(Character.toLowerCase(currentChar));
                }
            }
            return stringBuilder.toString();
        }
    }
}
