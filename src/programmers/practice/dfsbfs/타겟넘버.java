package programmers.practice.dfsbfs;

public class 타겟넘버 {
    private int target;
    private int count = 0;
    private int[] numbers;

    public int solution(int[] numbers, int target) {
        this.numbers = numbers;
        this.target = target;
        permutation(numbers.length, new StringBuilder());
        return count;
    }

    private void permutation(int count, StringBuilder result) {
        if (count == 0) {
            int sum = calculate(result);
            if (sum == target) {
                this.count++;
            }
            return;
        }

        for (int i = 0; i < 2; i++) {
            if (i == 0) {
                result.append("+");
            } else {
                result.append("-");
            }
            permutation(count - 1, result);
            result.delete(result.length() - 1, result.length());
        }
    }

    private int calculate(StringBuilder result) {
        int sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (result.charAt(i) == '+') {
                sum += numbers[i];
            } else {
                sum -= numbers[i];
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        타겟넘버 sol = new 타겟넘버();
        int[] numbers = new int[]{1,1,1,1,1};
        int target = 3;
        System.out.println(sol.solution(numbers, target));
    }
}
