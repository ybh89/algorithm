package permutation;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 백준 15657
 * 순열
 */
public class N과_M_8 {
    private static int N;
    private static StringBuilder sb = new StringBuilder();
    private static int[] array;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] inputs = sc.nextLine().split(" ");
        N = Integer.parseInt(inputs[0]);
        int M = Integer.parseInt(inputs[1]);
        array = new int[N+1];
        String[] nums = sc.nextLine().split(" ");
        for(int i=1; i<=N; i++) {
            array[i] = Integer.parseInt(nums[i-1]);
        }
        Arrays.sort(array);
        printPermutation(M, "", 1);
        System.out.println(sb);
    }

    private static void printPermutation(int M, String str, int start) {
        if(M == 0) {
            sb.append(str.trim() + "\n");
            return;
        }

        for(int i=start; i<array.length; i++) {
            printPermutation(M - 1, str + " " + array[i], i);
        }
    }
}
