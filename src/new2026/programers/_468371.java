package new2026.programers;

public class _468371 {
    public int solution(int[][] signals) {
        int[] totalSeconds = new int[signals.length];
        for (int i = 0; i < signals.length; i++) {
            totalSeconds[i] = signals[i][0] + signals[i][1] + signals[i][2];
        }

        int lcm = lcm(totalSeconds[0], totalSeconds[1]);
        for (int i = 2; i < signals.length; i++) {
            lcm = lcm(lcm, totalSeconds[i]);
        }

        int[][] map = new int[signals.length][lcm];
        for (int i = 0; i < map.length; i++) {
            map[i] = fillUntilLcm(signals[i], lcm);
        }

        for (int j = 0; j < map[0].length; j++) {
            if  (map[0][j] == 2) {
                boolean flag = true;
                for (int k = 0; k < map.length; k++) {
                    if  (map[k][j] != 2) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    return j + 1;
                }
            }
        }

        return -1;
    }

    public int[] fillUntilLcm(int[] signal, int lcm) {
        int green = signal[0];
        int yellow = signal[1];
        int red = signal[2];
        int[] result = new int[lcm];

        int n = 0;
        while (n < lcm) {
            for (int i = 0; i < green; i++) {
                result[n] = 1;
                n++;
            }
            for (int i = 0; i < yellow; i++) {
                result[n] = 2;
                n++;
            }
            for (int i = 0; i < red; i++) {
                result[n] = 3;
                n++;
            }
        }

        return result;
    }

    // 1. 최대공약수(GCD) 구하기 (유클리드 호제법)
    public int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // 2. 최소공배수(LCM) 구하기
    public int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }

    static void main() {
        _468371 solution = new _468371();
        System.out.println(solution.solution(new int[][]{{2,1,2}, {5,1,1}}));

    }
}
