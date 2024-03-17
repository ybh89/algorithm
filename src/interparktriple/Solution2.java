package interparktriple;

public class Solution2 {
    public static void main(String[] args) {
        System.out.println(findNthDigit(11)); // 0
        System.out.println(findNthDigit(15)); // 2
    }

    //1234567891011121314
    public static int findNthDigit(int n) {
        long len = 1;          // 숫자의 길이 (1부터 시작)
        long count = 9;        // 현재 길이의 숫자 개수 (1~9는 9개)
        long start = 1;        // 현재 길이의 시작 숫자 (1부터 시작)

        // 원하는 위치 n이 어느 숫자의 범위에 있는지 파악
        while (n > len * count) {
            n -= len * count;
            len++;
            count *= 10;
            start *= 10;
        }

        // 해당 범위에서 정확한 숫자 파악
        start += (n - 1) / len;
        String s = Long.toString(start);
        return Character.getNumericValue(s.charAt((int) ((n - 1) % len)));
    }
}
