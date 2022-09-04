package inflearn.string;

import java.util.Scanner;

public class String7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        String solution = solution(text);
        System.out.println(solution);
    }

    private static String solution(String text) {
        text = text.toLowerCase();
        int left = 0;
        int right = text.length() - 1;

        while (left < right) {
            if (text.charAt(left) != text.charAt(right)) {
                return "NO";
            }
            left++;
            right--;
        }
        return "YES";
    }
}
