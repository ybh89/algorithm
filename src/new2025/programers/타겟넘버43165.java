package new2025.programers;


import java.util.Stack;

public class 타겟넘버43165 {
    private int count = 0;
    public static void main(String[] args) {
        타겟넘버43165 sol = new 타겟넘버43165();
        System.out.println(sol.solution3(new int[]{4, 1, 2, 1}, 4));
    }

    public int solution(int[] numbers, int target) {
        permutation(1, new StringBuilder(), numbers, target);
        return count;
    }

    public int solution2(int[] numbers, int target) {
        return dfs(numbers, target);
    }

    public int solution3(int[] numbers, int target) {
        return dfs2(0, -1, numbers, target);
    }

    public void permutation(int depth, StringBuilder result, int[] numbers, int target) {
        if (depth > numbers.length) {
            char[] charArray = result.toString().toCharArray();
            int sum = 0;
            for (int i = 0; i < numbers.length; i++) {
                if (charArray[i] == '+') {
                    sum += numbers[i];
                } else {
                    sum -= numbers[i];
                }
            }

            if (sum == target) {
                count++;
            }
            return;
        }

        for (int i = 0; i < 2; i++) {
            if (i == 0) {
                result.append("+");
            } else {
                result.append("-");
            }
            permutation(depth + 1, result, numbers, target);
            result.deleteCharAt(result.length() - 1);
        }
    }

    public int dfs2(int sum, int index, int[] numbers, int target) {
        if (index == numbers.length - 1) {
            if (sum == target) {
                return 1;
            }

            return 0;
        }

        return dfs2(sum - numbers[index + 1], index + 1, numbers, target) + dfs2(sum + numbers[index + 1], index + 1, numbers, target);
    }

    public int dfs(int[] numbers, int target) {
        int result = 0;
        Stack<Node> stack = new Stack<>();

        stack.push(new Node(-numbers[0], 0));
        stack.push(new Node(numbers[0], 0));

        while (!stack.isEmpty()) {
            Node current = stack.pop();
            if (current.getIndex() == numbers.length - 1) {
                if (current.getSum() == target) {
                    result++;
                }
                continue;
            }

            stack.push(new Node(current.getSum() - numbers[current.getIndex() + 1], current.getIndex() + 1));
            stack.push(new Node(current.getSum() + numbers[current.getIndex() + 1], current.getIndex() + 1));
        }

        return result;
    }

    static class Node {
        private int sum;
        private int index;

        public Node(int sum, int index) {
            this.sum = sum;
            this.index = index;
        }

        public int getSum() {
            return sum;
        }

        public int getIndex() {
            return index;
        }
    }
}
