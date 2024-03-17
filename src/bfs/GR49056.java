package bfs;

import java.util.*;

public class GR49056 {
    private static final int[][] NEXT_POSITION = new int[][]{{0, 1}, {-1, 0}, {0, -1}, {1, 0}};
    private static int[][] map;
    private static int magic;

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int[] inputs = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        magic = inputs[2];
        map = new int[inputs[0]][inputs[1]];

        for (int i = 0; i < map.length; i++) {
            map[i] = Arrays.stream(scanner.nextLine().split("")).mapToInt(Integer::parseInt).toArray();
        }

        System.out.println(bfs());
    }

    public static int bfs() {
        int[][] distance = new int[map.length][map[0].length];
        Set<List<Integer>> visited = new HashSet<>();
        Queue<List<Integer>> queue = new LinkedList<>();
        queue.offer(List.of(0, 0));

        while (!queue.isEmpty()) {
            List<Integer> currentPos = queue.poll();

            for (int i = 0; i < distance.length; i++) {
                System.out.println(Arrays.toString(distance[i]));
            }
            System.out.println();

            if (!visited.contains(currentPos)) {
                visited.add(currentPos);
                if (map[currentPos.get(0)][currentPos.get(1)] == 1) {
                    magic -= 10;
                }

                if (currentPos.get(0) == map.length - 1 && currentPos.get(1) == map[0].length - 1) {
                    break;
                }

                for (int[] pos : NEXT_POSITION) {
                    List<Integer> nextPos = List.of(currentPos.get(0) + pos[0], currentPos.get(1) + pos[1]);

                    if (nextPos.get(0) < 0 || nextPos.get(0) > map.length - 1 || nextPos.get(1) < 0 || nextPos.get(1) > map[0].length - 1) {
                        continue;
                    }

                    if (map[currentPos.get(0)][currentPos.get(1)] == 1 && map[nextPos.get(0)][nextPos.get(1)] == 1) {
                        continue;
                    }

                    if (map[nextPos.get(0)][nextPos.get(1)] == 1 && magic < 10) {
                        continue;
                    }

                    if (!visited.contains(nextPos)) {
                        queue.offer(nextPos);
                        if (map[nextPos.get(0)][nextPos.get(1)] == 1) {
                            distance[nextPos.get(0)][nextPos.get(1)] = distance[currentPos.get(0)][currentPos.get(1)];
                        } else {
                            distance[nextPos.get(0)][nextPos.get(1)] = distance[currentPos.get(0)][currentPos.get(1)] + 1;
                        }
                    }
                }

                if (map[currentPos.get(0)][currentPos.get(1)] == 1) {
                    magic += 10;
                }
            }
        }

        if (!visited.contains(List.of(map.length - 1, map[0].length - 1))) {
            return -1;
        }

        return distance[map.length - 1][map[0].length - 1];
    }
}
