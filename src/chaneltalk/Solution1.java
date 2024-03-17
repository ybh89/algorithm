package chaneltalk;

public class Solution1 {
    public static void main(String[] args) {
        System.out.println(solution(3, 4, 20));
    }

    public static int solution(int mod1, int mod2, int max_range) {
        return (max_range / mod1) - (max_range / lcm(mod1, mod2));
    }

    // 최대공약수
    public static int gcd(int mod1, int mod2) {
        while (mod2 != 0) {
            int temp = mod2;
            mod2 = mod1 % mod2;
            mod1 = temp;
        }
        return mod1;
    }

    // 최소공배수
    public static int lcm(int mod1, int mod2) {
        return (mod1 * mod2) / gcd(mod1, mod2);
    }
}
