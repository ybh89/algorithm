package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 문제 설명
 * 문자열 s에는 공백으로 구분된 숫자들이 저장되어 있습니다. str에 나타나는 숫자 중 최소값과 최대값을 찾아 이를 (최소값) (최대값)형태의 문자열을 반환하는 함수, solution을 완성하세요.
 * 예를들어 s가 1 2 3 4라면 1 4를 리턴하고, -1 -2 -3 -4라면 -4 -1을 리턴하면 됩니다.
 *
 * 제한 조건
 * s에는 둘 이상의 정수가 공백으로 구분되어 있습니다.
 * 입출력 예
 * s	return
 * 1 2 3 4	1 4
 * -1 -2 -3 -4	-4 -1
 * -1 -1	-1 -1
 */
public class 문자열의_최소값_최대값_찾기 {
    public static void main(String[] args) {
        System.out.println(solution("1 2 3 4"));
    }

    public static String solution(String s) {
        List<String> numbers = new ArrayList<>(Arrays.asList(s.split(" ")));
        int min = 0;
        int max = 0;

        if(numbers.size() > 1) {
            min = Integer.parseInt(numbers.get(0));
            max = Integer.parseInt(numbers.get(0));
        }


        for(int i=0; i<numbers.size(); i++) {
            int curNum = Integer.parseInt(numbers.get(i));
            if(curNum < min) {
                min = curNum;
            }

            if(curNum > max) {
                max = curNum;
            }
        }

        return min+" "+max;
    }
}
