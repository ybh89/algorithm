package new2025.real.class101;

public class Test2 {
    public static void main(String[] args) {
        Test2 test2 = new Test2();
        System.out.println(test2.solution("23"));
    }

    // 전체 S에서 1자리를 선택해서 그 자리 숫자말고 나머지 숫자를 더하고
    // 그 더한 값과 나머지 숫자의 합이 3의 배수가 되는 것만 선택
    public int solution(String S) {
        int count = 0;
        char[] charArray = S.toCharArray();

        int totalSum = 0;
        for (int i = 0; i < charArray.length; i++) {
            totalSum += Character.getNumericValue(charArray[i]);
        }
        if (totalSum % 3 == 0) {
            count++;
        }

        for (int i = 0; i < charArray.length; i++) {
            StringBuilder sb = new StringBuilder(S);
            sb.deleteCharAt(i);
            int sum = 0;
            for (int k = 0; k < sb.length(); k++) {
                sum += Character.getNumericValue(sb.charAt(k));
            }

            for (int j = 0; j <= 9; j++) {
                if (Character.getNumericValue(charArray[i]) == j) {
                    continue;
                }
                if ((sum + j) % 3 == 0) {
                    count++;
                }
            }
        }

        return count;
    }
}
