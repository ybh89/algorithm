package coddingtest.zigbang;

import java.util.*;

public class Solution2 {
    private static int totalUserCount;
    private static boolean[] visited;
    private static User[] users;
    private static List<Set<Integer>> conflictList;
    private static int maxCount = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        totalUserCount = Integer.parseInt(sc.nextLine());
        visited = new boolean[totalUserCount + 1];
        users = new User[totalUserCount + 1];
        conflictList = new ArrayList<>();
        for (int i = 0; i <= totalUserCount; i++) {
            conflictList.add(new HashSet<>());
        }
        for (int i = 1; i <= totalUserCount; i++) {
            String[] input = sc.nextLine().split(" ");
            users[i] = new User(Integer.parseInt(input[0]), Integer.parseInt(input[1]), Integer.parseInt(input[2]));

            for (int j = 1; j <= i - 1; j++) {
                if (users[i].isConflict(users[j])) {
                    conflictList.get(i).add(j);
                    conflictList.get(j).add(i);
                }
            }
        }
        for (int i = totalUserCount; i >= 1; i--) {
            combination(i, 1, new ArrayList<>());
            if (maxCount != Integer.MIN_VALUE) {
                System.out.println(maxCount);
                break;
            }
        }
    }

    private static void combination(int selectNumber, int start, List<Integer> result) {
        if (selectNumber == 0) {
            for (int i = 0; i < result.size(); i++) {
                for (int j = i + 1; j < result.size(); j++) {
                    if (conflictList.get(result.get(i)).contains(result.get(j))) {
                        return;
                    }
                }
            }
            if (maxCount < result.size()) {
                maxCount = result.size();
            }
            return;
        }

        for (int i = start; i <= totalUserCount; i++) {
            visited[i] = true;
            result.add(i);
            combination(selectNumber - 1, i + 1, result);
            result.remove(Integer.valueOf(i));
            visited[i] = false;
        }
    }

    static class User {
        private int index;
        private int start;
        private int end;

        public User(int index, int start, int end) {
            this.index = index;
            this.start = start;
            this.end = end;
        }

        public int getIndex() {
            return index;
        }

        public int getStart() {
            return start;
        }

        public int getEnd() {
            return end;
        }

        @Override
        public String toString() {
            return String.valueOf(index);
        }

        public boolean isConflict(User other) {
            if (other.getStart() == other.getEnd()) {
                return false;
            }

            if (start == end) {
                return false;
            }

            if (other.getStart() >= start && other.getStart() < end) {
                return true;
            }

            if (start >= other.getStart() && start < other.end) {
                return true;
            }

            return false;
        }
    }
}
