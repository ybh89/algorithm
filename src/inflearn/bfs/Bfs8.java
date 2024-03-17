package inflearn.bfs;

import java.util.*;

public class Bfs8 {
    private static int[] moves = new int[]{-1, 1, 5};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int s = Integer.parseInt(input[0]);
        int e = Integer.parseInt(input[1]);

        System.out.println(solution(s, e));
    }

    private static int solution(Integer s, Integer e) {
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        queue.offer(s);

        int count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer currentPos = queue.poll();

                if (!visited.contains(currentPos)) {
                    visited.add(currentPos);

                    for (int move : moves) {
                        Integer nextPos = currentPos + move;
                        if (nextPos.equals(e)) {
                            return count + 1;
                        }
                        if (1 <= nextPos && nextPos <= 10000 && !visited.contains(nextPos)) {
                            queue.offer(nextPos);
                        }
                    }
                }
            }
            count++;
        }

        throw new IllegalStateException("정답이 없습니다.");
    }
}
