package tradlinx;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution3 {
    private int maxWeight;
    private Integer[] boxes;
    private boolean[] visited;
    private boolean valid;

    public int solution(int M, int[] load) {
        maxWeight = M;
        Integer[] integers = Arrays.stream(load).boxed().toArray(Integer[]::new);
        Arrays.sort(integers, Collections.reverseOrder());
        boxes = integers;
        visited = new boolean[load.length];


        for (int i = boxes.length; i >= 1; i--) {
            valid = true;
            bt(i, 0, 0, 0, new ArrayList<>());
            if (valid) {
            }

        }

        return 0;
    }

    public void bt(int targetDepth, int depth, int start, int sum, List<Integer> indexes) {
        if (!valid) {
            return;
        }
        if (sum > maxWeight) {
            valid = false;
            return;
        }

        if (depth == targetDepth) {
            System.out.println(indexes);
            System.out.println(sum);
            return;
        }

        for (int i = start; i < boxes.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                indexes.add(i);
                bt(targetDepth, depth + 1, start + 1, sum + boxes[i], indexes);
                indexes.remove(indexes.size() - 1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        Solution3 solution3 = new Solution3();
        solution3.solution(10, new int[]{2, 3, 7, 8});
    }
}
