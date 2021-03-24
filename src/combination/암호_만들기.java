package combination;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 백준 - 1759
 */
public class 암호_만들기 {
    private static String[] characters;
    private static boolean[] isVisit;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int L = Integer.parseInt(sc.nextLine().split(" ")[0]);
        characters = sc.nextLine().split(" ");
        Arrays.sort(characters);
        isVisit = new boolean[characters.length];
        printCombination(L, 0);
    }

    private static void printCombination(int depth, int start) {
        //종료
        if(depth == 0) {
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<isVisit.length; i++) {
                if(isVisit[i]) {
                    sb.append(characters[i]);
                }
            }

            if(isValid(sb)) {
                System.out.println(sb);
            }
            return;
        }

        //프로세스
        for(int i=start; i<characters.length; i++) {
            isVisit[i] = true;
            printCombination(depth-1, i+1);
            isVisit[i] = false;
        }
    }

    private static boolean isValid(StringBuilder sb) {
        Set<Character> collections = new HashSet<>(Arrays.asList('a','e','i','o','u'));
        int collectionCount = 0; // 모음수
        int consonantCount = 0; // 자음수

        for(int i=0; i<sb.length(); i++) {
            if(collections.contains(sb.charAt(i))) {
                collectionCount++;
            } else {
                consonantCount++;
            }
        }

        return collectionCount > 0 && consonantCount > 1;
    }

}
