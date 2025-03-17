package new2025.basic.dfs;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class DFS {
    public static void main(String[] args) {
        DFS dfs = new DFS();
        //dfs.dfsPermutation(0, 5, 3, new Stack<>(), new HashSet<>());
        dfs.dfsCombination(0, 5, 3, 1, new Stack<>());
    }

    /**
     * n 개 중에 r 개를 선택하는 중복없는 순열 출력
     */
    public void dfsPermutation(int depth, int n, int r, Stack<Integer> result, Set<Integer> visitedSet) {
        if (depth == r) { // depth 가 r 개가 되면 출력.
            System.out.println(result);
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (visitedSet.contains(i)) {
                continue;
            }

            visitedSet.add(i);
            result.push(i);
            dfsPermutation(depth+1, n, r, result, visitedSet);
            result.pop();
            visitedSet.remove(i);
        }
    }

    /**
     * n 개 중에 r 개를 선택하는 중복없는 조합 출력
     */
    public void dfsCombination(int depth, int n, int r, int start, Stack<Integer> result) {
        if (depth == r) { // depth 가 r 개가 되면 출력.
            System.out.println(result);
            return;
        }

        for (int i = start; i <= n; i++) {
            result.push(i);
            dfsCombination(depth+1, n, r, i+1, result);
            result.pop();
        }
    }


}
