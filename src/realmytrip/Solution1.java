package realmytrip;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numberOfCases = Integer.parseInt(br.readLine());

        boolean[] results = new boolean[numberOfCases];
        for (int i = 0; i < numberOfCases; i++) {
            String id = br.readLine();
            String password = br.readLine();
            String checkPassword = br.readLine();

            if (!isValidId(id) || !isValidPassword(password, checkPassword)) {
                results[i] = false;
                continue;
            }

            results[i] = true;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < results.length; i++) {
            boolean result = results[i];
            if (result) {
                sb.append("pass\n");
                continue;
            }
            sb.append("fail\n");
        }

        System.out.println(sb);
    }

    private static boolean isValidPassword(String password, String checkPassword) {
        if (!password.equals(checkPassword)) {
            return false;
        }

        if (password.length() < 8 || password.length() > 20) {
            return false;
        }

        boolean isUsedLetter = false;
        boolean isUsedDigit = false;
        boolean isUsedSpecialChar = false;
        for (int i = 0; i < password.length(); i++) {
            char character = password.charAt(i);
            boolean digit = Character.isDigit(character);
            if (digit) {
                if (!isUsedDigit) {
                    isUsedDigit = true;
                }
                continue;
            }

            boolean lowerCase = Character.isLowerCase(character);
            boolean upperCase = Character.isUpperCase(character);
            if (lowerCase || upperCase) {
                if (!isUsedLetter) {
                    isUsedLetter = true;
                }
                continue;
            }

            boolean specialChar = isSpecialChar(character);
            if (specialChar) {
                if (!isUsedSpecialChar) {
                    isUsedSpecialChar = true;
                }
                continue;
            }

            return false;
        }

        if (!isUsedDigit || !isUsedLetter || !isUsedSpecialChar) {
            return false;
        }

        return true;
    }

    private static boolean isSpecialChar(char character) {
        if (character == '!' || character == '@' || character == '#' || character == '$') {
            return true;
        }
        return false;
    }

    private static boolean isValidId(String id) {
        if (id.length() < 3 || id.length() > 20) {
            return false;
        }

        for (int i = 0; i < id.length(); i++) {
            char character = id.charAt(i);
            if (Character.isDigit(character) || Character.isLowerCase(character)) {
                continue;
            }
            return false;
        }

        return true;
    }
}
