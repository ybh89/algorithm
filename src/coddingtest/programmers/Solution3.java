package coddingtest.programmers;

import java.util.Arrays;

public class Solution3 {
    public String[] solution(int[][] macaron) {
        int[][] board = new int[7][7];
        for (int[] b : board) {
            System.out.println(Arrays.toString(b));
        }

        for (int i = 0; i < macaron.length; i++) {
            int[] currentMa = macaron[i];
            int currentMaPosition = currentMa[0];
            int currentMaColor = currentMa[1];
            int height = findHeight(board, currentMaPosition);
            int[] maPosition = new int[]{height, currentMaPosition};
            board[maPosition[0]][maPosition[1]] = currentMaColor;


        }
        String[] answer = {};
        return answer;
    }

    private int findHeight(int[][] board, int currentMaPosition) {
        int height = 0;
        for (int i = 6; i >= 1; i--) {
            if (board[i][currentMaPosition] == 0) {
                height = i;
            }
        }

        return height;
    }

    public static void main(String[] args) {
        Solution3 solution3 = new Solution3();
        int[][] macaron = new int[][]{{1,1},{2,1},{1,2},{3,3},{6,4},{3,1},{3,3},{3,3},{3,4},{2,1}};
        System.out.println(Arrays.toString(solution3.solution(macaron)));
    }
}
