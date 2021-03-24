package combination;

import java.util.Scanner;

/**
 * 백준 - 6603
 * 7 1 2 3 4 5 6 7
 * 8 1 2 3 5 8 13 21 34
 * 0
 */
public class 로또 {
    private static String[] inputs;
    private static boolean[] isVisit;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            inputs = sc.nextLine().split(" ");
            isVisit = new boolean[inputs.length];

            if(inputs[0].equals("0")) {
                return;
            }

            printCombination(6, 1);
            System.out.println();
        }
    }

    private static void printCombination(int depth, int start) {
        //종료
        if(depth == 0) {
            StringBuilder sb = new StringBuilder();
            for(int i=1; i<isVisit.length; i++) {
                if(isVisit[i]) {
                    sb.append(inputs[i]+ " ");
                }
            }
            System.out.println(sb.toString().trim());
            return;
        }

        //프로세스
        for(int i=start; i<inputs.length; i++) {
            isVisit[i] = true;
            printCombination(depth-1, i+1);
            isVisit[i] = false;
        }
    }
}
