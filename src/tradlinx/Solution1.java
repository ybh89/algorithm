package tradlinx;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution1 {
    public long[] solution(String[] words) {
        long[] result = new long[words.length];
        Map<String, Long> firstSequenceMap = new HashMap<>();

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            firstSequenceMap.putIfAbsent(word, (long) (i + 1));
            result[i] = firstSequenceMap.get(word);
        }

        return result;
    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        // System.out.println(Arrays.toString(solution1.solution(new String[]{"one", "one", "two", "one"})));
        // System.out.println(Arrays.toString(solution1.solution(new String[]{"may", "with", "may", "you", "you"})));
        System.out.println(Arrays.toString(solution1.solution(new String[]{"may"})));
    }
}
