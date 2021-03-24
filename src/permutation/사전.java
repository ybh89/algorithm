package permutation;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 백준 - 1256
 * 메모리 초과 -> DP로 풀어야할것 같음..
 */
public class 사전 {
    private static int N;
    private static int M;
    private static int K;
    private static Set<Integer> isVisit;
    private static Set<String> results;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] inputs = sc.nextLine().split(" ");
        N = Integer.parseInt(inputs[0]);
        M = Integer.parseInt(inputs[1]);
        K = Integer.parseInt(inputs[2]);
        results = new LinkedHashSet<>();
        isVisit = new HashSet<>();

        permutation(N+M, new StringBuilder());
        System.out.println(results.toArray()[K-1]);
    }

    private static void permutation(int depth, StringBuilder sb) {
        //종료
        if(depth == 0) {
            results.add(sb.toString());
            return;
        }

        //프로세스
        for(int i=0; i<N+M; i++) {
            if(!isVisit.contains(i)) {
                isVisit.add(i);

                String character;
                if(i<N) {
                    character = "a";
                } else {
                    character = "z";
                }

                sb.append(character);
                permutation(depth-1, sb);
                sb.deleteCharAt(sb.length()-1);
                isVisit.remove(i);
            }
        }
    }
}
