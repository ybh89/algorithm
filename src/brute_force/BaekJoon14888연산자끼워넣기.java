package brute_force;

import java.util.*;

public class BaekJoon14888연산자끼워넣기 {
    private static final char[] OPERATOR = new char[]{'+', '-', 'x', '/'};
    private static Map<Character, Integer> visited = new HashMap<>();
    private static int[] numberOfOperators;
    private static int totalOperators;
    private static int[] numbers;
    private static int max = Integer.MIN_VALUE;
    private static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        numberOfOperators = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for (int i = 0; i < numberOfOperators.length; i++) {
            visited.put(OPERATOR[i], numberOfOperators[i]);
            totalOperators += numberOfOperators[i];
        }
        solve(new ArrayList<>());
        System.out.println(max);
        System.out.println(min);
    }

    public static void solve(List<Character> combination) {
        if (combination.size() == totalOperators) {
            int first = numbers[0];
            for (int i = 0; i < combination.size(); i++) {
                int second = numbers[i + 1];
                char operator = combination.get(i);

                switch (operator) {
                    case '+' : first = first + second; break;
                    case '-' : first = first - second; break;
                    case 'x' : first = first * second; break;
                    case '/' : first = first / second; break;
                }
            }

            if (first > max) max = first;
            if (first < min) min = first;
            return;
        }

        for (char operator : OPERATOR) {
            Integer num = visited.get(operator);
            if (num > 0) {
                visited.computeIfPresent(operator, (character, integer) -> {
                    integer--;
                    return integer;
                });
                combination.add(operator);
                solve(combination);
                combination.remove(Character.valueOf(operator));
                visited.computeIfPresent(operator, (character, integer) -> {
                    integer++;
                    return integer;
                });
            }
        }
    }
}
