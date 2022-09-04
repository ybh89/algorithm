package coddingtest.delivery_hero;

import java.util.*;

public class Solution3 {
    private List<List<Integer>> adjacencyMatrix = new ArrayList<>();
    private Set<Integer> visited = new HashSet<>();
    private int numberOfNodes;
    
    public boolean solution(int[] A, int[] B) {
        buildAdjacencyList(A, B);
        numberOfNodes = A.length;
        return dfs(A[0]);
    }

    /**
     * case1: dfs 에서 시작 노드를 만났을 때, 모든 노드를 방문했으면 싸이클.
     * case2: dfs 에서 시작 노드를 만났을 때, 방문하지 않은 노드가 있다면 싸이클이 아님.
     * case3: dfs 가 끝났는데 시작노드를 만나지 않았으면 싸이클이 아님.
     */
    private boolean dfs(int startNode) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(startNode);
        visited.add(startNode);
        
        while (!stack.isEmpty()) {
            Integer currentNode = stack.pop();
            List<Integer> nextNodes = adjacencyMatrix.get(currentNode);

            for (Integer nextNode : nextNodes) {
                if (nextNode.equals(startNode)) {
                    if (visited.size() != numberOfNodes) {
                        return false;
                    }
                    return true;
                }

                if (!visited.contains(nextNode)) {
                    stack.push(nextNode);
                    visited.add(nextNode);
                }
            }
        }

        return false;
    }

    private void buildAdjacencyList(int[] A, int[] B) {
        for (int i = 0; i <= A.length; i++) {
            adjacencyMatrix.add(new ArrayList<>());
        }

        for (int i = 0; i < A.length; i++) {
            adjacencyMatrix.get(A[i]).add(B[i]);
        }
    }

    public static void main(String[] args) {
        Solution3 solution3 = new Solution3();
        /*int[] A = new int[]{1,3,2,4};
        int[] B = new int[]{4,1,3,2};*/

        /*int[] A = new int[]{1,2,3,4};
        int[] B = new int[]{2,1,4,3};*/

        int[] A = new int[]{1,2,1};
        int[] B = new int[]{2,3,3};
        System.out.println(solution3.solution(A, B));
    }
}
