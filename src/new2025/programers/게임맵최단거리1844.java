package new2025.programers;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;

public class 게임맵최단거리1844 {
    private static final int[][] DIRECTION = new int[][]{{0,1}, {-1,0}, {0,-1}, {1,0}}; // 오른쪽, 아래, 왼쪽, 위쪽
    public static void main(String[] args) {
        게임맵최단거리1844 sol = new 게임맵최단거리1844();
        System.out.println(sol.solution(new int[][]{{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1}, {0, 0, 0, 0, 1}}));
        System.out.println(sol.solution(new int[][]{{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 0}, {0, 0, 0, 0, 1}}));
    }

    public int solution(int[][] maps) {
        Queue<Node> queue = new LinkedList<>();
        Set<Node> visitedSet = new HashSet<>();
        Node startNode = new Node(0, 0, 1);
        queue.offer(startNode);
        visitedSet.add(startNode);

        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();

            if (currentNode.getX() == maps.length - 1 && currentNode.getY() == maps[0].length - 1) {
                return currentNode.getDistance();
            }

            for (int i = 0; i < DIRECTION.length; i++) {
                Node nextNode = new Node(currentNode.getX() + DIRECTION[i][0], currentNode.getY() + DIRECTION[i][1], currentNode.getDistance() + 1);

                if (nextNode.getX() < 0 || nextNode.getX() > maps.length - 1 || nextNode.getY() < 0
                        || nextNode.getY() > maps[0].length - 1 || maps[nextNode.getX()][nextNode.getY()] == 0
                        || visitedSet.contains(nextNode)) {
                    continue;
                }

                queue.offer(nextNode);
                visitedSet.add(nextNode);
            }
        }

        return -1;
    }

    static class Node {
        private int x;
        private int y;
        private int distance;

        public Node(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public int getDistance() {
            return distance;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return x == node.x && y == node.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}
