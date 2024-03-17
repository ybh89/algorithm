package bfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BaekJoon4963섬의개수 {
    private static final int[][] LOCATION = new int[][]{{0,1}, {-1,1}, {-1,0}, {-1,-1}, {0,-1}, {1,-1}, {1,0}, {1,1}};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String[] inputs = scanner.nextLine().split(" ");
            int w = Integer.parseInt(inputs[0]);
            int h = Integer.parseInt(inputs[1]);

            if (w == 0 && h == 0) break;

            int[][] map = new int[h][w];

            for (int i = 0; i < map.length; i++) {
                map[i] = Arrays.stream(scanner.nextLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();
            }

            int count = 0;
            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j <map[i].length; j++) {
                    if (map[i][j] == 1) {
                        bfs(map, i, j);
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }

    private static void bfs(int[][] map, int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j});

        while (!queue.isEmpty()) {
            int[] currentNode = queue.poll();
            if (map[currentNode[0]][currentNode[1]] == 1) {
                map[currentNode[0]][currentNode[1]] = -1;

                for (int[] location : LOCATION) {
                    int nextI = currentNode[0] + location[0];
                    int nextJ = currentNode[1] + location[1];

                    if (nextI < 0 || nextI > map.length - 1 || nextJ < 0 || nextJ > map[0].length - 1) continue;

                    if (map[nextI][nextJ] == 1) {
                        queue.offer(new int[]{nextI, nextJ});
                    }
                }
            }
        }
    }
}
