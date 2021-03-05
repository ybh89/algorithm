package permutation;

import java.util.*;

/**
 * 백준 - 10451
 * 문제
 *
 *
 * 1부터 N까지 정수 N개로 이루어진 순열을 나타내는 방법은 여러 가지가 있다. 예를 들어, 8개의 수로 이루어진 순열 (3, 2, 7, 8, 1, 4, 5, 6)을 배열을 이용해 표현하면  															  와 같다. 또는, Figure 1과 같이 방향 그래프로 나타낼 수도 있다.
 *
 * 순열을 배열을 이용해  									  로 나타냈다면, i에서 πi로 간선을 이어 그래프로 만들 수 있다.
 *
 * Figure 1에 나와있는 것 처럼, 순열 그래프 (3, 2, 7, 8, 1, 4, 5, 6) 에는 총 3개의 사이클이 있다. 이러한 사이클을 "순열 사이클" 이라고 한다.
 *
 * N개의 정수로 이루어진 순열이 주어졌을 때, 순열 사이클의 개수를 구하는 프로그램을 작성하시오.
 *
 * 입력
 * 첫째 줄에 테스트 케이스의 개수 T가 주어진다. 각 테스트 케이스의 첫째 줄에는 순열의 크기 N (2 ≤ N ≤ 1,000)이 주어진다. 둘째 줄에는 순열이 주어지며, 각 정수는 공백으로 구분되어 있다.
 *
 * 출력
 * 각 테스트 케이스마다, 입력으로 주어진 순열에 존재하는 순열 사이클의 개수를 출력한다.
 *
 * 예제 입력 1
 * 2
 * 8
 * 3 2 7 8 1 4 5 6
 * 10
 * 2 1 3 4 5 6 7 9 10 8
 * 예제 출력 1
 * 3
 * 7
 */
public class 순열_사이클 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());
        List<Integer> results = new ArrayList<>();

        for(int t=0; t<T; t++) {
            int N = Integer.parseInt(sc.nextLine());
            List<String> nodes = new ArrayList<>();
            nodes.add(0, null);
            List<String> temp = new ArrayList<>(Arrays.asList(sc.nextLine().split(" ")));
            nodes.addAll(temp);
            results.add(countCycle(nodes));
        }

        for(int result : results) {
            System.out.println(result);
        }
    }

    public static int countCycle(List<String> nodes) {
        boolean[] isCycle = new boolean[nodes.size()];
        int cycleCount = 0;

        for (int i = 1; i < nodes.size(); i++) {
            // 방문한 노드가 이미 사이클일 경우 다음 노드 진행
            if(isCycle[i]) {
                continue;
            }

            //방문노드 체크 set
            Set<Integer> visitNodes = new HashSet<>();
            int curNode = i;
            //현재노드 방문처리
            visitNodes.add(i);

            //노드 순회 하면서 사이클 찾기
            while (true) {
                int nextNode = Integer.parseInt(nodes.get(curNode));

                //1.다음 노드가 없는 경우 -> 사이클이 아니다.
                if(nodes.get(nextNode) == null) {
                    break;
                }

                //2.다음 노드가 이미 사이클인 경우 -> 현재 노드도 사이클로 세팅
                if(isCycle[nextNode]) {
                    isCycle[i] = true;
                    break;
                }

                //3.다음 노드가 이미 방문했던 노드인 경우 -> 사이클임을 확정. -> 사이클로 세팅
                if(visitNodes.contains(nextNode)) {
                    for(int visitNode : visitNodes) {
                        isCycle[visitNode] = true;
                    }
                    cycleCount++;
                    break;
                }

                //4.아무 경우도 아닌 경우 다음 노드로 진행
                curNode = nextNode;
            }
        }

        return cycleCount;
    }
}
