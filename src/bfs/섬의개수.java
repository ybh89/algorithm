package bfs;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

/**
 * 백준 - 4963
 */
public class 섬의개수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            String[] inputs = sc.nextLine().split(" ");
            int width = Integer.parseInt(inputs[0]);
            int height = Integer.parseInt(inputs[1]);

            if (width == 0 && height == 0) {
                break;
            }

            int[][] map = new int[height][width];
            for (int i = 0; i < height; i++) {
                map[i] = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }

            int number = countLand(map);
            System.out.println(number);
        }
    }

    private static int countLand(int[][] map) {
        int count = 0;

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == 0 || map[i][j] == 2) {
                    continue;
                }
                bfs(map, new int[]{i, j});
                count++;
            }
        }
        return count;
    }

    private static void bfs(int[][] map, int[] startPos) {
        Queue<int[]> queue = new ArrayDeque<>();
        int[][] directions = new int[][]{{-1,0}, {-1,1}, {0,1}, {1,1}, {1,0}, {1,-1}, {0,-1}, {-1,-1}};
        queue.offer(startPos);
        map[startPos[0]][startPos[1]] = 2; // 방문 표시

        while (!queue.isEmpty()) {
            int[] currentPos = queue.poll();
            for (int n = 0; n < directions.length; n++) { // 주변을 살핌
                int nextI = currentPos[0] + directions[n][0];
                int nextJ = currentPos[1] + directions[n][1];
                if (nextI < 0 || nextJ < 0 || nextI > map.length - 1 || nextJ > map[0].length - 1
                        || map[nextI][nextJ] == 0 || map[nextI][nextJ] == 2) {
                    continue; // 방문할 수 없는 곳
                }
                queue.offer(new int[]{nextI, nextJ});
                map[nextI][nextJ] = 2;
            }
        }
    }
}
