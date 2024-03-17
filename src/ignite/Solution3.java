package ignite;

import java.util.ArrayList;
import java.util.List;

public class Solution3 {
    public int solution(int[] A) {
        int numberOfDominoes = A.length / 2;
        List<Integer> dominoes = new ArrayList<>();
        for (int i = 0; i < numberOfDominoes; i++) {
            dominoes.add(i);
        }

        return numberOfDominoes - getMaxValidLength(A, dominoes, 0, new ArrayList<>());
    }

    private int getMaxValidLength(int[] A, List<Integer> dominoes, int currentDominoIndex, List<Integer> combination) {
        if (currentDominoIndex == dominoes.size()) {
            return isValid(A, combination) ? combination.size() : 0;
        }
        int notTaken = getMaxValidLength(A, dominoes, currentDominoIndex + 1, combination);

        combination.add(dominoes.get(currentDominoIndex));
        int taken = getMaxValidLength(A, dominoes, currentDominoIndex + 1, combination);
        combination.remove(combination.size() - 1);

        return Math.max(notTaken, taken);
    }

    private boolean isValid(int[] A, List<Integer> combination) {
        for (int i = 1; i < combination.size(); i++) {
            int prevDominoIndex = combination.get(i - 1);
            int currentDominoIndex = combination.get(i);
            if (A[prevDominoIndex * 2 + 1] != A[currentDominoIndex * 2]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution3 sol = new Solution3();

        System.out.println(sol.solution(new int[]{2,4,1,3,4,6,2,4,1,6}));  // 3
        System.out.println(sol.solution(new int[]{5,1,2,6,6,1,3,1,4,3,4,3,4,6,1,2,4,1,6,2}));  // 7
        System.out.println(sol.solution(new int[]{1,5,3,3,1,3}));  // 2
        System.out.println(sol.solution(new int[]{3,4}));  // 0
    }
}
