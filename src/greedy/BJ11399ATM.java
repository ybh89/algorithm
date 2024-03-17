package greedy;

import java.util.Arrays;
import java.util.Scanner;

public class BJ11399ATM {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[] times = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();

        int sum = 0;
        int preSum = 0;
        for (int time : times) {
            sum += preSum + time;
            preSum = preSum + time;
        }
        System.out.println(sum);
    }
}
