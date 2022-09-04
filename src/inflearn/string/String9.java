package inflearn.string;

import java.util.Scanner;

public class String9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        System.out.println(solution(text));
    }

    private static int solution(String text) {
        char[] chars = text.toCharArray();
        StringBuilder sb = new StringBuilder();

        for (char aChar : chars) {
            if (isNumber(aChar)) {
                sb.append(aChar);
            }
        }

        return Integer.parseInt(sb.toString());
    }

    private static boolean isNumber(char aChar) {
        if ('0' <= aChar && aChar <= '9') {
            return true;
        }
        return false;
    }
}
