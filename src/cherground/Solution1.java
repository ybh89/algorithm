package cherground;

import java.util.Objects;
import java.util.Stack;

public class Solution1 {
    private static final int[][] DIRECTIONS = new int[][]{{0, -1},{1, 0},{0, 1},{-1, 0}};

    public int solution(int[][] board) {
        int maxDistance = -1;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                int distance = dfs(new Position(i, j), board);
                if (maxDistance < distance) {
                    maxDistance = distance;
                }
            }
        }

        if (maxDistance == 1) {
            return -1;
        }

        return maxDistance;
    }

    public int dfs(Position start, int[][] board) {
        boolean[][] visited = new boolean[board.length][board.length];
        int[][] distance = new int[board.length][board.length];
        int maxDistance = 1;

        Stack<Position> stack = new Stack<>();
        stack.push(start);
        distance[start.getRow()][start.getColumn()] = 1;

        while (!stack.isEmpty()) {
            Position currentPosition = stack.pop();

            if (!visited[currentPosition.getRow()][currentPosition.getColumn()]) {
                visited[currentPosition.getRow()][currentPosition.getColumn()] = true;
                if (maxDistance < distance[currentPosition.getRow()][currentPosition.getColumn()]) {
                    maxDistance = distance[currentPosition.getRow()][currentPosition.getColumn()];
                }

                for (int[] direction : DIRECTIONS) {
                    Position nextPosition = new Position(currentPosition.getRow() + direction[0], currentPosition.getColumn() + direction[1]);

                    if (nextPosition.getRow() < 0 || nextPosition.getRow() >= board.length
                            || nextPosition.getColumn() < 0 || nextPosition.getColumn() >= board.length) {
                        continue;
                    }

                    if (board[nextPosition.getRow()][nextPosition.getColumn()] != board[currentPosition.getRow()][currentPosition.getColumn()]) {
                        continue;
                    }

                    if (!visited[nextPosition.getRow()][nextPosition.getColumn()]) {
                        stack.push(nextPosition);
                        distance[nextPosition.getRow()][nextPosition.getColumn()] = distance[currentPosition.getRow()][currentPosition.getColumn()] + 1;
                    }
                }

            }
        }

        return maxDistance;
    }

    static class Position {
        private int row;
        private int column;

        public Position(int row, int column) {
            this.row = row;
            this.column = column;
        }

        public int getRow() {
            return row;
        }

        public int getColumn() {
            return column;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Position position = (Position) o;
            return getRow() == position.getRow() && getColumn() == position.getColumn();
        }

        @Override
        public int hashCode() {
            return Objects.hash(getRow(), getColumn());
        }
    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        // System.out.println(solution1.solution(new int[][]{{3,2,3,2},{2,1,1,2},{1,1,2,1},{4,1,1,1}}));

        System.out.println(solution1.solution(new int[][]{{4,2,3,2},{2,1,2,4},{1,2,3,1},{4,1,4,3}}));
    }
}
