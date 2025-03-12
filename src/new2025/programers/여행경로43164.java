package new2025.programers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class 여행경로43164 {
    private List<String> resultList = new ArrayList<>();
    public static void main(String[] args) {
        여행경로43164 sol = new 여행경로43164();
        System.out.println(Arrays.toString(sol.solution(new String[][]{{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}})));
        System.out.println(Arrays.toString(sol.solution(new String[][]{{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL", "SFO"}})));
        System.out.println(Arrays.toString(sol.solution(new String[][]{{"ICN", "AAA"}, {"ICN", "CCC"}, {"CCC", "DDD"}, {"AAA", "BBB"}, {"AAA", "BBB"}, {"DDD", "ICN"}, {"BBB", "AAA"}})));
        System.out.println(Arrays.toString(sol.solution(new String[][]{{"ICN", "AAA"}, {"ICN", "AAA"}, {"AAA", "ICN"}, {"AAA", "BBB"}})));
        System.out.println(Arrays.toString(sol.solution(new String[][]{{"EZE", "TIA"}, {"EZE", "HBA"}, {"AXA", "TIA"}, {"ICN", "AXA"}, {"ANU", "ICN"}, {"ADL", "ANU"}, {"TIA", "AUA"}, {"ANU", "AUA"}, {"ADL", "EZE"}, {"ADL", "EZE"}, {"EZE", "ADL"}, {"AXA", "EZE"}, {"AUA", "AXA"}, {"ICN", "AXA"}, {"AXA", "AUA"}, {"AUA", "ADL"}, {"ANU", "EZE"}, {"TIA", "ADL"}, {"EZE", "ANU"}, {"AUA", "ANU"}})));
        System.out.println(Arrays.toString(sol.solution(new String[][]{{"ICN", "A"}, {"A", "B"}, {"A", "C"}, {"C", "A"}, {"B", "D"}})));
    }

    public String[] solution(String[][] tickets) {
        Map<String, List<Integer>> link = new HashMap<>();
        List<Integer> startIndex = new ArrayList<>();

        for (int i = 0; i < tickets.length; i++) {
            String[] ticket = tickets[i];
            int index = i;
            link.compute(ticket[0], (key, value) -> {
                if (key == null) {
                    List<Integer> next = new ArrayList<>();
                    next.add(index);
                    return next;
                }

                if (value == null) {
                    value = new ArrayList<>();
                }
                value.add(index);
                return value;
            });

            assert ticket[0] != null;
            if (ticket[0].equals("ICN")) {
                startIndex.add(i);
            }
        }

        for (Integer index : startIndex) {
            Set<Integer> visited = new HashSet<>();
            visited.add(index);
            dfs(index, new StringBuilder(tickets[index][0]), visited, link, tickets);
        }

        Collections.sort(resultList);

        return resultList.get(0).split(" ");
    }

    public void dfs(Integer current, StringBuilder route, Set<Integer> visited, Map<String, List<Integer>> link, String[][] tickets) {
        if (visited.size() == tickets.length) {
            resultList.add(route
                    .append(" ")
                    .append(tickets[current][1]).toString());
            return;
        }

        String[] ticket = tickets[current];
        List<Integer> nextList = link.get(ticket[1]);
        if (nextList == null) {
            return;
        }
        for (Integer next : nextList) {
            if (!visited.contains(next)) {
                visited.add(next);
                route.append(" ").append(ticket[1]);
                dfs(next, route, visited, link, tickets);
                route.delete(route.lastIndexOf(" "), route.length());
                visited.remove(next);
            }
        }
    }
}
