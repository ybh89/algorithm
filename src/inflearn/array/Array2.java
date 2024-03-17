package inflearn.array;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Array2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        String[] input = scanner.nextLine().split(" ");
        List<Integer> numbers = Arrays.stream(input)
                .map(Integer::valueOf)
                .collect(Collectors.toList());
        System.out.println(solution(numbers));
    }

    private static int solution(List<Integer> numbers) {
        int count = 1;
        Integer maxHeight = numbers.get(0);

        for (int i = 1; i < numbers.size(); i++) {
           Integer currentHeight = numbers.get(i);
           if (currentHeight > maxHeight) {
               count++;
               maxHeight = currentHeight;
           }
        }

        return count;
    }
}
