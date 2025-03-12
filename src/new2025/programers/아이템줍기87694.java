package new2025.programers;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;

public class 아이템줍기87694 {
    private static final int[][] MOVE = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}}; // x, y

    public static void main(String[] args) {
        아이템줍기87694 sol = new 아이템줍기87694();
        // System.out.println(sol.solution(new int[][]{{1, 1, 7, 4}, {3, 2, 5, 5}, {4, 3, 6, 9}, {2, 6, 8, 8}}, 1, 3, 7, 8));
        // System.out.println(sol.solution(new int[][]{{1, 1, 8, 4}, {2, 2, 4, 9}, {3, 6, 9, 8}, {6, 3, 7, 7}}, 9, 7, 6, 1));
        // System.out.println(sol.solution(new int[][]{{1, 1, 5, 7}}, 1, 1, 4, 7));
        // System.out.println(sol.solution(new int[][]{{2, 1, 7, 5}, {6, 4, 10, 10}}, 3, 1, 7, 10));
        System.out.println(sol.solution(new int[][]{{2, 2, 5, 5}, {1, 3, 6, 4}, {3, 1, 4, 6}}, 1, 4, 6, 3));
    }

    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int distance = 0;
        Queue<Position> queue = new LinkedList<>();
        Position characterPosition = new Position(characterX, characterY, 0);
        queue.offer(characterPosition);
        Set<Position> visitedSet = new HashSet<>();
        visitedSet.add(characterPosition);

        while (!queue.isEmpty()) {
            Position current = queue.poll();
            if (current.getX() == itemX && current.getY() == itemY) {
                distance = current.getDistance();
                break;
            }

            for (int[] mv : MOVE) {
                Position next = new Position(current.getX() + mv[0], current.getY() + mv[1], current.getDistance() + 1);
                if (visitedSet.contains(next) || !canGo(current.getX(), current.getY(), next.getX(), next.getY(), rectangle)) {
                    continue;
                }

                queue.add(next);
                visitedSet.add(next);
                System.out.println("[" + next.getX() + "," + next.getY() + "] " + next.getDistance());
            }
        }
        return distance;
    }

    public boolean canGo(int currentCharacterX, int currentCharacterY, int nextCharacterX, int nextCharacterY, int[][] rectangle) {
        for (int[] rect : rectangle) {
            // 캐릭터 위치가 rect 내부냐?
            boolean insideRectangle = (nextCharacterX > rect[0] && nextCharacterX < rect[2])
                    && (nextCharacterY > rect[1] && nextCharacterY < rect[3]);
            if (insideRectangle) {
                return false;
            }
        }

        for (int[] rect : rectangle) {
            if (isLineOnRectangleEdge(currentCharacterX, currentCharacterY, nextCharacterX, nextCharacterY, rect)) {
                return true;
            }
        }

        return false;
    }

    private static boolean isLineOnRectangleEdge(int x1, int y1, int x2, int y2, int[] rect) {
        int xMin = rect[0], yMin = rect[1], xMax = rect[2], yMax = rect[3];

        // 직선이 사각형의 수직(세로) 테두리 위에 있는지 확인
        boolean onLeftEdge = (x1 == xMin && x2 == xMin) && (y1 >= yMin && y1 <= yMax) && (y2 >= yMin && y2 <= yMax);
        boolean onRightEdge = (x1 == xMax && x2 == xMax) && (y1 >= yMin && y1 <= yMax) && (y2 >= yMin && y2 <= yMax);

        // 직선이 사각형의 수평(가로) 테두리 위에 있는지 확인
        boolean onTopEdge = (y1 == yMin && y2 == yMin) && (x1 >= xMin && x1 <= xMax) && (x2 >= xMin && x2 <= xMax);
        boolean onBottomEdge = (y1 == yMax && y2 == yMax) && (x1 >= xMin && x1 <= xMax) && (x2 >= xMin && x2 <= xMax);

        return onLeftEdge || onRightEdge || onTopEdge || onBottomEdge;
    }

    static class Position {
        private int x;
        private int y;
        private int distance;

        public Position(int x, int y, int distance) {
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

        public int getDistance() {
            return distance;
        }
    }
}
