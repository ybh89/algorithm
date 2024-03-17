package inflearn.array;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Array3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        String[] aInput = scanner.nextLine().split(" ");
        List<Integer> a = Arrays.stream(aInput)
                .map(Integer::valueOf)
                .collect(Collectors.toList());
        String[] bInput = scanner.nextLine().split(" ");
        List<Integer> b = Arrays.stream(bInput)
                .map(Integer::valueOf)
                .collect(Collectors.toList());

        for (int i = 0; i < a.size(); i++) {
            System.out.println(solution(a.get(i), b.get(i)));
        }
    }

    private static String solution(Integer a, Integer b) {
        if (a.equals(b)) {
            return "D";
        }
        if (a.equals(1)) {
            if (b.equals(2)) {
                return "B";
            }
            return "A";
        }
        if (a.equals(2)) {
            if (b.equals(1)) {
                return "A";
            }
            return "B";
        }
        if (b.equals(1)) {
            return "B";
        }
        return "A";
    }
}
