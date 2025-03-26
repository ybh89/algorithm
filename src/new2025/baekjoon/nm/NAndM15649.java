package new2025.baekjoon.nm;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

public class NAndM15649 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] inputs = scanner.nextLine().split(" ");
        NAndM15649 sol = new NAndM15649();
        sol.permutationDuplicate(0, Integer.parseInt(inputs[0]), Integer.parseInt(inputs[1]), new Stack<>());
        scanner.close();
    }


    // 기본 순열 15649
    public void permutation(int depth, int n, int m, Stack<Integer> result, Set<Integer> visitedSet) {
        if (depth == m) {
            StringBuilder sb = new StringBuilder();
            for (Integer i : result) {
                sb.append(i).append(" ");
            }
            System.out.println(sb.toString().trim());
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (visitedSet.contains(i)) {
                continue;
            }

            visitedSet.add(i);
            result.push(i);
            permutation(depth + 1, n, m, result, visitedSet);
            result.pop();
            visitedSet.remove(i);
        }
    }

    // 오름차순 순열 15650
    public void permutationAsc(int depth, int n, int m, int start, Stack<Integer> result) {
        if (depth == m) {
            StringBuilder sb = new StringBuilder();
            for (Integer i : result) {
                sb.append(i).append(" ");
            }
            System.out.println(sb.toString().trim());
            return;
        }

        for (int i = start; i <= n; i++) {
            result.push(i);
            permutationAsc(depth + 1, n, m, i + 1, result);
            result.pop();
        }
    }

    // 중복있는 순열 15651
    public void permutationDuplicate(int depth, int n, int m, Stack<Integer> result) {
        if (depth == m) {
            StringBuilder sb = new StringBuilder();
            for (Integer i : result) {
                sb.append(i).append(" ");
            }
            System.out.println(sb.toString().trim());
            return;
        }

        for (int i = 1; i <= n; i++) {
            result.push(i);
            permutationDuplicate(depth+1, n, m, result);
            result.pop();
        }
    }
}
