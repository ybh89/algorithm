package bfs;

import java.util.*;
import java.util.stream.Collectors;

public class BaekJoon1260 {
    private static List<List<Integer>> lines = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] inputs = scanner.nextLine().split(" ");
        int n = Integer.parseInt(inputs[0]);
        int m = Integer.parseInt(inputs[1]);
        int v = Integer.parseInt(inputs[2]);

        for (int i = 0; i <= n; i++) {
            lines.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            String[] line = scanner.nextLine().split(" ");
            int start = Integer.parseInt(line[0]);
            int end = Integer.parseInt(line[1]);
            lines.get(start).add(end);
            lines.get(end).add(start);
        }

        for (int i = 0; i < lines.size(); i++) {
            List<Integer> sorted = lines.get(i).stream()
                    .sorted()
                    .collect(Collectors.toList());

            lines.set(i, sorted);
        }

        // System.out.println(dfsByStack(v));
        dfsByRecursion(v);
        System.out.println(result);
        System.out.println(bfs(v));
    }

    private static List<Integer> dfsByStack(int start) {
        Stack<Integer> stack = new Stack<>();
        Set<Integer> visited = new HashSet<>();
        List<Integer> result = new ArrayList<>();
        stack.push(start);

        while (!stack.isEmpty()) {
            Integer currentNode = stack.pop();
            if (!visited.contains(currentNode)) {
                visited.add(currentNode);
                result.add(currentNode);

                for (Integer nextNode : lines.get(currentNode)) {
                    if (!visited.contains(nextNode)) {
                        stack.push(nextNode);
                    }
                }
            }
        }

        return result;
    }

    private static List<Integer> result = new ArrayList<>();
    private static Set<Integer> visited = new HashSet<>();

    private static void dfsByRecursion(int currentNode) {
        if (!visited.contains(currentNode)) {
            visited.add(currentNode);
            result.add(currentNode);
        }

        for (Integer nextNode : lines.get(currentNode)) {
            if (!visited.contains(nextNode)) {
                dfsByRecursion(nextNode);
            }
        }
    }

    private static List<Integer> bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        List<Integer> result = new ArrayList<>();
        queue.offer(start);

        while (!queue.isEmpty()) {
            Integer currentNode = queue.poll();
            if (!visited.contains(currentNode)) {
                visited.add(currentNode);
                result.add(currentNode);

                for (Integer nextNode : lines.get(currentNode)) {
                    if (!visited.contains(nextNode)) {
                        queue.add(nextNode);
                    }
                }
            }
        }

        return result;
    }

}
