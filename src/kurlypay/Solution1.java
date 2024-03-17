package kurlypay;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");

        int n = Integer.parseInt(inputs[0]);
        int m = Integer.parseInt(inputs[1]);
        validate(m);

        int result = calculateMaxCount(n, m);
        System.out.print(result);
    }

    private static int calculateMaxCount(int n, int m) {
        return ((n - m) / (m - 1)) + n + 1;
    }

    private static void validate(int m) {
        // 문제에 제약사항은 없지만, 피자 한판을 주문할때 무조건 쿠폰 1개를 받음으로, 1개의 쿠폰으로 피자를 주문할수 있다면 무한대로 피자를 주문할 수
        // 있기 때문에 예외처리함..
        if (m <= 1) {
            throw new IllegalArgumentException();
        }
    }
}
