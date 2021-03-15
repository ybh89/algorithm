package dfs;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/**
 * 백준 1012
 * 입력값
 * M: 밭 가로
 * N: 밭 세로
 * K: 배추수
 * X,Y: 배추 위치
 */
public class 유기농_배추 {
    private static int[][] direction = new int[][]{{0,-1},{1,0},{0,1},{-1,0}};// Y, X 순 -> 왼쪽, 아래, 오른쪽, 위
    private static int[][] map;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());
        for(int t=0; t<T; t++) {
            String[] inputs = sc.nextLine().split(" ");
            int M = Integer.parseInt(inputs[0]);
            int N = Integer.parseInt(inputs[1]);
            int K = Integer.parseInt(inputs[2]);
            map = new int[N][M];

            for(int k=0; k<K; k++) {
                String[] location = sc.nextLine().split(" ");
                int X = Integer.parseInt(location[0]); // 좌, 우
                int Y = Integer.parseInt(location[1]); // 위, 아래

                map[Y][X] = 1;
            }

            System.out.println(findCountByDfsRecursive());
        }
    }

    // 반복으로 dfs구현
    private static int findCountByDfsIterative() {
        int count = 0;

        for(int i=0; i<map.length; i++) {
            for(int j=0; j<map[i].length; j++) {
                if(map[i][j] == 1) {
                    dfsIterative(new int[]{i, j});
                    count++;
                }
            }
        }

        return count;
    }

    private static void dfsIterative(int[] start) {
        Deque<int[]> stack = new ArrayDeque<>();//위치 정보 저장(Y, X 순)
        stack.push(start);

        while (!stack.isEmpty()) {
            int[] curLocation = stack.pop();
            map[curLocation[0]][curLocation[1]] = 2; // 이미 방문한 배추 위치 표시

            for(int d=0; d<direction.length; d++) {
                int nextX = curLocation[0] + direction[d][0];// 위, 아래
                int nextY = curLocation[1] + direction[d][1];// 좌, 우

                if(nextY < 0 || nextY >= map[0].length || nextX < 0 || nextX >= map.length) continue;

                if(map[nextX][nextY] == 1) {
                    stack.push(new int[]{nextX, nextY});
                }
            }
        }
    }

    // 재귀를 이용한 dfs
    private static int findCountByDfsRecursive() {
        int count = 0;

        for(int i=0; i<map.length; i++) {
            for(int j=0; j<map[i].length; j++) {
                if(map[i][j] == 1) {
                    dfsRecursive(new int[]{i, j});
                    count++;
                }
            }
        }

        return count;
    }

    private static void dfsRecursive(int[] curLocation) {
        //종료
        if(map[curLocation[0]][curLocation[1]] != 1) {
            return;
        }

        map[curLocation[0]][curLocation[1]] = 2; // 이미 방문한 배추 위치 표시

        //프로세스
        for(int d=0; d<direction.length; d++) {
            int nextX = curLocation[0] + direction[d][0];// 위, 아래
            int nextY = curLocation[1] + direction[d][1];// 좌, 우

            if(nextY < 0 || nextY >= map[0].length || nextX < 0 || nextX >= map.length) continue;

            if(map[nextX][nextY] == 1) {
                dfsRecursive(new int[]{nextX, nextY});
            }
        }
    }
}
