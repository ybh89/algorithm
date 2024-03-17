package inflearn.dfs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Dfs6 {
    private static List<Boolean> use = new ArrayList<>();
    private static int number;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        number = scanner.nextInt();
        scanner.close();
        for (int i = 0; i <= number; i++) {
            use.add(false);
        }
        solution();
    }

    private static void solution() {
        dfs(1);
    }

    private static void dfs(int length) {
        if (length > number) {
            for (int i = 1; i < use.size(); i++) {
                if (use.get(i)) {
                    System.out.print(i + " ");
                }
            }
            System.out.println();
            return;
        }
        use.set(length, true);
        dfs(length + 1);
        use.set(length, false);
        dfs(length + 1);
    }
}
