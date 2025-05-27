package new2025.programers.sort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class HIndex42747 {
    public static void main(String[] args) {
        HIndex42747 sol = new HIndex42747();
        System.out.println(sol.solution(new int[] {10000, 9999, 9998, 9997, 9996}));
    }

    public int solution(int[] citations) {
        Arrays.sort(citations);

        for (int i = 0; i < citations.length; i++) {
            int h = citations.length - i;
            if (citations[i] >= h) {
                return h;
            }
        }

        return 0;
    }
}
