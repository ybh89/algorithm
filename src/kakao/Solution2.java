package kakao;

import java.io.IOException;
import java.util.Scanner;


class Result2 {

    /*
     * Complete the 'solution' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String solution(String s) {
        // Write your code here
        if (s.indexOf("0") == -1 || s.indexOf("1") == -1) {
            return s;
        }
        StringBuilder input = new StringBuilder(s);
        StringBuilder result = new StringBuilder();

        while (input.length() > 0) {
            if (input.indexOf("1") != -1) {
                result.insert(0, "1");
                input.deleteCharAt(input.indexOf("1"));
            }
            if (input.indexOf("0") != -1) {
                result.insert(0, "0");
                input.deleteCharAt(input.indexOf("0"));
            }
        }
        return result.toString();
    }

    public static String solution2(String s) {
        // Write your code here
        int numberOfOne = s.replaceAll("0", "").length();
        int numberOfZero = s.length() - numberOfOne;

        if (numberOfOne == 0 || numberOfZero == 0) {
            return s;
        }

        StringBuilder result = new StringBuilder();

        while (numberOfOne + numberOfZero > 0) {
            if (numberOfOne > 0) {
                result.append("1");
                numberOfOne--;
            }
            if (numberOfZero > 0) {
                result.append("0");
                numberOfZero--;
            }
        }
        return result.reverse().toString();
    }
}

public class Solution2 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();

        System.out.println(Result2.solution2(s));
    }
}
