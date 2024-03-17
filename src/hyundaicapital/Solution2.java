package hyundaicapital;

import java.util.*;

public class Solution2 {
    //List.of(new int[]{0,1}, new int[]{-1,1}, new int[]{-1,0}, new int[]{-1,-1}, new int[]{0,-1}, new int[]{1,-1}, new int[]{1,0}, new int[]{1,1})
    public static final Set<Position> MOVABLE = new HashSet<>(Arrays.asList(new Position(0, 1),new Position(-1, 1),new Position(-1, 0),new Position(-1, -1),new Position(0, -1),new Position(1, -1),new Position(1, 0),new Position(1, 1)));
    public static List<int[]> available = new ArrayList<>();
    public static int count = 0;

    public static void main(String[] args) {
        //int[][] phone = new int[][]{{1,1,0}, {0,1,0}, {0,0,0}, {0,0,0}};
        int[][] phone = new int[][]{{0,1,0}, {1,1,1}, {1,0,0}, {0,0,1}};
        solution(phone);
    }

    public static int solution(int[][] phone) {
        for (int i = 0; i < phone.length; i++) {
            for (int j = 0; j < phone[0].length; j++) {
                if (phone[i][j] == 1) {
                    available.add(new int[]{i, j});
                }
            }
        }

        for (int i = 2; i <= available.size(); i++) {
            bt(i, 0, new LinkedList<>());
        }
        System.out.println(count);
        return 0;
    }

    public static void bt(int pick, int depth, LinkedList<int[]> combination) {
        if (depth == pick) {
            combination.forEach(ints -> System.out.print(Arrays.toString(ints) + ", "));
            System.out.println();
            count++;
            return;
        }

        for (int i = 0; i < available.size(); i++) {
            if (!combination.contains(available.get(i))) {
                int[] from = combination.peekLast();
                int[] to = available.get(i);
                if (depth >= 1 && !canMovable(from, to)) {
                    continue;
                }

                combination.add(available.get(i));
                bt(pick, depth + 1, combination);
                combination.remove(available.get(i));
            }
        }
    }

    private static boolean canMovable(int[] from, int[] to) {
        int i = to[0] - from[0];
        int j = to[1] - from[1];
        return MOVABLE.contains(new Position(i, j));
    }

    static class Position {
        int i;
        int j;

        public Position(int i, int j) {
            this.i = i;
            this.j = j;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Position position = (Position) o;
            return i == position.i && j == position.j;
        }

        @Override
        public int hashCode() {
            return Objects.hash(i, j);
        }
    }
}
