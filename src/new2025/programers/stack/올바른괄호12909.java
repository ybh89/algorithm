package new2025.programers.stack;

import java.util.Stack;

public class 올바른괄호12909 {
    public static void main(String[] args) {
        올바른괄호12909 sol = new 올바른괄호12909();
        System.out.println(sol.solution("()()"));
    }

    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(c);
                continue;
            }

            if (stack.isEmpty()) {
                return false;
            }

            Character pop = stack.pop();
            if (pop != '(') {
                return false;
            }
        }

        return stack.isEmpty();
    }
}
