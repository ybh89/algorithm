package bfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 백준 - 13913
 */
public class 숨바꼭질4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] inputs = sc.nextLine().split(" ");
        int N = Integer.parseInt(inputs[0]);
        int K = Integer.parseInt(inputs[1]);

        bfs(N, K);
    }

    private static void bfs(int N, int K) {
        Queue<Integer> q = new LinkedList<>();
        int[] dist = new int[100001];
        Arrays.fill(dist, -1);
        int[] parents = new int[100001];
        Arrays.fill(parents, -1);

        q.offer(N);
        dist[N] = 0;

        while (!q.isEmpty()) {
            int curNode = q.poll();

            int[] nextPos = new int[]{curNode-1, curNode+1, curNode*2};
            for(int i=0; i<nextPos.length; i++) {
                int nextNode = nextPos[i];
                if(0 <= nextNode && nextNode <= 100000 && dist[nextNode] == -1) {
                    q.offer(nextNode);
                    dist[nextNode] = dist[curNode] + 1;
                    parents[nextNode] = curNode;

                    if(nextNode == K) {
                        q.clear();
                        break;
                    }
                }
            }
        }

        System.out.println(dist[K]);
        printPath(parents, K);
    }

    private static void printPath(int[] parents, int K) {
        int i = K;
        StringBuilder path = new StringBuilder();

        while (i != -1) {
            path.insert(0, i+ " ");
            i = parents[i];
        }

        System.out.println(path.toString().trim());
    }
}
