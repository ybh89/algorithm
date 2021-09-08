package programmers.practice.sort;

import java.util.Arrays;
import java.util.stream.Collectors;

public class 가장큰수 {
    public String solution(int[] numbers) {
        String sortedNumbers = Arrays.stream(numbers).mapToObj(String::valueOf)
                .sorted((s1, s2) -> (s2+s1).compareTo(s1+s2))
                .collect(Collectors.joining());
        return sortedNumbers;
    }

    public static void main(String[] args) {
        가장큰수 solution = new 가장큰수();
        int[] numbers = new int[]{3, 30, 34, 5, 9};
        System.out.println(solution.solution(numbers));
    }
}
