package new2025.programers;

public class 점프와순간이동12980 {
    private int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        점프와순간이동12980 sol = new 점프와순간이동12980();
        System.out.println(sol.solution(5000));
    }

    public int solution(int n) {
        go(0, true, n, 0);
        go(0, false, n, 0);
        return min;
    }

    public void go(int distance, boolean flag, int n, int count) {
        if (n < distance) {
            return;
        }

        if (n == distance) {
            min = Math.min(min, count);
            return;
        }

        if (flag && distance != 0) {
            go(distance * 2, true, n, count);
            go(distance * 2, false, n, count);
        } else {
            go(distance + 1, true, n, count + 1);
            go(distance + 1, false, n, count + 1);
        }
    }
}
