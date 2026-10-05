package new2026.leetcode.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class _200 {
    private static final int[][] DIRECTIONS = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    bfs(i, j, grid);
                    count++;
                }
            }
        }
        return count;
    }

    private void bfs(int i, int j, char[][] grid) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(i, j));
        grid[i][j] = '0';

        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();

            for (int[] direction : DIRECTIONS) {
                int nextRow = currentNode.row + direction[0];
                int nextCol = currentNode.col + direction[1];

                if (nextRow < 0 || nextRow >= grid.length || nextCol < 0 || nextCol >= grid[0].length) {
                    continue;
                }

                if (grid[nextRow][nextCol] == '1') {
                    queue.offer(new Node(nextRow, nextCol));
                    grid[nextRow][nextCol] = '0';
                }
            }
        }
    }

    private static class Node {
        private final int row;
        private final int col;

        public Node(int row, int col) {
            this.row = row;
            this.col = col;
        }

        public int getRow() {
            return row;
        }

        public int getCol() {
            return col;
        }
    }

    static void main() {
        _200 sol = new _200();
        System.out.println(sol.numIslands(new char[][]{{'1','1','0','0','0'}, {'1','1','0','0','0'}, {'0','0','1','0','0'}, {'0','0','0','1','1'}}));
    }
}
