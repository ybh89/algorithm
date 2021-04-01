package bfs;

import java.util.*;

/**
 * 백준 - 1697
 */
public class 숨바꼭질 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] inputs = sc.nextLine().split(" ");
        Integer N = Integer.valueOf(inputs[0]);
        Integer K = Integer.valueOf(inputs[1]);

        System.out.println(bfs(N, K));
    }

    private static int bfs(Integer N, Integer K) {
        Queue<Integer> q = new LinkedList<>();
        int[] dist = new int[100001];
        Arrays.fill(dist, -1);

        q.offer(N);
        dist[N] = 0;

        while (!q.isEmpty()) {
            Integer curNode = q.poll();

            int[] nextPos = new int[]{curNode-1, curNode+1, curNode*2};
            for(int i=0; i<nextPos.length; i++) {
                Integer nextNode = nextPos[i];
                if(0 <= nextNode && nextNode <= 100000 && dist[nextNode] == -1) {
                    q.offer(nextNode);
                    dist[nextNode] = dist[curNode] + 1;

                    if(nextNode == K) {
                        q.clear();
                        break;
                    }
                }
            }
        }

        return dist[K];
    }
}
