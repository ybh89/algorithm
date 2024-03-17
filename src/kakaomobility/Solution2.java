package kakaomobility;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution2 {
    public static void main(String[] args) {
        System.out.println(solution(4, new int[]{}, new int[]{}));
    }

    public static boolean solution(int N, int[] A, int[] B) {
        List<Set<Integer>> lines = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            lines.add(new HashSet<>());
        }

        for (int i = 0; i < A.length; i++) {
            lines.get(A[i]).add(B[i]);
            lines.get(B[i]).add(A[i]);
        }

        for (int i = 1; i < N; i++) {
            if (!lines.get(i).contains(i + 1)) {
                return false;
            }
        }

        return true;
    }
}
