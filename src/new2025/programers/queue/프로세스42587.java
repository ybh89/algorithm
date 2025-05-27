package new2025.programers.queue;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

public class 프로세스42587 {
    public static void main(String[] args) {
        프로세스42587 sol = new 프로세스42587();
        // System.out.println(sol.solution(new int[]{2, 1, 3, 2}, 2));
        System.out.println(sol.solution(new int[]{1, 1, 9, 1, 1, 1}, 0));
    }

    public int solution(int[] priorities, int location) {
        Queue<Integer> queue = new LinkedList<>();
        for (int priority : priorities) {
            queue.offer(priority);
        }

        Queue<Integer> sortedPriority = new LinkedList<>();
        Arrays.stream(priorities)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .forEach(sortedPriority::add);

        int count = 0;
        while (!sortedPriority.isEmpty()) {
            Integer task = queue.poll();

            if (!task.equals(sortedPriority.peek())) {
                queue.offer(task);
                if (location == 0) {
                    location = queue.size() - 1;
                } else {
                    location--;
                }
                continue;
            }

            count++;
            if (location == 0) {
                break;
            }
            sortedPriority.poll();
            location--;
        }

        return count;
    }
}
