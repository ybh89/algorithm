package new2025.programers;

public class 카드뭉치159994 {
    public static void main(String[] args) {
        카드뭉치159994 sol = new 카드뭉치159994();
        System.out.println(sol.solution(new String[]{"i", "drink", "water"}, new String[]{"want", "to"}, new String[]{"i", "want", "to", "drink", "water"}));
    }

    public String solution(String[] cards1, String[] cards2, String[] goal) {
        int point1 = 0;
        int point2 = 0;
        int count = 0;
        for (int i = 0; i < goal.length; i++) {
            String word = goal[i];
            String word1 = cards1[point1];
            String word2 = cards2[point2];

            if (word.equals(word1)) {
                if (point1 < cards1.length - 1) {
                    point1++;
                }
                count++;
                continue;
            }

            if (word.equals(word2)) {
                if (point2 < cards2.length - 1) {
                    point2++;
                }
                count++;
                continue;
            }

            if (point1 < cards1.length - 1) {
                point1++;
            }
            if (point2 < cards2.length - 1) {
                point2++;
            }
        }

        if (count == goal.length) {
            return "Yes";
        }

        return "No";
    }
}
