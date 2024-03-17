package inflearn.hash;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Hash4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String t = scanner.nextLine();
        System.out.println(solution(s, t));
    }

    private static int solution(String s, String t) {
        Map<Character, Integer> tCharMap = new HashMap<>();
        Map<Character, Integer> windowCharMap = new HashMap<>();
        int count = 0;

        for (int i = 0; i < t.length(); i++) {
            tCharMap.put(t.charAt(i), tCharMap.getOrDefault(t.charAt(i), 0) + 1);
            windowCharMap.put(s.charAt(i), windowCharMap.getOrDefault(s.charAt(i), 0) + 1);
        }

        if (tCharMap.equals(windowCharMap)) {
            count++;
        }

        int leftIndex = 0;
        int rightIndex = t.length() - 1;

        while (rightIndex < s.length() - 1) {
            rightIndex++;
            windowCharMap.put(s.charAt(rightIndex), windowCharMap.getOrDefault(s.charAt(rightIndex), 0) + 1);

            windowCharMap.computeIfPresent(s.charAt(leftIndex), (key, value) -> value - 1);
            if (windowCharMap.get(s.charAt(leftIndex)).equals(0)) {
                windowCharMap.remove(s.charAt(leftIndex));
            }
            leftIndex++;

            if (tCharMap.equals(windowCharMap)) {
                count++;
            }
        }

        return count;
    }
}
