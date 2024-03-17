package ssocar;

import java.util.*;

public class Solution2 {
    private int answer = Integer.MAX_VALUE;
    private int[] array;
    private boolean[] visited;
    private int gap;

    public int solution(int[] numbers, int k) {
        array = numbers;
        visited = new boolean[numbers.length];
        gap = k;
        int[] perm = new int[numbers.length];

        bt(0, perm);

        return answer == Integer.MAX_VALUE ? -1 : answer;
    }

    private void bt(int depth, int[] result) {
        if (depth == array.length) {
            System.out.println(Arrays.toString(result));
            if (isValid(result)) {
                answer = Math.min(answer, countSwaps(result));
            }
            return;
        }

        for (int i = 0; i < array.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                result[depth] = array[i];
                bt(depth + 1, result);
                visited[i] = false;
            }
        }
    }

    private boolean isValid(int[] result) {
        for (int i = 1; i < result.length; i++) {
            if (Math.abs(result[i] - result[i - 1]) > gap) {
                return false;
            }
        }
        return true;
    }

    private int countSwaps(int[] result) {
        int swaps = 0;
        int[] tmp = Arrays.copyOf(array, array.length);

        for (int i = 0; i < array.length; i++) {
            if (tmp[i] != result[i]) {
                swaps++;
                int idx = indexOf(tmp, result[i]);
                swap(tmp, i, idx);
            }
        }
        return swaps;
    }

    private int indexOf(int[] tmp, int value) {
        for (int i = 0; i < tmp.length; i++) {
            if (tmp[i] == value) {
                return i;
            }
        }
        return -1;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        Solution2 sol = new Solution2();
        System.out.println(sol.solution(new int[]{10,40,30,20}, 20));
        //System.out.println(sol.solution(new int[]{3,7,2,8,6,4,5,1}, 3));
    }
}
