package permutation;

import java.util.Scanner;

public class 순열 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            String[] inputs = sc.nextLine().split(" ");
            String str = inputs[0];
            n = Integer.parseInt(inputs[1]);

            findNthOfPermutation(str);
            System.out.println(" = " + (res.equals("") ? "No permutation" : res));
            res = "";
        }
    }

    private static void findNthOfPermutation(String str) {
        backTracking(str, "");
    }

    private static int count = 0;
    private static int n = 4000;
    private static String res = "";
    private static void backTracking(String str, String result) {
        //종료
        if(result.length() == str.length()) {
            count++;
            if(count == n) {
                res = result;
            }
            return;
        }

        //프로세스
        for(int i=0; i<str.length(); i++) {
            String c = String.valueOf(str.charAt(i));
            if(!result.contains(c)) {
                //재귀
                backTracking(str, result+c);
            }
        }
    }
}
