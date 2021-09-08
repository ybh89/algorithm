package testdome;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static int[] findTwoSum(int[] list, int sum) {
        Map<Integer, Integer> numberIndexes = new HashMap<>();
        for (int i = 0; i < list.length; i++) {
            numberIndexes.put(list[i], i);
        }

        for (int i = 0; i < list.length; i++) {
            int currentNumber = list[i];
            int findNumber = sum - currentNumber;
            if (numberIndexes.containsKey(findNumber)) {
                if (i == numberIndexes.get(findNumber)) continue;
                return new int[]{i, numberIndexes.get(findNumber)};
            }
        }

        return null;
    }

    public static void main(String[] args) {
        int[] indices = findTwoSum(new int[] { 3, 1, 5, 7, 5, 9 }, 10);
        if(indices != null) {
            System.out.println(indices[0] + " " + indices[1]);
        }
    }
}
