package coddingtest.kmong;

import java.util.HashMap;
import java.util.Map;

/**
 * https://programmers.co.kr/tryouts/30370/result
 * 문제 설명
 * 문제 설명
 *
 * n 개의 숫자로 구성된 배열 arr 이 있습니다. 이 배열에서 가장 큰 숫자를 찾아서 그 숫자가 몇번 등장하는지 그 갯수를 구하세요
 *
 * 제한 사항
 *
 * n은 1 이상이며 100,000 보다는 작습니다
 * arr의 원소는 1 이상이며 10,000,000 보다는 작습니다
 * 입출력 예
 *
 * arr	return
 * [3, 2, 1, 3]	2
 * 입출력 예 설명
 *
 * 3이 가장 큰 숫자이며 총 2 회 등장합니다.
 */

public class Solution1 {
    public int solution(int[] arr) {
        Map<Integer, Integer> counts = new HashMap<>();
        int maxNumber = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            int currentNumber = arr[i];
            if (maxNumber < currentNumber) {
                maxNumber = currentNumber;
            }
            if (counts.containsKey(currentNumber)) {
                counts.put(currentNumber, counts.get(currentNumber) + 1);
                continue;
            }

            counts.put(currentNumber, 1);
        }

        return counts.get(maxNumber);
    }
}
