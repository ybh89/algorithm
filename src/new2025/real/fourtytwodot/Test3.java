package new2025.real.fourtytwodot;

public class Test3 {
    public static void main(String[] args) {
        Test3 sol = new Test3();
        System.out.println(sol.solution(15));
    }

    public int solution(int n) {
        int length = findLength(n);
        int minusValue = minusPreLength(n, length);
        int targetNumber = startNumber(length) + ((minusValue - 1) / length);
        String targetNumberStr = Integer.toString(targetNumber);
        int indexInNumber = (minusValue - 1) % length;
        return Character.getNumericValue(targetNumberStr.charAt(indexInNumber));
    }

    public int startNumber(int length) {
        if (length == 1) {
            return 1;
        }
        StringBuilder result = new StringBuilder("1");
        for (int i = 1; i < length; i++) {
            result.append("0");
        }
        return Integer.parseInt(result.toString());
    }

    /**
     * n 번째 있는 원래 숫자의 길이
     */
    public int findLength(int n) {
        if (n < 10) {
            return 1;
        }

        int length = 2;
        String count = "89";
        int sum = 9;
        while (true) {
            if (sum >= n) {
                return length - 1;
            }

            sum += Integer.parseInt(count) * length;

            length++;
            count = count + "9";
        }
    }

    public int findLengthSum(int length) {
        if (length == 1) {
            return 9;
        }

        String count = "89";
        int sum = 9;
        int currentLength = 2;
        while (currentLength <= length) {
            sum += Integer.parseInt(count) * currentLength;

            currentLength++;
            count = count + "9";
        }

        return sum;
    }

    public int minusPreLength(int n, int length) {
        if (length == 1) {
            return n;
        }

        return n - findLengthSum(length - 1);
    }
}
