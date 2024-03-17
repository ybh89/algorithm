package tradlinx;

public class Solution2 {
    public long solution(long n) {
        StringBuilder sb = new StringBuilder();

        while (n > 0) {
            if (n % 2 == 0) {
                sb.append("0");
                n = n / 2 - 1;
            } else {
                sb.append("1");
                n /= 2;
            }
        }
        return convertToDecimal(sb.reverse().toString());
    }

    private long convertToDecimal(String s) {
        long result = 0;
        long base = 1;

        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '1') {
                result += base;
            }
            base *= 3;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution2 sol = new Solution2();
        System.out.println(sol.solution(4));  // 예상 결과: 10
        System.out.println(sol.solution(11)); // 예상 결과: 31
    }
}
