package coddingtest.delivery_hero;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Solution2 {
    private static final String SHIP = "#";
    private static final String VISITED = "V";
    private static final int[][] DIRECTIONS = new int[][]{{0,-1},{1,0},{0,1},{-1,0}}; // 왼쪽, 아래, 오른쪽, 위
    private static final int PATROL_SIZE = 1;
    private static final int SUBMARINE_SIZE = 2;
    private static final int DESTROYER_SIZE = 3;


    private String[][] map;
    private int patrolNumber = 0;
    private int submarineNumber = 0;
    private int destroyerNumber = 0;

    public int[] solution(String[] B) {
        buildMap(B);
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (SHIP.equals(map[i][j])) {
                    dfs(new int[]{i, j});
                }
            }
        }
        return new int[]{patrolNumber, submarineNumber, destroyerNumber};
    }

    private void dfs(int[] startPosition) {
        int shipSize = 0;
        Deque<int[]> stack = new ArrayDeque<>();
        stack.push(startPosition);
        map[startPosition[0]][startPosition[1]] = VISITED;
        shipSize++;

        while (!stack.isEmpty()) {
            int[] currentPosition = stack.pop();
            for (int[] direction : DIRECTIONS) {
                int nextY = currentPosition[0] + direction[0];// 위, 아래
                int nextX = currentPosition[1] + direction[1];// 좌, 우

                if(nextY < 0 || nextY >= map.length || nextX < 0 || nextX >= map[0].length) continue;

                if(SHIP.equals(map[nextY][nextX])) {
                    stack.push(new int[]{nextY, nextX});
                    map[nextY][nextX] = VISITED;
                    shipSize++;
                }
            }
        }

        countShipNumber(shipSize);
    }

    private void countShipNumber(int shipSize) {
        if (shipSize == PATROL_SIZE) {
            patrolNumber++;
            return;
        }
        if (shipSize == SUBMARINE_SIZE) {
            submarineNumber++;
            return;
        }
        if (shipSize == DESTROYER_SIZE) {
            destroyerNumber++;
            return;
        }
    }

    private void buildMap(String[] B) {
        map = new String[B.length][B[0].length()];
        for (int i = 0; i < B.length; i++) {
            map[i] = B[i].split("");
        }
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        System.out.println(Arrays.toString(solution2.solution(new String[]{".##.#", "#.#..", "#...#", "#.##."})));
    }
}
