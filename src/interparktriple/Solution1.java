package interparktriple;

public class Solution1 {
    public static void main(String[] args) {
        System.out.println(trailingZeros(10)); // 2
        System.out.println(trailingZeros(25)); // 6
    }

    public static int trailingZeros(int n) {
        int count = 0;

        while (n > 0) {
            n /= 5;
            count += n;
        }

        return count;
    }
}
