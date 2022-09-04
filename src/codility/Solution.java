package codility;

import java.util.ArrayList;
import java.util.List;

class Solution {
    private int count = 0;
    private int[] A;
    private boolean[] visited;
    public int solution(int[] A) {
        this.A = A;
        visited = new boolean[A.length];
        combination(0, new ArrayList<>(), 0);
        return this.count;
    }

    private void combination(int number, List<Integer> result, int start) {
        if (number == 2) {
            this.count++;
            return;
        }

        for (int i = start; i < A.length; i++) {
            if ((result.size() == 0 && A[i] == 0) || (result.size() == 1 && A[i] == 1)) {
                visited[i] = true;
                result.add(Integer.valueOf(i));
                combination(number + 1, result, i + 1);
                result.remove(Integer.valueOf(i));
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[]{0, 1, 0, 1, 1}));
    }
}
