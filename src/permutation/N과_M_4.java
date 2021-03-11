package permutation;

import java.util.Scanner;

/**
 * 백준 15652
 * 중복 허용, 비내림차순 순열 -> 오름차순 포함하여 중복 허용한 수열 예) (1, 1), (1, 2)
 */
public class N과_M_4 {
    private static int N;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] inputs = sc.nextLine().split(" ");
        N = Integer.parseInt(inputs[0]);
        int M = Integer.parseInt(inputs[1]);
        printPermutation(M, "", 1);
        System.out.println(sb);
    }

    private static void printPermutation(int M, String str, int start) {
        if(M == 0) {
            sb.append(str.trim() + "\n");
            return;
        }

        for(int i=start; i<=N; i++) {
            printPermutation(M-1, str + " " + i, i);
        }
    }
}
