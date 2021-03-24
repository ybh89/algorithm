package permutation;

import java.util.*;

/**
 * 백준 - 1328
 * 메모리 초과..
 */
public class 고층_빌딩 {
    private static int N;
    private static int L;
    private static int R;
    private static Set<Integer> isVisit = new HashSet<>();
    private static int count = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] inputs = sc.nextLine().split(" ");
        N = Integer.parseInt(inputs[0]);
        L = Integer.parseInt(inputs[1]);
        R = Integer.parseInt(inputs[2]);

        permutation(N, new ArrayList<>());
        System.out.println(count%1000000007);
    }

    private static void permutation(int depth, List<Integer> list) {
        //종료
        if(depth == 0 && isValid(list)) {
            count++;
            return;
        }

        //프로세스
        for(int i=1; i<=N; i++) {
            if(!isVisit.contains(i)) {
                isVisit.add(i);
                list.add(i);
                permutation(depth-1, list);
                list.remove(list.size()-1);
                isVisit.remove(i);
            }
        }
    }

    private static boolean isValid(List<Integer> list) {
        int leftIndex = 0;
        int rightIndex = list.size()-1;
        int maxValIndex = list.indexOf(N);
        int leftValue = 0;
        int rightValue = 0;
        int leftCount = 0;
        int rightCount = 0;

        while (leftIndex <= maxValIndex || rightIndex >= maxValIndex) {
            if(leftCount > L || rightCount > R) {
                return false;
            }

            if(leftValue < list.get(leftIndex)) {
                leftCount++;
                leftValue = list.get(leftIndex);
            }
            if(rightValue < list.get(rightIndex)) {
                rightCount++;
                rightValue = list.get(rightIndex);
            }

            if(leftIndex <= maxValIndex) {
                leftIndex++;
            }

            if(rightIndex >= maxValIndex) {
                rightIndex--;
            }
        }

        return leftCount == L && rightCount == R;
    }
}
