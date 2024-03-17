package backTracking;

import java.util.*;

public class BJ15683감시 {
    /**
     * index 1(1번 cctv): 4가지
     * - 1: 오른쪽
     * - 2: 위
     * - 3: 왼쪽
     * - 4: 아래
     *
     * index 2(2번 cctv): 2가지
     * - 1: 좌우
     * - 2: 상하
     *
     * index 3(3번 cctv): 4가지
     * - 1: 위, 오른쪽
     * - 2: 위, 왼쪽
     * - 3: 아래, 오른쪽
     * - 4: 아래, 왼쪽
     *
     * index 4(4번 cctv): 4가지
     * - 1: 왼쪽, 위, 오른쪽
     * - 2: 왼쪽, 아래, 오른쪽
     * - 3, 위, 왼쪽, 아래
     * - 4, 위, 오른쪽, 아래
     */
    private static final int[] NUMBER_CASES = {0, 4, 2, 4, 4};

    private static final int[][] CCTV1_DIRECTION = {{1}, {2}, {3}, {4}};
    private static final int[][] CCTV2_DIRECTION = {{1, 3}, {2, 4}};
    private static final int[][] CCTV3_DIRECTION = {{2, 1}, {2, 3}, {4, 1}, {4, 3}};
    private static final int[][] CCTV4_DIRECTION = {{3, 2, 1}, {3, 4, 1}, {2, 3, 4}, {2, 1, 4}};
    private static final int[][] CCTV5_DIRECTION = {{1, 2, 3, 4}};

    private static final int[][][] CCTV_DIRECTION = {null, CCTV1_DIRECTION, CCTV2_DIRECTION, CCTV3_DIRECTION, CCTV4_DIRECTION, CCTV5_DIRECTION};

    private static List<Cctv> cctvs = new ArrayList<>();
    private static Set<Cctv> visited = new HashSet<>();
    private static int[][] map;
    private static int blindSpotSize = 0;
    private static int maxCoverSize = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] inputs = scanner.nextLine().split(" ");
        int n = Integer.parseInt(inputs[0]);
        int m = Integer.parseInt(inputs[1]);
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            map[i] = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j <map[i].length; j++) {
                if (1 <= map[i][j] && map[i][j] <=5) { // cctv이면
                    cctvs.add(new Cctv(map[i][j], i, j));
                }
                if (map[i][j] == 0) {
                    blindSpotSize++;
                }
            }
        }
        bt(0, 0, new ArrayList<>());
        System.out.println(blindSpotSize - maxCoverSize);
    }

    public static void bt(int depth, int start, List<Cctv> combination) {
        if (depth == cctvs.size()) {
            Set<List<Integer>> coverLocation = new HashSet<>();
            for (Cctv cctv : combination) {
                for (int direction : cctv.getDirections()) {
                    if (direction == 2) {
                        int currentRow = cctv.getRow() - 1;
                        int currentCol = cctv.getCol();

                        while (currentRow >= 0) {
                            if (map[currentRow][currentCol] == 6) {
                                break;
                            }
                            if (map[currentRow][currentCol] == 0) {
                                coverLocation.add(List.of(currentRow, currentCol));
                            }
                            currentRow--;
                        }
                    }

                    if (direction == 4) {
                        int currentRow = cctv.getRow() + 1;
                        int currentCol = cctv.getCol();

                        while (currentRow <= map.length - 1) {
                            if (map[currentRow][currentCol] == 6) {
                                break;
                            }
                            if (map[currentRow][currentCol] == 0) {
                                coverLocation.add(List.of(currentRow, currentCol));
                            }
                            currentRow++;
                        }
                    }

                    if (direction == 1) {
                        int currentRow = cctv.getRow();
                        int currentCol = cctv.getCol() + 1;

                        while (currentCol <= map[0].length - 1) {
                            if (map[currentRow][currentCol] == 6) {
                                break;
                            }
                            if (map[currentRow][currentCol] == 0) {
                                coverLocation.add(List.of(currentRow, currentCol));
                            }
                            currentCol++;
                        }
                    }

                    if (direction == 3) {
                        int currentRow = cctv.getRow();
                        int currentCol = cctv.getCol() - 1;

                        while (currentCol >= 0) {
                            if (map[currentRow][currentCol] == 6) {
                                break;
                            }
                            if (map[currentRow][currentCol] == 0) {
                                coverLocation.add(List.of(currentRow, currentCol));
                            }
                            currentCol--;
                        }
                    }
                }
            }

            if (maxCoverSize < coverLocation.size()) {
                maxCoverSize = coverLocation.size();
            }

            return;
        }

        for (int i = start; i < cctvs.size(); i++) {
            Cctv cctv = cctvs.get(i);
            for (int j = 0; j < CCTV_DIRECTION[cctv.type].length; j++) {
                if (!visited.contains(cctv)) {
                    cctv.setDirections(CCTV_DIRECTION[cctv.type][j]);
                    visited.add(cctv);
                    combination.add(cctv);
                    bt(depth + 1, i + 1, combination);
                    combination.remove(combination.size() - 1);
                    visited.remove(cctv);
                }
            }
        }
    }

    static class Cctv {
        private int type;
        private int row;
        private int col;
        private int[] directions;

        public Cctv(int type, int row, int col) {
            this.type = type;
            this.row = row;
            this.col = col;
        }

        public void setDirections(int[] directions) {
            this.directions = directions;
        }

        public int getType() {
            return type;
        }

        public int getRow() {
            return row;
        }

        public int getCol() {
            return col;
        }

        public int[] getDirections() {
            return directions;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Cctv cctv = (Cctv) o;
            return getType() == cctv.getType() && getRow() == cctv.getRow() && getCol() == cctv.getCol() && Arrays.equals(getDirections(), cctv.getDirections());
        }

        @Override
        public int hashCode() {
            int result = Objects.hash(getType(), getRow(), getCol());
            result = 31 * result + Arrays.hashCode(getDirections());
            return result;
        }

        @Override
        public String toString() {
            return "Cctv{" +
                    "type=" + type +
                    ", row=" + row +
                    ", col=" + col +
                    ", directions=" + Arrays.toString(directions) +
                    '}';
        }
    }
}
