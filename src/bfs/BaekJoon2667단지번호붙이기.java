package bfs;

import java.util.*;

public class BaekJoon2667단지번호붙이기 {
    private static int[][] map;
    private static final int[][] NEXT_POSITION = new int[][]{{0, 1}, {-1, 0}, {0, -1}, {1, 0}}; // 오른쪽, 위, 왼쪽, 아래
    private static List<Integer> counts = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        map = new int[n][n];

        for (int i = 0; i < n; i ++) {
            map[i] = Arrays.stream(scanner.nextLine().split(""))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        int count = 0;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == 1) {
                    bfs(i, j);
                    count++;
                }
            }
        }

        System.out.println(count);
        counts.stream().sorted().forEach(System.out::println);
    }

    private static void bfs(int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j});
        int count = 0;

        while (!queue.isEmpty()) {
            int[] currentNode = queue.poll();
            if (map[currentNode[0]][currentNode[1]] == 1) {
                map[currentNode[0]][currentNode[1]] = -1;
                count++;

                for (int[] position : NEXT_POSITION) {
                    int nextI = currentNode[0] + position[0];
                    int nextJ = currentNode[1] + position[1];

                    if (nextI < 0 || nextI > map.length - 1 || nextJ < 0 || nextJ > map.length - 1) continue;

                    if (map[nextI][nextJ] == 1) {
                        queue.offer(new int[]{nextI, nextJ});
                    }
                }

            }
        }
        counts.add(count);
    }
}
