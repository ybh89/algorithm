package new2025.programers;

public class 멀리뛰기12914 {
    private int N;
    private int count;

    public static void main(String[] args) {
        멀리뛰기12914 solution = new 멀리뛰기12914();
        System.out.println(solution.solution4(1));
    }

    // DP - top-down memoization O(N)
    public long solution4(int n) {
        int[] memory = new int[n+1];
        return recursive(n, memory);
    }

    public int recursive(int n, int[] memory) {
        if (memory[n] > 0) {
            return memory[n] % 1234567;
        }
        if (n <= 2) {
            return n;
        }

        memory[n] = (recursive(n - 1, memory) % 1234567) + (recursive(n - 2, memory) % 1234567);

        return memory[n] % 1234567;
    }

    // DP - bottom-up tabulation O(n)
    public long solution3(int n) {
        if (n <= 2) {
            return n;
        }

        int pre1 = 1;
        int pre2 = 2;
        int current = 0;

        for (int i = 3; i <= n; i++) {
            current = (pre1% 1234567) + (pre2% 1234567);
            pre1 = pre2;
            pre2 = current;
        }
        return current % 1234567;
    }

    // 피보나치 수열 - 재귀 O(2^n)
    public long solution2(int n) {
        if (n == 1) return 1 % 1234567;
        if (n == 2) return 2 % 1234567;
        return (solution2(n - 1) + solution2(n - 2)) % 1234567;
    }

    // 완전 탐색 - 재귀 O(2^n)
    public long solution1(int n) {
        N = n;
        visit(1, 0);
        visit(2, 0);
        return count % 1234567;
    }

    public void visit(int visitNode, int sum) {
        sum += visitNode;

        if (sum == N) {
            count++;
            return;
        }

        if (sum > N) {
            return;
        }

        visit(1, sum);
        visit(2, sum);
    }
}
