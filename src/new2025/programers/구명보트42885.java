package new2025.programers;

import java.util.Arrays;

public class 구명보트42885 {
    public static void main(String[] args) {
        구명보트42885 sol = new 구명보트42885();
        System.out.println(sol.solution(new int[]{40, 40, 200, 200, 200}, 240));
    }

    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        boolean[] visit = new boolean[people.length];
        int count = 0;

        for (int i = people.length - 1; i >= 0; i--) {
            if (visit[i]) {
                continue;
            }

            visit[i] = true;
            count++;

            int maxWeight = limit - people[i];
            int index = Arrays.binarySearch(people, maxWeight + 1);
            // 못찾으면 maxWeight 보다 작으면서 가장 큰 값의 인덱스로 치환
            if (index < 0) {
                index = -(index + 1);
            }
            index--;

            // people에 여러개 중복된 값이 있는 경우, 완료하지 않았고, maxWeight 보다 작거나 같은 값의 인덱스를 선택함.
            for (int j = index; j >= 0; j--) {
                if (!visit[j] && maxWeight >= people[j]) {
                    visit[j] = true;
                    break;
                }
            }
        }

        return count;
    }
}
