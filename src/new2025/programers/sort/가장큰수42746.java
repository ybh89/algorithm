package new2025.programers.sort;

import java.util.Arrays;
import java.util.stream.Collectors;

public class 가장큰수42746 {
    public static void main(String[] args) {
        가장큰수42746 sol = new 가장큰수42746();
        System.out.println(sol.solution(new int[] {0, 0, 0}));
    }

    public String solution(int[] numbers) {
        String result = Arrays.stream(numbers)
                .mapToObj(String::valueOf)
                .sorted((o1, o2) -> (o2 + o1).compareTo(o1 + o2))
                .collect(Collectors.joining());

        if (result.startsWith("0")) {
            return "0";
        }

        return result;
    }
}
