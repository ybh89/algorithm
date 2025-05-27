package new2025.baekjoon.dfs;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class 이분그래프1707 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < k; i++) {
            String[] VE = sc.nextLine().split(" ");
            int v = Integer.parseInt(VE[0]);
            int e = Integer.parseInt(VE[1]);
            Set<Integer> set1 = new HashSet<>();
            Set<Integer> set2 = new HashSet<>();

            for (int j = 0; j < e; j++) {
                String[] line = sc.nextLine().split(" ");
                int v1 = Integer.parseInt(line[0]);
                int v2 = Integer.parseInt(line[1]);

                if ((set1.contains(v1) && set1.contains(v2)) || (set2.contains(v2) && set2.contains(v1))) {
                    System.out.println("NO");
                    break;
                }

                if (!set1.contains(v1) && !set2.contains(v1) && !set2.contains(v2) && !set2.contains(v2)) {
                    set1.add(v1);
                    set2.add(v2);
                    if (j == e - 1) {
                        System.out.println("YES");
                    }
                    continue;
                }

                if (set1.contains(v1) && !set2.contains(v2)) {
                    set2.add(v2);
                    if (j == e - 1) {
                        System.out.println("YES");
                    }
                    continue;
                }

                if (set2.contains(v1) && !set1.contains(v2)) {
                    set1.add(v2);
                    if (j == e - 1) {
                        System.out.println("YES");
                    }
                    continue;
                }

                if (set1.contains(v2) && !set2.contains(v1)) {
                    set2.add(v1);
                    if (j == e - 1) {
                        System.out.println("YES");
                    }
                    continue;
                }

                if (set2.contains(v2) && !set1.contains(v1)) {
                    set1.add(v1);
                    if (j == e - 1) {
                        System.out.println("YES");
                    }
                }
            }
        }
    }
}
