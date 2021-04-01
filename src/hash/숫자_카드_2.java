package hash;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 백준 - 10816
 * 10
 * 6 3 2 10 10 10 -10 -10 7 3
 * 8
 * 10 9 -5 2 3 4 5 -10
 */
public class 숫자_카드_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
        String[] cards = sc.nextLine().split(" ");
        sc.nextLine();
        String[] numbers = sc.nextLine().split(" ");
        Map<String, Integer> map = new HashMap<>();

        for(int i=0; i<cards.length; i++) {
            map.put(cards[i], map.get(cards[i]) == null ? 1 : map.get(cards[i]) + 1);
        }

        StringBuilder result = new StringBuilder();
        for(int i=0; i<numbers.length; i++) {
            result.append((map.get(numbers[i]) == null ? 0 : map.get(numbers[i])) + " ");
        }

        System.out.println(result.toString().trim());
    }
}
