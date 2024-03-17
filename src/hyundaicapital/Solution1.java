package hyundaicapital;

public class Solution1 {
    public static void main(String[] args) {
        System.out.println(solution(14, 2, new int[][]{{5,1}, {2,7}, {1,14}}));
    }

    public static int solution(int n, int m, int[][] features) {
        int min = Integer.MAX_VALUE;
        for (int[] feature : features) {
            min = Math.min((n * feature[0]) + (m * feature[1]), min);
        }
        return min;
    }
}
