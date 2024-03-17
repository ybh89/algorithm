package kakao;

import java.io.IOException;
import java.util.*;


class Result3 {

    /*
     * Complete the 'solution' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static List<Integer> solution(int n, List<String> queryType, List<Integer> students1, List<Integer> students2) {
        // Write your code here
        List<Integer> result = new ArrayList<>();
        List<List<Integer>> linkedFriends = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            linkedFriends.add(new ArrayList<>());
        }

        for (int i = 0; i < queryType.size(); i++) {
            String currentQueryType = queryType.get(i);
            if ("Friend".equals(currentQueryType)) {
                linkedFriends.get(students1.get(i)).add(students2.get(i));
                linkedFriends.get(students2.get(i)).add(students1.get(i));
            }

            if ("Total".equals(currentQueryType)) {
                result.add(countFriends(students1.get(i), linkedFriends) + countFriends(students2.get(i), linkedFriends));
            }
        }

        return result;
    }

    private static int countFriends(Integer startFriend, List<List<Integer>> linkedFriends) {
        int count = 0;

        Set<Integer> isVisit = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        q.offer(startFriend);

        while (!q.isEmpty()) {
            int currentFriend = q.poll();

            if (!isVisit.contains(currentFriend)) {
                isVisit.add(currentFriend);
                count++;

                for (Integer linkedFriend : linkedFriends.get(currentFriend)) {
                    q.offer(linkedFriend);
                }
            }
        }

        return count;
    }
}

public class Solution3 {
    public static void main(String[] args) throws IOException {
        int n = 4;
        List<String> queryType = List.of("Total", "Total", "Total");
        List<Integer> students1 = List.of(1, 2, 1);
        List<Integer> students2 = List.of(2, 3, 4);

        System.out.println(Result3.solution(n, queryType, students1, students2));
    }
}
