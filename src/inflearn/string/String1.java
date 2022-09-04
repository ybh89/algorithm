package inflearn.string;

import java.util.Scanner;

public class String1 {
    public static class Main {
        public static void main(String[] args){
            Scanner scanner = new Scanner(System.in);
            String totalText = scanner.nextLine();
            String character = scanner.nextLine();

            System.out.println(solution(totalText, character));
        }

        public static int solution(String totalText, String character) {
            final char findChar = character.toLowerCase().charAt(0);
            final String totalTextLowerCase = totalText.toLowerCase();
            int count = 0;

            for(int i = 0; i < totalTextLowerCase.length(); i++) {
                char currentChar = totalTextLowerCase.charAt(i);
                if (currentChar == findChar) {
                    count++;
                }
            }

            return count;
        }
    }


}
