package programmers.practice.dfsbfs;

import java.util.ArrayDeque;
import java.util.Queue;

public class 네트워크 {

    public int solution(int n, int[][] computers) {
        int count = 0;

        boolean[] visited = new boolean[n];

        // bfs
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                bfs(computers, visited, i);
                count++;
            }
        }
        return count;
    }

    private void bfs(int[][] computers, boolean[] visited, int startComputer) {
        Queue<Integer> queue = new ArrayDeque<>();

        queue.offer(startComputer);
        visited[startComputer] = true;

        while (!queue.isEmpty()) {
            Integer currentComputer = queue.poll();
            int[] connectedComputers = computers[currentComputer];
            for (int i = 0; i < connectedComputers.length; i++) {
                if (connectedComputers[i] == 1) {
                    int connectedComputer = i;
                    if (!visited[connectedComputer]) {
                        queue.offer(connectedComputer);
                        visited[connectedComputer] = true;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        네트워크 solution = new 네트워크();
        int n = 3;
        int[][] computers = new int[][]{{1, 0, 0},{0, 1, 1},{0, 1, 1}};
        System.out.println(solution.solution(n, computers));
    }
}
