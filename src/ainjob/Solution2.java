package ainjob;

public class Solution2 {
    public int solution(int n) {
        long len = 1;
        long cnt = 9;
        long start = 1;

        while (n > len * cnt) {
            n -= len * cnt;
            len++;
            cnt *= 10;
            start *= 10;
        }

        start += (n - 1) / len;
        String s = Long.toString(start);
        return Character.getNumericValue(s.charAt((int) ((n - 1) % len)));
    }

    public static void main(String[] args) {
        Solution2 sol = new Solution2();
        //System.out.println(sol.solution(10)); // 예상 출력: 10번째 숫자는 10이므로 1
        //System.out.println(sol.solution(11)); // 예상 출력: 11번째 숫자는 10이므로 0
        //System.out.println(sol.solution(189)); // 예상 출력: 189번째 숫자는 99이므로 9
        //System.out.println(sol.solution(190)); // 예상 출력: 190번째 숫자는 100이므로 1
        System.out.println(sol.solution(15));
    }
}
