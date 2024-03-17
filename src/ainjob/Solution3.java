package ainjob;

import java.util.*;

public class Solution3 {
    private static final int[][] NEXT_POSITION = new int[][]{{0, 1}, {-1, 0}, {0, -1}, {1, 0}};

    private int[][] distance;

    public int[][] solution(int N, int[][] bus_stop) {
        distance = new int[N][N];

        // distance 초기화
        for (int i = 0; i < distance.length; i++) {
            for (int j = 0; j < distance[i].length; j++) {
                distance[i][j] = Integer.MAX_VALUE;
            }
        }

        // 버스 정류장 별 bfs
        for (int i = 0; i < bus_stop.length; i++) {
            int[] position = bus_stop[i];
            bfs(new Position(position[0] - 1, position[1] - 1));
        }

        return distance;
    }

    public void bfs(Position busStop) {
        Queue<Position> queue = new LinkedList<>();
        Set<Position> visited = new HashSet<>();
        queue.offer(busStop);
        distance[busStop.getX()][busStop.getY()] = 0;

        while (!queue.isEmpty()) {
            Position currentPosition = queue.poll();

            if (!visited.contains(currentPosition)) {
                visited.add(currentPosition);

                for (int[] pos : NEXT_POSITION) {
                    Position nextPosition = new Position(currentPosition.getX() + pos[0], currentPosition.getY() + pos[1]);

                    if (nextPosition.getX() < 0 || nextPosition.getX() > distance.length - 1
                            || nextPosition.getY() < 0 || nextPosition.getY() > distance.length - 1) {
                        continue;
                    }

                    int nextPositionDistance = distance[currentPosition.getX()][currentPosition.getY()] + 1;
                    if (nextPositionDistance < distance[nextPosition.getX()][nextPosition.getY()]) {
                        break;
                    }
                    if (nextPositionDistance >= distance[nextPosition.getX()][nextPosition.getY()]) {
                        continue;
                    }

                    if (!visited.contains(nextPosition)) {
                        queue.offer(nextPosition);
                        distance[nextPosition.getX()][nextPosition.getY()] = nextPositionDistance;
                    }
                }
            }
        }

    }

    static class Position {
        private int x;
        private int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Position position = (Position) o;
            return x == position.x && y == position.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }


    public static void main(String[] args) {
        Solution3 solution3 = new Solution3();
        // int[][] distance = solution3.solution(3, new int[][]{{1, 2}});
        int[][] distance = solution3.solution(3, new int[][]{{1, 2}, {3, 3}});

        for (int i = 0; i < distance.length; i++) {
            System.out.println(Arrays.toString(distance[i]));
        }
    }
}
