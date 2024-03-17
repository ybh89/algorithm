package binarysearch;

import java.util.*;
import java.util.stream.Collectors;

public class BaekJoon1920수찾기 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<Integer> a = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::valueOf).collect(Collectors.toList());
        int m = Integer.parseInt(scanner.nextLine());
        int[] b =  Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Set<Integer> set = new HashSet<>(a);

        for (int number : b) {
            if (set.contains(number)) {
                System.out.println("1");
            }
            else {
                System.out.println("0");
            }
        }
    }
}
