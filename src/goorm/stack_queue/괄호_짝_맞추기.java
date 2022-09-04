package goorm.stack_queue;

import java.util.*;

public class 괄호_짝_맞추기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String brackets = sc.nextLine();
        if (isRightFormatBracket(brackets)) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }

    private static boolean isRightFormatBracket(String brackets) {
        Stack<String> stack = new Stack<>();
        Set<String> openBrackets = new LinkedHashSet<>(Arrays.asList("(", "{", "["));
        Set<String> closeBrackets = new LinkedHashSet<>(Arrays.asList(")", "}", "]"));

        for (int i = 0; i < brackets.length(); i++) {
            String currentBracket = String.valueOf(brackets.charAt(i));

            if (openBrackets.contains(currentBracket)) {
                stack.push(currentBracket);
                continue;
            }

            String openBracket = stack.pop();
            if ((currentBracket.equals(")") && !openBracket.equals("(")) ||
                    (currentBracket.equals("}") && !openBracket.equals("{")) ||
                    (currentBracket.equals("]") && !openBracket.equals("["))) {
                return false;
            }
        }

        return true;
    }
}
