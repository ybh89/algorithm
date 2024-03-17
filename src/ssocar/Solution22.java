package ssocar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution22 {
    private static int[] array;
    private static int gap;
    private static boolean[] visited;
    private static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        // System.out.println(solution(new int[]{10,40,30,20}, 20));
        System.out.println(solution(new int[]{1}, 2));
    }

    public static int solution(int[] numbers, int k) {
        if (numbers.length == 1) {
            return -1;
        }
        array = numbers;
        gap = k;
        visited = new boolean[numbers.length];
        bt(0, new ArrayList<>());
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    public static void bt(int depth, List<Integer> results) {
        if (depth == array.length) {
            if (isValid(results)) {
                int count = countSwap(results);
                min = Math.min(min, count);
            }
            return;
        }

        for (int i = 0; i < array.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                results.add(array[i]);
                bt(depth + 1, results);
                results.remove(results.size() - 1);
                visited[i] = false;
            }
        }
    }

    private static int countSwap(List<Integer> results) {
        int count = 0;
        int[] temp = Arrays.copyOf(array, array.length);
        for (int i = 0; i < temp.length; i++) {
            if (!results.get(i).equals(temp[i])) {
                int index = indexOf(temp, results.get(i));
                swap(temp, i, index);
                count++;
            }
        }

        return count;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static int indexOf(int[] temp, Integer target) {
        for (int i = 0; i < temp.length; i++) {
            if (target.equals(temp[i])) {
                return i;
            }
        }

        return -1;
    }

    private static boolean isValid(List<Integer> results) {
        for (int i = 1; i < results.size(); i++) {
            if (Math.abs(results.get(i) - results.get(i - 1)) > gap) {
                return false;
            }
        }

        return true;
    }
}
