package new2025.programers;

import java.util.ArrayList;
import java.util.List;

public class N개의최소공배12953 {
    public static void main(String[] args) {
        N개의최소공배12953 sol = new N개의최소공배12953();
        System.out.println(sol.solution(new int[]{60, 48}));
    }

    public int solution(int[] arr) {
        if (arr.length == 1) {
            return arr[0];
        }

        int min = 1;
        for (int i = 1; i < arr.length; i++) {
            List<Integer> list = new ArrayList<>();
            if (i == 1) {
                recur(new int[]{arr[0], arr[1]}, list);
            } else {
                recur(new int[]{min, arr[i]}, list);
            }

            min = 1;
            for (Integer integer : list) {
                min *= integer;
            }
        }

        return min;
    }

    public void recur(int[] arr, List<Integer> list) {
        if (arr[0] == 1) {
            for (int a : arr) {
                list.add(a);
            }
            return;
        }

        int i = 2;
        while (true) {
            if (i == arr[0]) {
                for (int a : arr) {
                    list.add(a);
                }
                return;
            }

            boolean flag = true;
            for (int k : arr) {
                if (k % i != 0) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                list.add(i);
                break;
            }

            i++;
        }

        Integer i1 = list.get(list.size() - 1);
        for (int i2 = 0; i2 < arr.length; i2++) {
            arr[i2] = arr[i2]/i1;
        }
        recur(arr, list);
    }
}
