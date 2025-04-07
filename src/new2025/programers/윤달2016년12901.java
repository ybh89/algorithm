package new2025.programers;

public class 윤달2016년12901 {
    public static void main(String[] args) {
        윤달2016년12901 sol = new 윤달2016년12901();
        System.out.println(sol.solution(1, 28));
    }

    public String solution(int a, int b) {
        int[] days = new int[] {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] yo = new String[] {"FRI","SAT","SUN","MON","TUE","WED","THU"};

        int day = b;
        for (int i = 1; i < a; i++) {
            day += days[i];
        }

        int count = day % 7;
        if (count == 0) {
            count = 7;
        }
        return yo[count - 1];
    }
}
