package brute_force;

import java.util.*;
import java.util.stream.IntStream;

/**
 * 문제 설명
 * 수포자는 수학을 포기한 사람의 준말입니다. 수포자 삼인방은 모의고사에 수학 문제를 전부 찍으려 합니다. 수포자는 1번 문제부터 마지막 문제까지 다음과 같이 찍습니다.
 *
 * 1번 수포자가 찍는 방식: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ...
 * 2번 수포자가 찍는 방식: 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, ...
 * 3번 수포자가 찍는 방식: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...
 *
 * 1번 문제부터 마지막 문제까지의 정답이 순서대로 들은 배열 answers가 주어졌을 때, 가장 많은 문제를 맞힌 사람이 누구인지 배열에 담아 return 하도록 solution 함수를 작성해주세요.
 *
 * 제한 조건
 * 시험은 최대 10,000 문제로 구성되어있습니다.
 * 문제의 정답은 1, 2, 3, 4, 5중 하나입니다.
 * 가장 높은 점수를 받은 사람이 여럿일 경우, return하는 값을 오름차순 정렬해주세요.
 * 입출력 예
 * answers	return
 * [1,2,3,4,5]	[1]
 * [1,3,2,4,2]	[1,2,3]
 * 입출력 예 설명
 * 입출력 예 #1
 *
 * 수포자 1은 모든 문제를 맞혔습니다.
 * 수포자 2는 모든 문제를 틀렸습니다.
 * 수포자 3은 모든 문제를 틀렸습니다.
 * 따라서 가장 문제를 많이 맞힌 사람은 수포자 1입니다.
 *
 * 입출력 예 #2
 *
 * 모든 사람이 2문제씩을 맞췄습니다.
 */
public class 모의고사 {
    public static void main(String[] args) {
        모의고사 o = new 모의고사();
        System.out.println(Arrays.toString(o.solution(new int[]{4})));
    }
    public int[] solution(int[] answers) {
        final int[] giveUp1 = new int[]{1, 2, 3, 4, 5};
        final int[] giveUp2 = new int[]{2, 1, 2, 3, 2, 4, 2, 5};
        final int[] giveUp3 = new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        Map<Integer, Integer> map = new HashMap<>();
        int am1 = 0;
        int am2 = 0;
        int am3 = 0;

        for(int i=0; i<answers.length; i++) {
            if((i == 0 && answers[0] == giveUp1[0]) || answers[i] == giveUp1[i%giveUp1.length]) {
                am1++;
            }
            if((i == 0 && answers[0] == giveUp2[0]) || answers[i] == giveUp2[i%giveUp2.length]) {
                am2++;
            }
            if((i == 0 && answers[0] == giveUp3[0]) || answers[i] == giveUp3[i%giveUp3.length]) {
                am3++;
            }
        }
        if(am1 != 0) map.put(1, am1);
        if(am2 != 0) map.put(2, am2);
        if(am3 != 0) map.put(3, am3);

        List<Integer> maxKey = new ArrayList<>();
        int maxValue = -1;

        for(Integer key : map.keySet()) {
            if(map.get(key) > maxValue) {
                maxKey = new ArrayList<>();
                maxKey.add(key);
                maxValue = map.get(key);
            } else if(map.get(key) == maxValue) {
                maxKey.add(key);
            }
        }

        return maxKey.stream().mapToInt(i -> i).toArray();
    }
}
