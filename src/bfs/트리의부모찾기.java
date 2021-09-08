package bfs;

import java.util.*;

/**
 * 백준 - 11725
 */
public class 트리의부모찾기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        List<List<Integer>> adjacencyMatrix = new ArrayList<>();
        for (int i = 0; i < N + 1; i++) {
            adjacencyMatrix.add(new ArrayList<>());
        }
        for (int i = 0; i < N - 1; i++) {
            String[] input = sc.nextLine().split(" ");
            int data1 = Integer.parseInt(input[0]);
            int data2 = Integer.parseInt(input[1]);
            adjacencyMatrix.get(data1).add(data2);
            adjacencyMatrix.get(data2).add(data1);
        }
        Integer[] parents = bfs(adjacencyMatrix, N);
        for (int i = 2; i < parents.length; i++) {
            System.out.println(parents[i]);
        }
    }

    private static Integer[] bfs(List<List<Integer>> adjacencyMatrix, int N) {
        Integer[] parents = new Integer[N + 1];
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(1);
        parents[1] = -1;

        while (!queue.isEmpty()) {
            Integer currentVertex = queue.poll();
            List<Integer> adjacencyList = adjacencyMatrix.get(currentVertex);
            for (Integer adjacencyVertex : adjacencyList) {
                if (parents[adjacencyVertex] != null) {
                    continue;
                }
                queue.offer(adjacencyVertex);
                parents[adjacencyVertex] = currentVertex;
            }
        }
        return parents;
    }
}
