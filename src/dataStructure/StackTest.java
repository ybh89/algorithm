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

        //System.out.println(isRightBracket("{1+2"));
        //System.out.println(findIndexOfCloseBracket("()", 1));
        System.out.println(countReversibleBrackets("{{{{"));
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

    /**
     * 괄호 수식과 여는 괄호의 위치가 주어졌을 때 그에 대응하는 닫힌 괄호의 위치를 찾는 코드를 작성하라.
     */
    public static int findIndexOfCloseBracket(String mathExp, int openBracketIndex) {
        List<String> openBrackets = new ArrayList<>(Arrays.asList("(", "{", "["));
        List<String> closeBrackets = new ArrayList<>(Arrays.asList(")", "}", "]"));
        Stack<String> stack = new Stack<>();
        int onPushOpenBracketSize = -1;
        int indexOfCloseBracket = -1;

        if(!openBrackets.contains(String.valueOf(mathExp.charAt(openBracketIndex)))) {
            throw new IllegalArgumentException("해당 인덱스는 여는 괄호의 위치가 아닙니다.");
        }
        if(openBracketIndex < 0 || mathExp.length() <= openBracketIndex) {
            throw new IllegalArgumentException("인덱스는 수식길이내에 존재해야합니다.");
        }

        for(int i=0; i<mathExp.length(); i++) {
            String curChar = String.valueOf(mathExp.charAt(i));
            if(openBrackets.contains(curChar)) {
                stack.push(curChar);
                if(i == openBracketIndex) {
                    onPushOpenBracketSize = stack.size();
                }
            } else if(closeBrackets.contains(curChar)) {
                if(stack.size() == onPushOpenBracketSize) {
                    indexOfCloseBracket = i;
                    onPushOpenBracketSize = -1;
                }
                String open = stack.pop();
                if(open == null || (openBrackets.indexOf(open) != closeBrackets.indexOf(curChar))) {
                    throw new IllegalArgumentException("올바른 수식이 아닙니다.");
                }
            }
        }

        return indexOfCloseBracket;
    }

    /**
     * 괄호 몇개를 뒤집어야 정상적인 수식을 만들 수 있는지 계산하는 코드를 작성하라.
     * 예) {{{}} => exception
     *
     * 예) {{{{}} => 1
     *
     * 예) }}}}{}}} => 3
     *
     * 예) {{{{ => 2
     */
    public static int countReversibleBrackets(String mathExp) {
        List<String> openBrackets = new ArrayList<>(Arrays.asList("(", "{", "["));
        List<String> closeBrackets = new ArrayList<>(Arrays.asList(")", "}", "]"));
        int count = 0;

        for(int i=0; i<mathExp.length(); i++) {
            String curCh = String.valueOf(mathExp.charAt(i));

            if(openBrackets.contains(curCh)) {
                count++;
            } else if(closeBrackets.contains(curCh)) {
                count--;
            }
        }

        if(Math.abs(count)%2 == 1) {
            throw new IllegalArgumentException("수식의 괄호의 짝이 맞지 않습니다.");
        }

        return Math.abs(count)/2;
    }

    /**
     * 주어진 수식에 불필요한 괄호가 있지 않은지 확인하는 코드를 작성하라.
     *
     * 예) ((1 + 2)) + 3 => true (불필요한 괄호가 있다.)
     *
     * 예) 1 + (2 * 3) => false (산술적으로는 불필요하지만 이 문제에서는 이런 괄호는 유효하다고 가정한다.)
     *
     * 예) 1 + (2) * 3 => true (2를 감싸고 있는 괄호는 불필요하다.)
     */

}
