package math;

import java.util.ArrayList;
import java.util.List;

/**
 * 문제 설명
 * 두 수의 최소공배수(Least Common Multiple)란 입력된 두 수의 배수 중 공통이 되는 가장 작은 숫자를 의미합니다. 예를 들어 2와 7의 최소공배수는 14가 됩니다. 정의를 확장해서, n개의 수의 최소공배수는 n 개의 수들의 배수 중 공통이 되는 가장 작은 숫자가 됩니다. n개의 숫자를 담은 배열 arr이 입력되었을 때 이 수들의 최소공배수를 반환하는 함수, solution을 완성해 주세요.
 *
 * 제한 사항
 * arr은 길이 1이상, 15이하인 배열입니다.
 * arr의 원소는 100 이하인 자연수입니다.
 * 입출력 예
 * arr	result
 * [2,6,8,14]	168
 * [1,2,3]	6
 */
public class 최소공배수구하기 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1,2,3}));
    }

    public static int solution(int[] arr) {
        if(arr.length == 1) {
            return arr[0];
        }

        int min = getMin(arr[0], arr[1]);
        for(int i=2; i<arr.length; i++) {
            min = getMin(min, arr[i]);
        }

        return min;
    }

    // 두 수의 최소 공배수를 구하기
    private static int getMin(int num1, int num2) {
        int small = Math.min(num1, num2);
        int big = Math.max(num1, num2);
        List<Integer> results = new ArrayList<>();

        for(int dividingNum=2; dividingNum<=big; dividingNum++) {
            if(small%dividingNum == 0 && big%dividingNum == 0) {
                results.add(dividingNum);
                small = small/dividingNum;
                big = big/dividingNum;
                dividingNum--;
            }
        }

        int result = 1;
        for(int i=0; i<results.size(); i++) {
            result *= results.get(i);
        }

        return result * small * big;
    }
}
