package programmers.practice.exhaustivesearch;

import java.util.HashSet;
import java.util.Set;

public class 소수찾기 {
    private String numbers;
    private Set<Integer> results = new HashSet<>();
    private Set<Integer> visited = new HashSet<>();

    public int solution(String numbers) {
        this.numbers = numbers;
        for (int i = 1; i <= numbers.length(); i++) {
            permutation(i, new StringBuilder());
        }
        return results.size();
    }

    private void permutation(int selectNumber, StringBuilder result) {
        if (selectNumber == 0) {
            int number = Integer.parseInt(result.toString());
            if (isPrimeNumber(number)) {
                System.out.println(number);
                results.add(number);
            }
            return;
        }

        for (int i = 0; i < numbers.length(); i++) {
            if (!visited.contains(i)) {
                visited.add(i);
                result.append(numbers.charAt(i));
                permutation(selectNumber - 1, result);
                result.delete(result.length() - 1, result.length());
                visited.remove(i);
            }
        }
    }

    private boolean isPrimeNumber(int number) {
        if (number == 0 || number == 1) {
            return false;
        }

        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        소수찾기 sol = new 소수찾기();
        System.out.println(sol.solution("17"));
    }
}
