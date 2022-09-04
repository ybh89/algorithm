package coddingtest.kmong;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://programmers.co.kr/tryouts/30370/result
 * 문제 설명
 * 문제 설명
 *
 * 배달을 전문으로 하는 음식점이 있습니다. 어느 날 운좋게 주문이 많이 들어왔습니다.
 * 하지만 너무 많은 주문 때문에 1개의 음식을 배달하지 못했습니다.
 *
 * 주문이 들어온 음식 이름이 담긴 배열 foods와 배달이 완료된 음식 이름이 담긴 배열 delivered가 주어질 때, 배달하지 못한 음식의 이름을 반환하는 solution 함수를 작성해주세요
 *
 * 제한 사항
 *
 * 그 날 들어온 음식 주문 수는 1개 이상 100,000개 이하입니다
 * delivered 배열의 길이는 foods 배열의 길이보다 1만큼 작습니다
 * 음식의 이름은 1개 이상, 20개 이하의 알파벳 소문자로 이뤄져 있으며, 공백은 없습니다.
 * 입출력 예
 *
 * foods	delivered	return
 * ["pizza", "coke", "noodles"]	["pizza", "noodles"]	"coke"
 * ["noodles", "pizza", "steak", "pizza", "salad"]	["steak", "noodles", "pizza", "pizza"]	"salad"
 */

public class Solution3 {
    public String solution(String[] foods, String[] delivered) {
        Map<String, Integer> deliveredFoods = new HashMap<>();
        String missed = "";

        // 1. 배달된 음식의 개수를 정리한다.
        Arrays.stream(delivered).forEach(food -> {
            if (deliveredFoods.containsKey(food)) {
                deliveredFoods.put(food, deliveredFoods.get(food) + 1);
            } else {
                deliveredFoods.put(food, 1);
            }
        });

        // 2. 주문 음식이 배달이 됐으면, 배달된 음식의 개수를 줄이고 개수가 0이면 배달된 음식 개수 목록에서 삭제한다. 배달되지 않은 음식을 발견하면 종료
        for (int i = 0; i < foods.length; i++) {
            String food = foods[i];
            if (deliveredFoods.containsKey(food)) {
                Integer count = deliveredFoods.get(foods[i]) - 1;
                if (count == 0) {
                    deliveredFoods.remove(foods[i]);
                    continue;
                }
                deliveredFoods.put(foods[i], count);
                continue;
            }

            missed = food;
            break;
        }

        return missed;
    }

    public static void main(String[] args) {
        Solution3 solution = new Solution3();
        String[] foods = new String[]{"noodles", "pizza", "steak", "pizza", "salad"};
        String[] delivered = new String[]{"steak", "noodles", "pizza", "pizza"};
        System.out.println(solution.solution(foods, delivered));
    }
}
