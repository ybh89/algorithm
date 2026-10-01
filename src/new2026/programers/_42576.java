package new2026.programers;

import java.util.HashMap;
import java.util.Map;

public class _42576 {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>();
        for (String p : participant) {
            map.compute(p, (k, v) -> v == null ? 1 : v + 1);
        }
        for (String c : completion) {
            map.computeIfPresent(c, (k, v) -> {
                if (v == 1) return null;
                else return v - 1;
            });
        }
        return map.keySet().iterator().next();
    }

    static void main() {
        _42576 solution = new _42576();
        System.out.println(solution.solution(new String[]{"leo", "kiki", "eden"}, new String[]{"eden", "kiki"}));
        System.out.println(solution.solution(new String[]{"marina", "josipa", "nikola", "vinko", "filipa"}, new String[]{"josipa", "filipa", "marina", "nikola"}));
        System.out.println(solution.solution(new String[]{"mislav", "stanko", "mislav", "ana"}, new String[]{"stanko", "ana", "mislav"}));
    }
}
