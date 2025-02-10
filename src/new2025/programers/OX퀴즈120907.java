package new2025.programers;

import java.util.Arrays;

public class OX퀴즈120907 {
    public static void main(String[] args) {
        OX퀴즈120907 sol = new OX퀴즈120907();
        System.out.println(Arrays.toString(sol.solution(new String[]{"19 - 6 = 13", "5 + 66 = 71", "5 - 15 = 63", "3 - 1 = 2"})));
    }

    public String[] solution(String[] quiz) {
        String[] result = new String[quiz.length];
        for (int i = 0; i < quiz.length; i++) {
            String q = quiz[i];

            String[] splitQuiz = q.split(" ");
            int num1 = Integer.parseInt(splitQuiz[0]);
            int num2 = Integer.parseInt(splitQuiz[2]);
            int num3 = Integer.parseInt(splitQuiz[4]);

            if (splitQuiz[1].equals("+")) {
                if ((num1 + num2 == num3)) {
                    result[i] = "O";
                    continue;
                }
                result[i] = "X";
                continue;
            }

            if (num1 - num2 == num3) {
                result[i] = "O";
                continue;
            }

            result[i] = "X";
        }
        return result;
    }
}
