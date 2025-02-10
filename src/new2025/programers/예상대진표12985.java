package new2025.programers;

public class 예상대진표12985 {
    public static void main(String[] args) {
        예상대진표12985 sol = new 예상대진표12985();
        System.out.println(sol.solution(8, 1, 2));
    }

    public int solution(int n, int a, int b)
    {
        int count = 0;
        int nextA = a;
        int nextB = b;
        while (true) {
            nextA = nextNumber(nextA);
            nextB = nextNumber(nextB);
            count++;
            if (nextA == nextB) {
                break;
            }
        }

        return count;
    }

    public int nextNumber(int n) {
        if (n == 1) {
            return 1;
        }
        if (n % 2 == 0) {
            return n/2;
        }
        return (n+1)/2;
    }
}
