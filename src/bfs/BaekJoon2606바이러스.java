package bfs;

import java.util.*;

public class BaekJoon2606바이러스 {
    private static List<List<Integer>> lines = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int l = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i <= n; i++) {
            lines.add(new ArrayList<>());
        }

        for (int i = 0; i < l; i++) {
            String[] line = scanner.nextLine().split(" ");
            int start = Integer.parseInt(line[0]);
            int end = Integer.parseInt(line[1]);
            
            lines.get(start).add(end);
            lines.get(end).add(start);
        }

        System.out.println(dfs(1));
    }

    private static int dfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.offer(start);

        while (!queue.isEmpty()) {
            Integer currentNode = queue.poll();
            if (!visited.contains(currentNode)) {
                visited.add(currentNode);

                for (Integer nextNode : lines.get(currentNode)) {
                    if (!visited.contains(nextNode)) {
                        queue.offer(nextNode);
                    }
                }
            }
        }

        return visited.size() - 1;
    }
}
