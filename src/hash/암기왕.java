package hash;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 백준 - 2776
 */
public class 암기왕 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());

        for(int t=0; t<T; t++) {
            sc.nextLine();
            String[] note1 = sc.nextLine().split(" ");
            sc.nextLine();
            String[] note2 = sc.nextLine().split(" ");
            Set<String> set = new HashSet<>();
            StringBuilder sb = new StringBuilder();

            for(int i=0; i<note1.length; i++) {
                set.add(note1[i]);
            }

            for(int i=0; i<note2.length; i++) {
                if(set.contains(note2[i])) {
                    sb.append("1\n");
                } else {
                    sb.append("0\n");
                }
            }
            System.out.print(sb);
        }
    }
}
