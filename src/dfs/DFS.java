package dfs;

import java.util.*;

/**
 * 문제
 * 그래프를 DFS로 탐색한 결과와 BFS로 탐색한 결과를 출력하는 프로그램을 작성하시오. 단, 방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문하고, 더 이상 방문할 수 있는 점이 없는 경우 종료한다. 정점 번호는 1번부터 N번까지이다.
 * <p>
 * 입력
 * 첫째 줄에 정점의 개수 N(1 ≤ N ≤ 1,000), 간선의 개수 M(1 ≤ M ≤ 10,000), 탐색을 시작할 정점의 번호 V가 주어진다. 다음 M개의 줄에는 간선이 연결하는 두 정점의 번호가 주어진다. 어떤 두 정점 사이에 여러 개의 간선이 있을 수 있다. 입력으로 주어지는 간선은 양방향이다.
 * <p>
 * 출력
 * 첫째 줄에 DFS를 수행한 결과를, 그 다음 줄에는 BFS를 수행한 결과를 출력한다. V부터 방문된 점을 순서대로 출력하면 된다.
 */
public class DFS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] inputs = sc.nextLine().split(" ");
        int N = Integer.parseInt(inputs[0]);
        int M = Integer.parseInt(inputs[1]);
        int V = Integer.parseInt(inputs[2]);
        List<ArrayList<Integer>> ad = new ArrayList<>();

        for(int i=0; i<=N; i++) {
            ad.add(new ArrayList<>());
        }

        for(int i=1; i<=M; i++) {
            String[] nodes = sc.nextLine().split(" ");
            int node1 = Integer.parseInt(nodes[0]);
            int node2 = Integer.parseInt(nodes[1]);

            ad.get(node1).add(node2);
            ad.get(node2).add(node1);
        }

        DFS dfs = new DFS();

        System.out.println(dfs.dfs(V, N, ad));
        System.out.println(dfs.bfs(V, N, ad));
    }

    public String dfs(int start, int total, List<ArrayList<Integer>> ad) {
        for(int i=1; i<=total; i++) {
            Collections.sort(ad.get(i));
            Collections.reverse(ad.get(i));
        }

        StringBuilder sbResult = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        boolean[] isVisit = new boolean[total+1];

        stack.push(start);

        while (!stack.isEmpty()) {
            int curNode = stack.pop();
            if(!isVisit[curNode]) {
                isVisit[curNode] = true;
                sbResult.append(curNode+" ");

                for(int adNode : ad.get(curNode)) {
                    if(!isVisit[adNode]) {
                        stack.push(adNode);
                    }
                }
            }
        }

        return sbResult.toString().trim();
    }

    public String bfs(int start, int total, List<ArrayList<Integer>> ad) {
        for(int i=1; i<=total; i++) {
            Collections.sort(ad.get(i));
        }

        StringBuilder sbResult = new StringBuilder();
        boolean[] isVisit = new boolean[total+1];
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);

        while (!q.isEmpty()) {
            int curNode = q.poll();
            if(!isVisit[curNode]) {
                isVisit[curNode] = true;
                sbResult.append(curNode + " ");

                for(int adNode : ad.get(curNode)) {
                    q.offer(adNode);
                }
            }
        }

        return sbResult.toString().trim();
    }
}
