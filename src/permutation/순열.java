package permutation;

import java.util.Scanner;

public class 순열 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            String[] inputs = sc.nextLine().split(" ");
            str = inputs[0];
            n = Integer.parseInt(inputs[1]);

            findNthOfPermutation();
            System.out.println(" = " + (res.equals("") ? "No permutation" : res));
            res = "";
        }
    }

    private static void findNthOfPermutation() {
        backTracking(0, new StringBuilder());
    }

    private static int count = 0;
    private static int n = 4000;
    private static String res = "";
    private static String str = "";
    private static void backTracking(int level, StringBuilder result) {
        //종료
        if(level == str.length()) {
            count++;
            if(count == n) {
                res = result.toString();
            }
            return;
        }

        //프로세스
        for (int i=level; i<str.length(); i++) {
            swap(level, i);
            result.append(str.charAt(level));
            //재귀
            backTracking(level+1, result);
            result.deleteCharAt(result.length()-1);
            swap(level, i);
        }
        /*for(int i=0; i<str.length(); i++) {
            String c = String.valueOf(str.charAt(i));
            if(!result.toString().contains(c)) {

                result.append(c);
                //재귀
                backTracking(, result);

                result.deleteCharAt(result.length()-1);
            }
        }*/
    }

    private static void swap(int a, int b) {
        String[] array = str.split("");
        String temp = array[a];
        array[a] = array[b];
        array[b] = temp;
        str = String.join("", array);
    }
}
