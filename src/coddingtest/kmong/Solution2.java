package coddingtest.kmong;

import java.util.LinkedList;

/**
 * https://programmers.co.kr/tryouts/30370/result
 * 문제 설명
 * 문제 설명
 * 크몽 서비스 개발팀에서 일하는 미영씨는 매일 많은 일감을 처리합니다. 미영씨는 여러 일감들을 들어온 순서대로 작업하지 않습니다.
 * 중요한 일을 먼저 처리해야만 고객에게 의미 있는 기능을 빠르게 출시할 수 있다는 사실을 알기 때문입니다.
 * 이런 이유로 미영씨는 제품 백로그에서 아래와 같은 방식으로 일감을 처리합니다.
 *
 * 1. 제품 백로그에서 가장 위에 있는 일감(T)을 선택합니다.
 * 2. 나머지 백로그 일감 목록에서 T보다 중요도가 높은 일감이 있다면 T를 백록그의 가장 아래에 넣습니다
 * 3. 만약 T보다 중요도가 높은 일감이 없다면 T를 작업합니다.
 * 예를 들어서 5개의 일감(A, B, C, D, E)가 순서대로 백로그에 있고, 중요도가 각각 (2, 1, 3, 2, 2)라면 C D E A B 순서대로 작업하게 됩니다.
 *
 * 제품 책임자로서 나는 내가 요청한 일감이 몇 번쨰로 처리될 수 있을지 궁금합니다. 위의 경우라면 일감 C는 1번째로, 일감 B는 5번째로 처리됩니다.
 *
 * 현재 제품 백로그에 있는 일감의 중요도가 순서대로 담긴 배열 priorities 와 내가 작업을 요청함 일감이 현재 일감 목록에서 몇 번째인지를 알려주는 location이 매개변수로 주어질 때, 내가 요청한 일감이 몇 번째로 처리되는지 return하도록 solution 함수를 작성해 주세요.
 *
 * 제한 사항
 *
 * 현재 제품 백록그 일감 목록에는 1개 이상 100개 이하의 일감이 있습니다
 * 일감의 중요도는 1 ~ 9로 표현하며 숫자가 클수록 중요한 일감입니다
 * location은 0 이상 (현재 일감목록에 있는 일감 수 -1) 이하의 값을 가지며, 일감 목록의 가장 앞에 있으면 0, 두 번째에 있으면 1로 표현합니다.
 * 입출력 예
 *
 * priorities	location	return
 * [2, 1, 3, 2, 2]	2	1
 * [3, 9, 5, 3, 2, 2]	0	4
 * 입출력 예 설명
 *
 * 예제 #1
 *
 * 2번째 위치에 있는 3은 제일 처음 처리됩니다.
 *
 * 예제 #2
 *
 * 6개의 일감(A, B, C, D, E, F)가 백로그 일감 목록에 있고 중요도가 3 9 5 3 2 2 이므로 B C D A E F 순으로 처리됩니다
 */

public class Solution2 {
    public int solution(int[] priorities, int location) {
        LinkedList<Task> tasks = new LinkedList<>();
        int count = 0;

        for (int i = 0; i < priorities.length; i++) {
            Task task = new Task(i, priorities[i]);
            tasks.offer(task);
        }

        while (!tasks.isEmpty()) {
            // 1. 일감 목록의 첫번째 일감을 꺼낸다.
            Task firstTask = tasks.poll();
            boolean isMaxPriority = true;

            // 2. 첫번째 일감의 중요도와 나머지 일감 목록의 중요도를 비교하여, 중요도가 높은 일감이 있으면 비교한 일감까지 전부 일감 목록 뒤로 보낸다.
            for (int i = 0; i < tasks.size(); i++) {
                if (firstTask.compareTo(tasks.get(i)) < 0) {
                    isMaxPriority = false;
                    tasks.offer(firstTask);
                    for (int j = 0; j < i; j++) {
                        tasks.offer(tasks.poll());
                    }
                    break;
                }
            }

            // 3. 첫번째 일감의 중요도가 가장 큰 것이 아니라면 반복한다.
            if (!isMaxPriority) {
                continue;
            }

            // 4. 첫번째 일감의 중요도가 가장 크면 위치를 확인해보고 확인하고자 하는 위치이면 종료한다.
            count++;
            if (firstTask.getLocation() == location) {
                break;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        System.out.println(solution2.solution(new int[]{3, 9, 5, 3, 2, 2}, 0));
    }

    class Task implements Comparable<Task> {
        private int location;
        private int priority;

        public Task(int location, int priority) {
            this.location = location;
            this.priority = priority;
        }

        public int getLocation() {
            return location;
        }

        public int getPriority() {
            return priority;
        }

        @Override
        public int compareTo(Task o) {
            return this.priority - o.priority;
        }
    }
}
