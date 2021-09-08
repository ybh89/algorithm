package programmers.practice.exhaustivesearch;

import java.util.*;

public class 모의고사 {
    public int[] solution(int[] answers) {
        final int[] giveUp1 = new int[]{1, 2, 3, 4, 5};
        final int[] giveUp2 = new int[]{2, 1, 2, 3, 2, 4, 2, 5};
        final int[] giveUp3 = new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int answerCount1 = 0;
        int answerCount2 = 0;
        int answerCount3 = 0;

        for (int i = 0; i < answers.length; i++) {
            if ((i == 0 && answers[0] == giveUp1[0]) || answers[i] == giveUp1[i % giveUp1.length]) {
                answerCount1++;
            }
            if ((i == 0 && answers[0] == giveUp2[0]) || answers[i] == giveUp2[i % giveUp2.length]) {
                answerCount2++;
            }
            if ((i == 0 && answers[0] == giveUp3[0]) || answers[i] == giveUp3[i % giveUp3.length]) {
                answerCount3++;
            }
        }

        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, answerCount1);
        map.put(2, answerCount2);
        map.put(3, answerCount3);

        List<Map.Entry<Integer, Integer>> list_entries = new ArrayList<>(map.entrySet());
        Collections.sort(list_entries, (obj1, obj2) -> obj2.getValue().compareTo(obj1.getValue()));

        List<Integer> results = new ArrayList<>();
        results.add(list_entries.get(0).getKey());
        if (list_entries.get(0).getValue().equals(list_entries.get(1).getValue())) {
            results.add(list_entries.get(1).getKey());
        }
        if (list_entries.get(0).getValue().equals(list_entries.get(2).getValue())) {
            results.add(list_entries.get(2).getKey());
        }

        return results.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        모의고사 solution = new 모의고사();
        int[] numbers = new int[]{5,5,5,5,2,5,5,5,5,2,5,5,5,5,2,5,5,5,5,2};
        System.out.println(Arrays.toString(solution.solution(numbers)));
    }
}
