package ignite;

public class Solution1 {
    public int solution(String S) {
        int max = 0;

        for (int i = 0; i < S.length() - 1; i++) {
            for (int j = i + 2; j < S.length() - 1; j++) {
                int currentSum = Integer.parseInt(S.substring(i, i + 2)) + Integer.parseInt(S.substring(j, j + 2));
                max = Math.max(max, currentSum);
            }
        }

        return max;
    }

    public static void main(String[] args) {
        Solution1 sol = new Solution1();

        System.out.println(sol.solution("43798"));  // 141
        System.out.println(sol.solution("00101"));  // 10
        System.out.println(sol.solution("0332331"));  // 66
        System.out.println(sol.solution("00331"));  // 34
    }
}
