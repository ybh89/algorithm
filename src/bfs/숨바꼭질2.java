package bfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 백준 - 12851
 */
public class 숨바꼭질2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] inputs = sc.nextLine().split(" ");
        Integer N = Integer.valueOf(inputs[0]);
        Integer K = Integer.valueOf(inputs[1]);

        if(N >= K) {
            System.out.println(N-K);
            System.out.println(1);
            return;
        }

        bfs(N, K);
    }

    private static void bfs(Integer N, Integer K) {
        int count = 0;
        Queue<Integer> q = new LinkedList<>();
        int[] dist = new int[100001];
        Arrays.fill(dist, -1);

        q.offer(N);
        dist[N] = 0;

        while (!q.isEmpty()) {
            Integer curNode = q.poll();

            if(dist[K] != -1 && dist[K] < dist[curNode]) {
                break;
            }

            int[] nextPos = new int[]{curNode-1, curNode+1, curNode*2};
            for(int i=0; i<nextPos.length; i++) {
                Integer nextNode = nextPos[i];

                if(nextNode < 0 || nextNode > 100000) continue;

                if(dist[nextNode] == -1 || dist[nextNode] == dist[curNode] + 1) {
                    q.offer(nextNode);
                    dist[nextNode] = dist[curNode] + 1;

                    if(nextNode.equals(K)) {
                        count++;
                    }
                }
            }
        }

        System.out.println(dist[K]);
        System.out.println(count);
    }
}
