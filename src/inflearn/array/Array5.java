package inflearn.array;

import java.util.List;
import java.util.Scanner;

public class Array5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());
        System.out.println(solution(number));

    }

    private static int solution(int number) {
        int count = 0;

        int[] array = new int[number + 1];

        for (int i = 2; i <= number; i++) {
            if (array[i] == 0) {
                count++;
            }
            for (int j = i; j <= number; j+=i) {
                array[j] = 1;
            }
        }

        return count;
    }
}
