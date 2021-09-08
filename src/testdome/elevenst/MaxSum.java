package testdome.elevenst;

import java.util.Arrays;
import java.util.List;

public class MaxSum {

    public static int findMaxSum(List<Integer> list) {
        if (list.isEmpty()) {
            return 0;
        }

        int firstMax = list.get(0);
        int secondMax = 0;

        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) > firstMax) {
                secondMax = firstMax;
                firstMax = list.get(i);
            }
        }

        return firstMax + secondMax;
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(5, 9, 7, 11, 1, 2, 3, 100, 6, 4, 200, 0);
        System.out.println(findMaxSum(list));
    }
}
