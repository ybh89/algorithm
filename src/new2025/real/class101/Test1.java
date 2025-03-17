package new2025.real.class101;

public class Test1 {
    public static void main(String[] args) {
        Test1 test1 = new Test1();
        //System.out.println(test1.solution(7, 42, new int[]{6, 42, 11, 7, 1, 42}));
        //System.out.println(test1.solution(6, 13, new int[]{13,13,1,6}));
        //System.out.println(test1.solution(100, 63, new int[]{100,63,1,6,2,13}));
        //System.out.println(test1.solution(1000000000,1000000000, new int[]{1}));
    }

    int solution(int X, int Y, int[] A) {
        int N = A.length;
        int result = -1;
        int nX = 0;
        int nY = 0;
        for (int i = 0; i < N; i++) {
            if (A[i] == X)
                nX += 1;
            if (A[i] == Y)
                nY += 1;
            if ((nX > 0 || nY > 0) && nX == nY)
                result = i;
        }
        return result;
    }
}
