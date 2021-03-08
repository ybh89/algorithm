package backTracking;

import java.util.*;

/**
 * 백준 9663
 */
public class N_Queen {
    private static int M = -1;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        M = N;
        sc.close();
        //nqeen(N);
        nqeen2(N,new ArrayList<>());
        System.out.println(count);
    }

    private static Set<Integer> columnSet = new HashSet<>();
    private static Set<Integer> plusSet = new HashSet<>();
    private static Set<Integer> minusSet = new HashSet<>();
    private static int count = 0;
    private static void nqeen(int N) {
        //종료
        if(N == 0) {
            count++;
            return;
        }

        //프로세스
        for(int i=1; i<=M; i++) {
            int plus = i + N;
            int minus = i - N;
            if(!columnSet.contains(i) && !plusSet.contains(plus) && !minusSet.contains(minus)) {
                minusSet.add(minus);
                plusSet.add(plus);
                columnSet.add(i);
                nqeen(N-1);
                columnSet.remove(i);
                plusSet.remove(plus);
                minusSet.remove(minus);
            }
        }
    }

    private static void nqeen2(int N, List<Integer> prefix) {
        //종료
        if(N == 0) {
            count++;
            //System.out.println(prefix);
            return;
        }

        //프로세스
        for(int i=1; i<=M; i++) {
            int plus = i + N;
            int minus = i - N;
            //대각선 검사
            boolean isAble = true;
            int row = M;
            for(int j=0; j<prefix.size(); j++) {
                int col = prefix.get(j);
                if(plus == row+col || minus == col-row || col == i) {
                    isAble = false;
                    break;
                }
                row--;
            }

            if(isAble) {
                prefix.add(i);
                nqeen2(N-1, prefix);
                prefix.remove(prefix.size()-1);
            }
        }
    }
}
