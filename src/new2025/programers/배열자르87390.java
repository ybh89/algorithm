package new2025.programers;

import java.util.Arrays;

public class 배열자르87390 {
    public static void main(String[] args) {
        배열자르87390 sol = new 배열자르87390();
        System.out.println(Arrays.toString(sol.solution(3,2,5)));
    }

    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int)(right - left) + 1];

        for (int i = 0; i < answer.length; i++) {
            answer[i] = calculate(n, left);
            left++;
        }
        return answer;
    }

    public int calculate(int n, long x1) {
        int y = (int)(x1 % n) + 1;
        int x = (int)(x1 / n) + 1;

        return Math.max(x, y);
    }
}
