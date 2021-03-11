package permutation;

import java.util.Scanner;

/**
 * 백준 15651
 * 순열 - 중복 허용
 */
public class N과_M_3 {
    private static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] inputs = sc.nextLine().split(" ");
        N = Integer.parseInt(inputs[0]);
        int M = Integer.parseInt(inputs[1]);
        //printPermutation(M, new StringBuilder());
        printPermutation2(M, "");
        System.out.println(sb);
    }

    /**
     *
     * @param M : 자릿수
     */
    // 시간 초과 버전
    private static void printPermutation(int M, StringBuilder prefix) {
        if(M == 0) {
            System.out.println(prefix.toString().trim());
            return;
        }

        for(int i=1; i<=N; i++) {
            prefix.append(i + " ");
            printPermutation(M-1, prefix);
            prefix.delete(prefix.length()-2, prefix.length());
        }
    }

    private static StringBuilder sb = new StringBuilder();
    private static void printPermutation2(int M, String str) {
        if(M == 0) {
            sb.append(str.trim() + "\n");
            return;
        }

        for(int i=1; i<=N; i++) {
            printPermutation2(M-1, str + " " + i);
        }
    }
}
