package coddingtest.programmers;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution1 {
    public String solution(String[] registered_list, String new_id) {
        Set<String> ids = new HashSet<>(Arrays.asList(registered_list));
        return recommend(ids, new_id);
    }

    private String recommend(Set<String> ids, String new_id) {
        String recommendId = new_id;
        int splitIndex = findSplitIndex(recommendId);

        while (ids.contains(recommendId)) {
            String S = recommendId.substring(0, splitIndex);
            String N = recommendId.substring(splitIndex);
            Integer n = 0;
            if (!N.isEmpty()) {
                n = Integer.valueOf(N);
            }
            String N1 = String.valueOf(n + 1);
            recommendId = S + N1;
        }
        return recommendId;
    }

    private int findSplitIndex(String recommendId) {
        for (int i = 3; i < recommendId.length(); i++) {
            if ('0' <= recommendId.charAt(i) && recommendId.charAt(i) <= '9') {
                return i;
            }
        }

        return recommendId.length();
    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        String[] registered_list = new String[]{"cow", "cow1", "cow2", "cow3", "cow4", "cow9", "cow8", "cow7", "cow6", "cow5"};
        String new_id = "cow";
        System.out.println(solution1.solution(registered_list, new_id));
    }
}
