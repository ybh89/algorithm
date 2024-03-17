package inflearn.dfs;

import java.util.*;

public class Dfs12 {
    private static List<List<Integer>> links = new ArrayList<>();
    private static Integer n;
    private static Integer count = 0;
    private static Set<Integer> visited = new HashSet<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] NM = scanner.nextLine().split(" ");
        n = Integer.valueOf(NM[0]);
        Integer m = Integer.valueOf(NM[1]);

        for (int i = 0; i <=n; i++) {
            links.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            String[] link = scanner.nextLine().split(" ");
            links.get(Integer.parseInt(link[0])).add(Integer.valueOf(link[1]));
        }
        visited.add(1);
        dfs(1);
        System.out.println(count);
    }

    private static void dfs(Integer target) {
        if (target.equals(n)) {
            count++;
            return;
        }

        for (Integer link : links.get(target)) {
            if (!visited.contains(link)) {
                visited.add(link);
                dfs(link);
                visited.remove(link);
            }
        }
    }
}
