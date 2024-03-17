package uplus;

public class Solution1 {
    public static void main(String[] args) {
        // System.out.println(solution(new int[]{3,5,7}, new int[]{4,10,12}));
        System.out.println(solution(new int[]{4,7,9,16}, new int[]{2,5,12,14,20}));
    }

    public static int solution(int[] openA, int[] closeB) {
        int totalOpenTime = 0;
        int indexA = 0;
        int indexB = 0;

        while (true) {
            while (openA[indexA] > closeB[indexB]) {
                if (indexB == closeB.length - 1) {
                    return totalOpenTime;
                }
                indexB++;
            }

            totalOpenTime += closeB[indexB] - openA[indexA];

            while (openA[indexA] < closeB[indexB]) {
                if (indexA == openA.length - 1) {
                    return totalOpenTime;
                }
                indexA++;
            }
        }
    }
}
