package ignite;

import java.util.HashSet;
import java.util.Set;

public class Solution2 {
    private int[] array;
    private Set<Integer> visited = new HashSet<>();

    public int solution(int[] A) {
        array = A;
        backtrack(0);

        return 0;
    }

    private void backtrack(int start) {
        if (start == array.length - 2) {
            return;
        }

        for (int i = start; i < array.length - 1; i += 2) {
            if (!visited.contains(i)) {
                visited.add(i);
                System.out.println(array[i] + ", " + array[i + 1]);
                backtrack(i);
                visited.remove(i);
            }

        }

    }


    public static void main(String[] args) {
        Solution2 sol = new Solution2();

        System.out.println(sol.solution(new int[]{2,4,1,3,4,6,2,4,1,6}));  // 3
        //System.out.println(sol.solution(new int[]{5,1,2,6,6,1,3,1,4,3,4,3,4,6,1,2,4,1,6,2}));  // 7
        //System.out.println(sol.solution(new int[]{1,5,3,3,1,3}));  // 2
        //System.out.println(sol.solution(new int[]{3,4}));  // 0
    }
}
