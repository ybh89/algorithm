package dfs;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 백준 - 1987
 * 2 4
 * CAAB
 * ADCB
 */
public class 알파벳 {
    private static int R;
    private static int C;
    private static Set<String> isVisit = new HashSet<>();
    private static String[][] map;
    private static int maxCount = 0;
    private static int[][] directions = new int[][]{{-1,0},{0,1},{1,0},{0,-1}};// 위, 오른쪽, 아래, 왼쪽
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] inputs = sc.nextLine().split(" ");
        R = Integer.parseInt(inputs[0]);
        C = Integer.parseInt(inputs[1]);
        map = new String[R][C];
        for(int i=0; i<R; i++) {
            map[i] = sc.nextLine().split("");
        }
        isVisit.add(map[0][0]);
        dfs(0, 0, 1);
        System.out.println(maxCount);
    }

    private static void dfs(int x, int y, int count) {
        if(maxCount < count) {
            maxCount = count;
        }

        for(int[] direction : directions) {
            int nextX = x + direction[0];
            int nextY = y + direction[1];
            if(0 <= nextX && nextX < R && 0 <= nextY && nextY < C && !isVisit.contains(map[nextX][nextY])) {
                isVisit.add(map[nextX][nextY]);
                count++;
                dfs(nextX, nextY, count);
                count--;
                isVisit.remove(map[nextX][nextY]);
            }
        }
    }
}
