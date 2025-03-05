package new2025.programers;

import java.util.Stack;

public class 괄호회전하기76502 {
    public static void main(String[] args) {
        괄호회전하기76502 sol = new 괄호회전하기76502();
        System.out.println(sol.solution("("));
    }

    public int solution(String s) {
        int count = 0;
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < sb.length(); i++) {
            if (valid(sb.toString())) {
                count++;
            }

            char first = sb.charAt(0);
            sb.deleteCharAt(0);
            sb.append(first);
        }

        return count;
    }

    public boolean valid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
                continue;
            }

            if (stack.isEmpty()) {
                return false;
            }
            Character pop = stack.pop();
            if (c == ')' && pop != '(') {
                return false;
            }

            if (c == ']' && pop != '[') {
                return false;
            }

            if (c == '}' && pop != '{') {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
