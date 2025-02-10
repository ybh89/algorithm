package new2025.programers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 추억점수176963 {
    public static void main(String[] args) {
        추억점수176963 sol = new 추억점수176963();
        System.out.println(Arrays.toString(sol.solution(new String[]{"may", "kein", "kain", "radi"}, new int[]{5, 10, 1, 3}, new String[][]{{"may", "kein", "kain", "radi"}, {"may", "kein", "brin", "deny"}, {"kon", "kain", "may", "coni"}})));
    }

    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] result = new int[photo.length];
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < name.length; i++) {
            map.put(name[i], yearning[i]);
        }

        for (int i = 0; i < photo.length; i++) {
            int point = 0;
            for (String p : photo[i]) {
                point += map.getOrDefault(p, 0);
            }
            result[i] = point;
        }

        return result;
    }
}
