package new2025.programers;

import java.util.Arrays;

public class 비밀지도1차17681 {
    public static void main(String[] args) {
        비밀지도1차17681 sol = new 비밀지도1차17681();
        System.out.println(Arrays.toString(sol.solution(5, new int[]{9, 20, 28, 18, 11}, new int[]{30, 1, 21, 17, 28})));
    }

    public String[] solution(int n, int[] arr1, int[] arr2) {
        int[] arr3 = merge(arr1, arr2);
        String[] binaryStrings = toBinaryString(arr3);
        return toMap(binaryStrings);
    }

    public int[] merge(int[] arr1, int[] arr2) {
        int[] arr3 = new int[arr1.length];
        for (int i = 0; i < arr1.length; i++) {
            arr3[i] = arr1[i] | arr2[i];
        }

        return arr3;
    }

    public String[] toBinaryString(int[] arr) {
        String[] result = new String[arr.length];

        for (int i = 0; i < arr.length; i++) {
            result[i] = String.format("%" + arr.length + "s", Integer.toBinaryString(arr[i])).replace(' ', '0');
        }

        return result;
    }

    public String[] toMap(String[] binaryStrings) {
        String[] maps = new String[binaryStrings.length];
        for (int i = 0; i < binaryStrings.length; i++) {
            String binaryString = binaryStrings[i];
            String temp = binaryString.replaceAll("1", "#");
            maps[i] = temp.replaceAll("0", " ");
        }

        return maps;
    }
}
