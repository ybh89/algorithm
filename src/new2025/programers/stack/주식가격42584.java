package new2025.programers.stack;

import java.util.Arrays;
import java.util.Stack;

public class 주식가격42584 {
    public static void main(String[] args) {
        주식가격42584 sol = new 주식가격42584();
        System.out.println(Arrays.toString(sol.solution(new int[] {1, 2, 3, 2, 1})));
    }

    public int[] solution(int[] prices) {
        int[] result = new int[prices.length];
        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        for (int i = 1; i < prices.length; i++) {
            while (!stack.isEmpty() && prices[stack.peek()] > prices[i]) {
                int pop = stack.pop();
                result[pop] = i - pop;
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            int pop = stack.pop();
            result[pop] = prices.length - 1 - pop;
        }

        return result;
    }
}
