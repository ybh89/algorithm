package coddingtest.delivery_hero;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Solution1 {
    public int solution(String S) {
        WordMachine wordMachine = new WordMachine();
        return wordMachine.calculate(S);
    }

    class WordMachine {
        private static final String OPERATION_SEPARATOR = " ";

        private Deque<Integer> stack = new ArrayDeque<>();

        public int calculate(String operations) {
            String[] operationArray = operations.split(OPERATION_SEPARATOR);
            try {
                Arrays.stream(operationArray).forEach(this::operate);
            } catch (IllegalStateException exception) {
                return -1;
            }

            return stack.isEmpty() ? -1 : stack.peek();
        }

        private void operate(String value) {
            if (value.chars().allMatch(Character::isDigit)) {
                push(Integer.valueOf(value));
                return;
            }
            if (Operations.POP.equals(value)) {
                pop();
                return;
            }
            if (Operations.DUP.equals(value)) {
                dup();
                return;
            }
            if (Operations.PLUS.equals(value)) {
                plus();
                return;
            }
            if (Operations.MINUS.equals(value)) {
                minus();
                return;
            }
        }

        private void push(Integer value) {
            stack.push(value);
        }

        private Integer pop() {
            validateStackSize(1);
            return stack.pop();
        }

        private void dup() {
            validateStackSize(1);
            stack.push(stack.peek());
        }

        private void plus() {
            validateStackSize(2);
            stack.push(stack.pop() + stack.pop());
        }

        private void minus() {
            validateStackSize(2);
            int result = stack.pop() - stack.pop();
            if (result < 0) {
                throw new IllegalStateException();
            }
            stack.push(result);
        }

        private void validateStackSize(int value) {
            if (stack.size() < value) {
                throw new IllegalStateException();
            }
        }
    }

    class Operations {
        public static final String POP = "POP";
        public static final String DUP = "DUP";
        public static final String PLUS = "+";
        public static final String MINUS = "-";
    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        System.out.println(solution1.solution("2 3 + -"));
    }
}
