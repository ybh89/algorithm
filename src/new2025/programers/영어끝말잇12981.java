package new2025.programers;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class 영어끝말잇12981 {
    public static void main(String[] args) {
        영어끝말잇12981 sol = new 영어끝말잇12981();
        System.out.println(Arrays.toString(sol.solution(3, new String[]{"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"})));
    }

    public int[] solution(int n, String[] words) {
        Set<String> set = new HashSet<>();
        int[] answer = new int[2];
        int seq = 1;
        int cycle = 1;
        for (int i = 0; i < words.length; i++) {
            String word = words[i];

            if (i != 0) {
                char preWordLastChar = words[i - 1].charAt(words[i - 1].length() - 1);
                if (preWordLastChar != word.charAt(0)) {
                    answer[0] = seq;
                    answer[1] = cycle;
                    return answer;
                }
            }

            if (!set.add(word)) {
                answer[0] = seq;
                answer[1] = cycle;
                return answer;
            }

            seq++;
            if (seq > n) {
                cycle++;
                seq = 1;
            }
        }

        return new int[]{0,0};
    }
}
