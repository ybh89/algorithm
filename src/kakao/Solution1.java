package kakao;

import java.io.IOException;
import java.util.List;


class Result1 {

    /*
     * Complete the 'solution' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static int solution(List<String> ingredients, int startIndex, String target) {
        // Write your code here
        int cost = 0;
        int leftIndex = startIndex;
        int rightIndex = startIndex;

        while (isNotTarget(ingredients, target, leftIndex) && isNotTarget(ingredients, target, rightIndex)) {
            leftIndex--;
            rightIndex++;
            cost++;

            if (isEndOfLeft(leftIndex)) {
                leftIndex = ingredients.size() - 1;
            }
            if (isEndOfRight(ingredients, rightIndex)) {
                rightIndex = 0;
            }
        }

        return cost;
    }

    private static boolean isEndOfRight(List<String> ingredients, int rightIndex) {
        return rightIndex == ingredients.size();
    }

    private static boolean isEndOfLeft(int leftIndex) {
        return leftIndex == -1;
    }

    private static boolean isNotTarget(List<String> ingredients, String target, int index) {
        return !target.equals(ingredients.get(index));
    }
}

public class Solution1 {
    public static void main(String[] args) throws IOException {
        List<String> ingredients = List.of("linguine", "pepper", "ketchup", "mushroom");
        int startIndex = 0;
        String target = "mushroom";

        System.out.println(Result1.solution(ingredients, startIndex, target));
    }
}
