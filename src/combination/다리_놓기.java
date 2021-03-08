package combination;

import java.util.Scanner;

/**
 * 백준 1010
 */
public class 다리_놓기 {
    private static int count = 0;
    private static int M = -1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = Integer.parseInt(sc.nextLine());
        int[] results = new int[tc];
        for (int t=0; t<tc; t++) {
            count = 0;
            String[] inputs = sc.nextLine().split(" ");
            int N = Integer.parseInt(inputs[0]);
            M = Integer.parseInt(inputs[1]);
            combinationRecursion(N, 1);
            results[t] = count;
        }

        for(int result : results) {
            System.out.println(result);
        }
    }

    /**
     *
     * @param N: 자리 개수
     * @apram start: 시작인덱스
     * @return
     */

    private static void combinationRecursion(int N, int start) {
        //종료
        if(N == 0) {
            count++;
            return;
        }

        //프로세스
        for(int i=start; i<=M; i++) {
            combinationRecursion(N-1, i+1);
        }
    }
}
