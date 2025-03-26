package new2025.programers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 튜플64065 {
    public static void main(String[] args) {
        튜플64065 sol = new 튜플64065();
        System.out.println(Arrays.toString(sol.solution("{{2},{2,1},{2,1,3},{2,1,3,4}}")));
        System.out.println(Arrays.toString(sol.solution("{{1,2,3},{2,1},{1,2,4,3},{2}}")));
        System.out.println(Arrays.toString(sol.solution("{{20,111},{111}}")));
        System.out.println(Arrays.toString(sol.solution("{{123}}")));
        System.out.println(Arrays.toString(sol.solution("{{4,2,3},{3},{2,3,4,1},{2,3}}")));
    }

    public int[] solution(String s) {
        String substring = s.substring(2, s.length() - 2);
        String[] split = substring.split("\\},\\{");
        String[][] splitResult = new String[split.length][];
        for (int i = 0; i < split.length; i++) {
            splitResult[i] = split[i].split(",");
        }

        Map<Integer, Integer> countIntegerMap = new HashMap<>();
        for (int i = 0; i < splitResult.length; i++) {
            int length = splitResult[i].length;
            countIntegerMap.put(length, i);
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= splitResult.length; i++) {
            String[] strings = splitResult[countIntegerMap.get(i)];

            for (int j = 0; j < strings.length; j++) {
                if (!result.contains(Integer.parseInt(strings[j]))) {
                    result.add(Integer.parseInt(strings[j]));
                    break;
                }
            }
        }

        return result.stream().mapToInt(value -> value).toArray();
    }
}
