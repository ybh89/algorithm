package inflearn.twopointers;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class TwoPointers2 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        Set<String> data1 = new TreeSet<>(Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toSet()));
        scanner.nextLine();
        Set<String> data2 = new TreeSet<>(Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toSet()));

        solution(data1, data2);
    }

    public static void solution(Set<String> data1, Set<String> data2) {
        if (data1.size() > data2.size()) {
            extracted(data1, data2);
            return;
        }

        extracted(data2, data1);
    }

    private static void extracted(Set<String> data1, Set<String> data2) {
        StringBuilder result = new StringBuilder();
        for (String data : data2) {
            if (data1.contains(data)) {
                result.append(data + " ");
            }
        }
        System.out.print(result.toString().trim());
    }
}
