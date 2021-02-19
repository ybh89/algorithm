package dataStructure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class StackTest {
    public static void main(String[] args) {
        /*Stack<String> stack = new Stack<>();
        stack.push("a");
        stack.push("b");
        stack.push("c");
        stack.push("d");

        reverse(stack);

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }*/

        System.out.println(isRightBracket("{1+2"));
    }

    /**
     * 스택을 뒤집어라
     * 단, 다른 스택을 사용하지말고 재귀적인 방법을 이용해라
     */
    public static void reverse(Stack<String> stack) {
        if(stack.isEmpty()) {
            return;
        }

        String data = stack.pop();
        reverse(stack);
        insertAtBottom(stack, data);
    }

    public static void insertAtBottom(Stack<String> stack, String data) {
        if(stack.isEmpty()) {
            stack.push(data);
            return;
        }

        String temp = stack.pop();
        insertAtBottom(stack, data);
        stack.push(temp);
    }

    /**
     * 괄호 검사기
     */
    public static boolean isRightBracket(String mathExp) {
        Stack<String> stack = new Stack<>();
        List<String> openBracket = new ArrayList<>(Arrays.asList("(", "{", "["));
        List<String> closeBracket = new ArrayList<>(Arrays.asList(")", "}", "]"));

        for(int i=0; i<mathExp.length(); i++) {
            String curChar = String.valueOf(mathExp.charAt(i));
            if(openBracket.contains(curChar)) {
                stack.push(curChar);
            } else if(closeBracket.contains(curChar)) {
                String open = stack.pop();
                if(open == null || (openBracket.indexOf(open) != closeBracket.indexOf(curChar))) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
