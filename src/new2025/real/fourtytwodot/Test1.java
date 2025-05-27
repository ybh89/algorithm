package new2025.real.fourtytwodot;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Test1 {
    public static void main(String[] args) {
        Test1 sol = new Test1();
    }

    public int[] solution(String[] approved, String[] spams, String[] calls, int k) {
        Set<String> approvedSet = new HashSet<>(Arrays.asList(approved));
        Set<String> spamSet = new HashSet<>(Arrays.asList(spams));

        Map<String, Integer> callHistories = new HashMap<>();
        int[] result = new int[calls.length];
        for (int i = 0; i < calls.length; i++) {
            String call = calls[i];
            callHistories.compute(call, (key, value) -> {
                if (value == null) {
                    return 1;
                }

                return value + 1;
            });

            if (spamSet.contains(call)) {
                result[i] = 1;
                continue;
            }

            if (approvedSet.contains(call)) {
                result[i] = 0;
                continue;
            }

            Integer count = callHistories.get(call);
            if (count <= k) {
                result[i] = 1;
                continue;
            }

            result[i] = 0;
        }

        return result;
    }
}
