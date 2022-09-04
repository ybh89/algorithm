package coddingtest.bucketplace;

public class Solution1 {
    public long solution(int N, int[] height) {
        if (N < 3) {
            return N - 1;
        }

        long count = N - 1;

        for (int i = 0; i < height.length - 2; i++) {
            int startHeight = height[i];

            for (int j = i + 2; j < height.length; j++) {
                int endHeight = height[j];

                for (int p = i + 1; p < j; p++) {
                    if (height[p] >= startHeight || height[p] > endHeight) {
                        break;
                    }
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        System.out.println(solution1.solution(5, new int[]{4,3,2,3,5}));
    }
}
