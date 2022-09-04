package coddingtest.bucketplace;

import java.util.HashSet;
import java.util.Set;

public class Solution2 {
    private String str;
    private Set<Integer> visited = new HashSet<>();
    private int max = Integer.MIN_VALUE;

    public int solution(String str) {
        this.str = str;
        permutation(3, new StringBuilder(), 0);
        return 0;
    }

    private void permutation(int depth, StringBuilder result, int start) {
        if (depth == 0) {
            if (result.toString().equals("oho"))
            System.out.println(result);
            return;
        }

        for (int i = start; i < str.length(); i++) {
            if (!visited.contains(i)) {
                visited.add(i);
                result.append(str.charAt(i));
                permutation(depth - 1, result, start + 1);
                result.delete(result.length() - 1, result.length());
                visited.remove(Integer.valueOf(i));
            }
        }
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        System.out.println(solution2.solution("oohhoooh"));
    }
}
