package goorm.stack_queue;

import java.util.Arrays;
import java.util.Scanner;

public class 최소합 {
    private int min = Integer.MAX_VALUE;
    private static int[][] map;
    private static boolean[][] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        map = new int[n][n];
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            String[] input = sc.nextLine().split(" ");
            int[] numbers = Arrays.stream(input).mapToInt(value -> Integer.parseInt(value)).toArray();
            map[i] = numbers;
        }

        combination(2, new StringBuilder());
    }

    private static void combination(int count, StringBuilder result) {
        if (count == 0) {
            System.out.println(result);
            return;
        }

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                visited[i][j] = true;
                result.append(map[i][j] + " ");
                combination(count - 1, result);
                int len = String.valueOf(map[i][j]).length() + 1;
                result.delete(result.length() - len, result.length());
                visited[i][j] = false;
            }
        }
    }
}
