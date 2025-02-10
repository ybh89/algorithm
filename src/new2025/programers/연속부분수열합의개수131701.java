package new2025.programers;

import java.util.HashSet;
import java.util.Set;

public class 연속부분수열합의개수131701 {
    public static void main(String[] args) {
        연속부분수열합의개수131701 sol = new 연속부분수열합의개수131701();
        System.out.println(sol.solution(new int[]{7, 9, 1, 1, 4}));
    }

    public int solution(int[] elements) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < elements.length; i++) {
            int gijun = elements[i];
            set.add(gijun);
            int j = (i + 1) % elements.length;
            while (true) {
                int cal = elements[j];
                gijun += cal;
                set.add(gijun);
                if (j == (i + elements.length - 1) % elements.length) {
                    break;
                }
                if (j == elements.length - 1) {
                    j = 0;
                } else {
                    j++;
                }
            }
        }

        return set.size();
    }
}
