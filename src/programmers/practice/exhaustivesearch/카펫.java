package programmers.practice.exhaustivesearch;

import java.util.Arrays;

public class 카펫 {
    public int[] solution(int brown, int yellow) {
        int brownHeight = 3;
        int brownWidth = brownHeight; // 임시값(의미없음.. while 문에만 들어가게 세팅)

        while (brownHeight <= brownWidth) {
            brownWidth = (brown - (brownHeight * 2)) / 2 + 2;
            int yellowHeight = brownHeight - 2;
            int yellowWidth = brownWidth - 2;
            if (yellow == yellowHeight * yellowWidth) {
                return new int[]{brownWidth, brownHeight};
            }
            brownHeight++;
        }

        return null;
    }

    public static void main(String[] args) {
        카펫 solution = new 카펫();
        System.out.println(Arrays.toString(solution.solution(24, 24)));
    }
}
