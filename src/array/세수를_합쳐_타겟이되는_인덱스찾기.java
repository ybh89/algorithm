package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 정수 배열과 target이 주어진다.
 * 정수 배열의 세 수를 합쳐 target이 되는 숫자를 골라 인덱스를 리턴하라
 * 예) {2,4,6,9} target: 17
 * 리턴 {0,2,3}
 * 제약 조건: 배열에 중복되는 숫자는 없으며 target 숫자를 만들 수 있는 조합은 하나뿐이라고 가정한다.
 */
public class 세수를_합쳐_타겟이되는_인덱스찾기 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{2,4,6,9}, 17)));
        System.out.println(Arrays.toString(solution(new int[]{-2,4,-6,9}, 11)));
        System.out.println(Arrays.toString(solution(new int[]{-2,4,-6,9}, -4)));
        System.out.println(Arrays.toString(solution(new int[]{-2,4}, -4)));
    }

    /**
     * 시간 복잡도: O(n²)
     * 공간 복잡도: O(n)
     */
    public static int[] solution(int[] numbers, int target) {
        Map<Integer, Integer> numbersMap = new HashMap<>();

        for (int i = 0; i < numbers.length; i++) {
            numbersMap.put(numbers[i], i);
        }

        for (int i = 0; i < numbers.length; i++) {
            int number1 = numbers[i];

            for (int j = i+1; j < numbers.length; j++) {
                int number2 = numbers[j];
                int numberToFind = target - number1 - number2;

                if(numbersMap.containsKey(numberToFind) && number1 != numberToFind && number2 != numberToFind) {
                    return new int[]{i, j, numbersMap.get(numberToFind)};
                }
            }
        }

        return null;
    }
}
