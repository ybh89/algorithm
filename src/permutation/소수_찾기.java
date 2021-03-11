package permutation;

import java.util.HashSet;
import java.util.Set;

/**
 * 문제 설명
 * 한자리 숫자가 적힌 종이 조각이 흩어져있습니다. 흩어진 종이 조각을 붙여 소수를 몇 개 만들 수 있는지 알아내려 합니다.
 *
 * 각 종이 조각에 적힌 숫자가 적힌 문자열 numbers가 주어졌을 때, 종이 조각으로 만들 수 있는 소수가 몇 개인지 return 하도록 solution 함수를 완성해주세요.
 *
 * 제한사항
 * numbers는 길이 1 이상 7 이하인 문자열입니다.
 * numbers는 0~9까지 숫자만으로 이루어져 있습니다.
 * "013"은 0, 1, 3 숫자가 적힌 종이 조각이 흩어져있다는 의미입니다.
 * 입출력 예
 * numbers	return
 * "17"	3
 * "011"	2
 * 입출력 예 설명
 * 예제 #1
 * [1, 7]으로는 소수 [7, 17, 71]를 만들 수 있습니다.
 *
 * 예제 #2
 * [0, 1, 1]으로는 소수 [11, 101]를 만들 수 있습니다.
 *
 * 11과 011은 같은 숫자로 취급합니다.
 */
public class 소수_찾기 {
    public static void main(String[] args) {
        소수_찾기 o = new 소수_찾기();
        System.out.println(o.solution("17"));
    }
    public int solution(String numbers) {
        int answer = 0;
        Set<Integer> resultNumSet = new HashSet<>();
        for(int i=1; i<=numbers.length(); i++) {
            printPermutation(i, "", numbers, new HashSet<Integer>(), resultNumSet);
        }
        return resultNumSet.size();
    }

    private void printPermutation(int depth, String result, String numbers, Set<Integer> isVisit, Set<Integer> resultNumSet) {
        //종료
        if(depth == 0) {
            int resultNum = Integer.parseInt(result);
            if(isPrimeNumber(resultNum)) {
                resultNumSet.add(resultNum);
            }
            return;
        }

        //프로세스
        for(int i=0; i<numbers.length(); i++) {
            if(!isVisit.contains(i)) {
                isVisit.add(i);
                printPermutation(depth-1, result+numbers.charAt(i), numbers, isVisit, resultNumSet);
                isVisit.remove(i);
            }
        }
    }

    private boolean isPrimeNumber(int number) {
        if(number < 2) {
            return false;
        }

        for(int i=2; i<number; i++) {
            if(number%i == 0) {
                return false;
            }
        }

        return true;
    }
}
