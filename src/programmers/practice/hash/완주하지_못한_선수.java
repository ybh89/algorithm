package programmers.practice.hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class 완주하지_못한_선수 {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> participants = new HashMap<>();
        initParticipants(participant, participants);
        for (int i = 0; i < completion.length; i++) {
            Integer count = participants.get(completion[i]) - 1;
            if (count == 0) {
                participants.remove(completion[i]);
            } else {
                participants.put(completion[i], count);
            }
        }

        Set<String> keys = participants.keySet();
        return keys.stream().findFirst().get();
    }

    private void initParticipants(String[] participant, Map<String, Integer> participants) {
        Arrays.stream(participant).forEach(name -> {
            if (participants.containsKey(name)) {
                int count = participants.get(name);
                participants.put(name, count + 1);
            } else {
                participants.put(name, 1);
            }
        });
    }

    public static void main(String[] args) {
        완주하지_못한_선수 solution = new 완주하지_못한_선수();
        String[] participant = new String[]{"marina", "josipa", "nikola", "vinko", "filipa"};
        String[] completion = new String[]{"josipa", "filipa", "marina", "nikola"};
        System.out.println(solution.solution(participant, completion));
    }
}
