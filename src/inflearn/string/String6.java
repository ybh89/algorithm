package inflearn.string;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class String6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        System.out.println(solution(text));
    }

    private static String solution(String text) {
        char[] chars = text.toCharArray();
        StringBuilder result = new StringBuilder();
        Set<Character> set = new HashSet<>();
        for (char aChar : chars) {
            if (!set.contains(aChar)) {
                set.add(aChar);
                result.append(aChar);
            }
        }

        return result.toString();
    }
}
