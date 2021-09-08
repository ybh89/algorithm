package dfs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 * 백준 - 2606
 */
public class 바이러스 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int computerNumber = Integer.parseInt(sc.nextLine());
        int lineNumber = Integer.parseInt(sc.nextLine());
        List<List<Integer>> adjacencyMatrix = new ArrayList<>();
        for (int i = 0; i < computerNumber + 1; i++) {
            adjacencyMatrix.add(new ArrayList<>());
        }
        for (int i = 0; i < lineNumber; i++) {
            String[] input = sc.nextLine().split(" ");
            adjacencyMatrix.get(Integer.valueOf(input[0])).add(Integer.valueOf(input[1]));
            adjacencyMatrix.get(Integer.valueOf(input[1])).add(Integer.valueOf(input[0]));
        }

        int count = dfs(adjacencyMatrix, computerNumber);
        System.out.println(count);
    }

    private static int dfs(List<List<Integer>> adjacencyMatrix, int computerNumber) {
        int count = 0;
        boolean[] visited = new boolean[computerNumber + 1];
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        visited[1] = true;

        while (!stack.isEmpty()) {
            Integer currentComputer = stack.pop();
            List<Integer> connectedComputers = adjacencyMatrix.get(currentComputer);
            for (Integer connectedComputer : connectedComputers) {
                if (visited[connectedComputer]) {
                    continue;
                }
                stack.push(connectedComputer);
                visited[connectedComputer] = true;
                count++;
            }
        }
        return count;
    }
}
