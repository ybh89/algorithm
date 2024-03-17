package bfs;

import java.util.*;

public class BJ2636치즈 {
    private static final int[][] DIRECTION = new int[][]{{0, 1}, {-1, 0}, {0, -1}, {1, 0}};
    private static int[][] map;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] inputs = scanner.nextLine().split(" ");
        int n = Integer.parseInt(inputs[0]);
        int m = Integer.parseInt(inputs[1]);
        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            map[i] = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        int num = 0;
        int lastCount = 0;
        while (true) {
            int count = 0;
            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map[0].length; j++) {
                    if (map[i][j] == 1) {
                        count++;
                    }
                }
            }
            if (count != 0) {
                lastCount = count;
            }

            if (count == 0) {
                break;
            }

            bfs(0, 0);
            num++;
        }

        System.out.println(num);
        System.out.println(lastCount);

    }

    public static void bfs(int startRow, int startCol) {
        Set<List<Integer>> visited = new HashSet<>();
        Queue<List<Integer>> queue = new LinkedList<>();
        queue.offer(List.of(startRow, startCol));

        while (!queue.isEmpty()) {
            List<Integer> currentNode = queue.poll();

            if (map[currentNode.get(0)][currentNode.get(1)] != 0) {
                continue;
            }

            if (!visited.contains(currentNode)) {
                visited.add(currentNode);
                for (int[] direction : DIRECTION) {
                    List<Integer> nextNode = List.of(currentNode.get(0) + direction[0], currentNode.get(1) + direction[1]);

                    if (nextNode.get(0) < 0 || nextNode.get(0) > map.length - 1
                            || nextNode.get(1) < 0 || nextNode.get(1) > map[0].length - 1) {
                        continue;
                    }

                    if (map[nextNode.get(0)][nextNode.get(1)] == 1) {
                        map[nextNode.get(0)][nextNode.get(1)] = 0;
                        visited.add(List.of(nextNode.get(0), nextNode.get(1)));
                        continue;
                    }

                    if (!visited.contains(nextNode) || map[nextNode.get(0)][nextNode.get(1)] == 0) {
                        queue.add(nextNode);
                    }
                }
            }
        }
    }
}
