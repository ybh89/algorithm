package bfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 백준 - 17071
 */
public class 숨바꼭질5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] inputs = sc.nextLine().split(" ");
        int N = Integer.parseInt(inputs[0]);
        int K = Integer.parseInt(inputs[1]);

        System.out.println(bfs(N, K));
    }

    private static int bfs(int N, int K) {
        Queue<Integer> q = new LinkedList<>();
        int[] dist = new int[500001];
        Arrays.fill(dist, -1);

        q.offer(N);
        dist[N] = 0;
        int Y = K;

        while (!q.isEmpty()) {
            int curNode = q.poll();

            Y = K + (dist[curNode] * (dist[curNode] + 1))/2;

            int[] nextPos = new int[]{curNode-1, curNode+1, curNode*2};
            for(int i=0; i<nextPos.length; i++) {
                int nextNode = nextPos[i];
                if(0 <= nextNode && nextNode <= 500000 && dist[nextNode] == -1) {
                    q.offer(nextNode);
                    dist[nextNode] = dist[curNode] + 1;
                }
            }
        }

        return dist[Y];
    }
}
