package hyperconnect;

public class Solution2 {
    public boolean canMakeSubsequence(String s1, String s2) {
        int indexS2 = 0;
        for (int i = 0; i < s1.length() && indexS2 < s2.length(); i++) {
            char currentChar = s1.charAt(i);
            char targetChar = s2.charAt(indexS2);

            if (currentChar == targetChar) {
                indexS2++;
                continue;
            }

            currentChar = (currentChar == 'z') ? 'a' : (char) (currentChar + 1);
            if (currentChar == targetChar) {
                indexS2++;
            }
        }
        return indexS2 == s2.length();
    }

    public static void main(String[] args) {
        Solution2 jci = new Solution2();
        System.out.println(jci.canMakeSubsequence("abc", "ad")); // true 출력
        System.out.println(jci.canMakeSubsequence("zc", "ad"));  // true 출력
    }
}
