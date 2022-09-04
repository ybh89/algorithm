package inflearn.string;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class String10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        List<Integer> solution = solution(input[0], input[1]);
        StringBuilder stringBuilder = new StringBuilder();
        for (Integer integer : solution) {
            stringBuilder.append(integer + " ");
        }
        System.out.println(stringBuilder.toString().trim());
    }

    private static List<Integer> solution(String text, String t) {
        List<Integer> result = new ArrayList<>();

        char[] chars = text.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            String leftText = new StringBuilder(text.substring(0, i + 1)).reverse().toString();
            String rightText = text.substring(i);

            if (leftText.indexOf(t) == -1) {
                result.add(rightText.indexOf(t));
                continue;
            }
            if (rightText.indexOf(t) == -1) {
                result.add(leftText.indexOf(t));
                continue;
            }
            result.add(Math.min(leftText.indexOf(t), rightText.indexOf(t)));
        }
        return result;
    }
}
