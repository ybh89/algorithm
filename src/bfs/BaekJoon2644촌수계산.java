package bfs;

import java.util.*;

public class BaekJoon2644촌수계산 {
    private static List<List<Integer>> lines = new ArrayList<>();
    private static int[] distance;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String[] inputs = scanner.nextLine().split(" ");
        int start = Integer.parseInt(inputs[0]);
        int end = Integer.parseInt(inputs[1]);
        int l = Integer.parseInt(scanner.nextLine());
        distance = new int[n + 1];

        for (int i = 0; i <= n ; i++) {
            lines.add(new ArrayList<>());
        }

        for (int i = 0; i < l; i++) {
            String[] input = scanner.nextLine().split(" ");
            int node1 = Integer.parseInt(input[0]);
            int node2 = Integer.parseInt(input[1]);
            lines.get(node1).add(node2);
            lines.get(node2).add(node1);
        }

        System.out.println(bfs(start, end));
    }

    private static int bfs(int start, int end) {
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        distance[start] = 0;

        while (!queue.isEmpty()) {
            Integer currentNode = queue.poll();
            if (!visited.contains(currentNode)) {
                visited.add(currentNode);

                for (Integer nextNode : lines.get(currentNode)) {
                    if (!visited.contains(nextNode)) {
                        queue.offer(nextNode);
                        distance[nextNode] = distance[currentNode] + 1;
                        if (nextNode.equals(end)) {
                            return distance[nextNode];
                        }
                    }
                }
            }
        }

        return -1;
    }
}
