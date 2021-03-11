package permutation;

import java.util.Scanner;

/**
 * 백준 15650
 * 순열 - 중복 제거, 오름차순만
 */
public class N과_M_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] inputs = sc.nextLine().split(" ");
        N = Integer.parseInt(inputs[0]);
        int M = Integer.parseInt(inputs[1]);
        isUsed = new boolean[N+1];
        printPermutation(M, new StringBuilder(), 1);
    }

    /**
     *
     * @param N : 범위
     * @param M : 자릿수
     */
    private static int N;
    private static boolean[] isUsed;
    private static void printPermutation(int M, StringBuilder prefix, int start) {
        //종료
        if(M == 0) {
            System.out.println(prefix.toString().trim());
            return;
        }

        //프로세스
        for(int i=start; i<=N; i++) {
            prefix.append(i+" ");
            printPermutation(M-1, prefix, i+1);
            prefix.delete(prefix.length()-2, prefix.length());
        }
    }
}
