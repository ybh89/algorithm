package yogiyo;

public class Solution1 {
    public static void main(String[] args) {
        System.out.println(solution(200, 3));
    }

    public static String solution(int N, int K) {
        StringBuilder result = new StringBuilder();

        char[] chars = new char[K];
        for (int i = 0; i < chars.length; i++) {
            chars[i] = (char)('a' + i);
        }

        int count = N/2;
        for (int i = 0; i < count; i++) {
            char currentChar;
            if (i > chars.length - 1) {
                currentChar = chars[chars.length - 1];
            } else {
                currentChar = chars[i];
            }
            result.insert(0, currentChar);
            result.insert(result.length(), currentChar);
        }

        if (N%2 == 1) {
            int remainderLength = N - result.length();
            for (int i = 0; i < remainderLength; i++) {
                result.insert(result.length()/2, chars[chars.length - 1]);
            }
        }

        return result.toString();
    }
}
