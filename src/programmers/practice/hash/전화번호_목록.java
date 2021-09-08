package programmers.practice.hash;

import java.util.Arrays;

public class 전화번호_목록 {
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);
        for (int i = 0; i < phone_book.length - 1; i++) {
            String prePhone = phone_book[i];
            String postPhone = phone_book[i + 1];
            if (postPhone.startsWith(prePhone)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        전화번호_목록 solution = new 전화번호_목록();
        String[] phone_book = new String[]{"12","123","1235","567","88"};
        System.out.println(solution.solution(phone_book));
    }
}
