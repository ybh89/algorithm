package new2025.programers;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.Stack;

public class 피로도87946 {
    public static void main(String[] args) {
        피로도87946 sol = new 피로도87946();
        System.out.println(sol.solution(80, new int[][]{{80, 20}, {50, 40}, {30, 10}}));
        //System.out.println(sol.solution(78, new int[][]{{78, 18}, {70, 11}, {67, 9}, {60, 8}, {59, 2}, {57, 54}}));
    }

    public int solution(int k, int[][] dungeons) {
        dfs(0, k, new StringBuilder(), dungeons, new HashSet<>());
        return 0;
    }

    public void dfs(int index, int k, StringBuilder path, int[][] dungeons, Set<Integer> visitedSet) {
        if (k < dungeons[index][0]) {
            System.out.println(path);
            return;
        }

        if (visitedSet.contains(index)) {
            return;
        }

        int[] current = dungeons[index];
        k -= current[1];
        path.append(index);
        visitedSet.add(index);
        for (int i = 0; i < dungeons.length; i++) {
            if (!visitedSet.contains(i)) {
                dfs(i, k, path, dungeons, visitedSet);
            }
        }
        visitedSet.remove(index);
        path.deleteCharAt(path.length() - 1);
    }
}
