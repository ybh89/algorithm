package dijkstra;

import java.util.*;

/**
 * 백준 - 13549
 */
public class 숨바꼭질3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] inputs = sc.nextLine().split(" ");
        int N = Integer.parseInt(inputs[0]);
        int K = Integer.parseInt(inputs[1]);

        System.out.println(dijkstra(N, K));
    }

    private static int dijkstra(int N, int K) {
        Queue<Node> q = new PriorityQueue<>();
        int[] dist = new int[100001];
        Arrays.fill(dist, Integer.MAX_VALUE);

        Node startNode = new Node();
        startNode.nodeNum = N;
        startNode.second = 0;
        q.offer(startNode);
        dist[N] = 0;

        while (!q.isEmpty()) {
            Node curNode = q.poll();

            if(dist[curNode.nodeNum] < curNode.second) continue;

            int[] nextPos = new int[]{curNode.nodeNum - 1, curNode.nodeNum + 1, curNode.nodeNum * 2};
            for(int i=0; i<nextPos.length; i++) {
                if(0 > nextPos[i] || nextPos[i] > 100000) continue;

                Node nextNode = new Node();
                nextNode.nodeNum = nextPos[i];
                nextNode.second = (i == 0 || i == 1) ? 1 : 0;

                if(dist[nextNode.nodeNum] > dist[curNode.nodeNum] + nextNode.second) {
                    q.offer(nextNode);
                    dist[nextNode.nodeNum] = dist[curNode.nodeNum] + nextNode.second;
                }
            }
        }

        return dist[K];
    }

    private static class Node implements Comparable<Node>{
        private int nodeNum;
        private int second;

        @Override
        public int compareTo(Node o) {
            int ret = this.second - o.second;
            if(ret == 0) {
                ret = this.nodeNum - o.nodeNum;
            }
            return ret;
        }
    }
}
