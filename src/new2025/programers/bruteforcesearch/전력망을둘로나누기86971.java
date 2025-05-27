package new2025.programers.bruteforcesearch;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class 전력망을둘로나누기86971 {
    public static void main(String[] args) {
        전력망을둘로나누기86971 sol = new 전력망을둘로나누기86971();
        System.out.println(sol.solution(9, new int[][]{{1, 3}, {2, 3}, {3, 4}, {4, 5}, {4, 6}, {4, 7}, {7, 8}, {7, 9}}));
    }

    public int solution(int n, int[][] wires) {
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < wires.length; i++) {
            int[] removeWire = wires[i];
            int[][] subWires = subWires(wires, i);
            min = Math.min(min, Math.abs(countByDfs(removeWire[0], n, subWires) - countByDfs(removeWire[1], n, subWires)));
        }

        return min;
    }

    public int[][] subWires(int[][] wires, int removeIndex) {
        List<int[]> result = new ArrayList<>();
        for (int i = 0; i < wires.length; i++) {
            if (i != removeIndex) {
                result.add(wires[i]);
            }
        }

        return result.toArray(new int[0][]);
    }

    public int countByDfs(int start, int n, int[][] wires) {
        int count = 0;
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[n + 1];

        stack.push(start);

        while (!stack.isEmpty()) {
            Integer current = stack.pop();
            visited[current] = true;
            count++;

            for (int[] wire : wires) {
                if (wire[0] == current && !visited[wire[1]]) {
                    stack.push(wire[1]);
                    continue;
                }

                if (wire[1] == current && !visited[wire[0]]) {
                    stack.push(wire[0]);
                }
            }
        }
        return count;
    }
}
