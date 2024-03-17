package greedy;

import java.util.Scanner;

public class BJ11047동전0 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] inputs = scanner.nextLine().split(" ");
        int n = Integer.parseInt(inputs[0]);
        int k = Integer.parseInt(inputs[1]);
        int[] coinTypes = new int[n];
        for (int i = coinTypes.length - 1; i >= 0; i--) {
            coinTypes[i] = Integer.parseInt(scanner.nextLine());
        }

        int count = 0;
        int operand = k;
        for (int coinType : coinTypes) {
            if (coinType > operand) {
                continue;
            }

            int quotient = operand / coinType;
            int remainder = operand % coinType;

            count += quotient;
            operand = remainder;
        }

        System.out.println(count);
    }
}
