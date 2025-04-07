package new2025.programers;

import java.util.HashSet;
import java.util.Set;

public class 기사단워의무기136798 {
    public static void main(String[] args) {
        기사단워의무기136798 sol = new 기사단워의무기136798();
        System.out.println(sol.solution(10, 3, 2));
    }

    public int solution(int number, int limit, int power) {
        int[] counts = new int[number + 1];

        for (int i = 1; i <= number; i++) {
            counts[i] = countYak(i);
        }

        int sum = 0;
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] > limit) {
                sum += power;
                continue;
            }

            sum += counts[i];
        }

        return sum;
    }

    public int countYak(int n) {
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                set.add(i);
                set.add(n / i);
            }
        }

        return set.size();
    }
}
