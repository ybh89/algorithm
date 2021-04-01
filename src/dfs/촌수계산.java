package dfs;

import java.util.*;

/**
 * 백준 - 2644
 * 9
 * 7 3
 * 7
 * 1 2
 * 1 3
 * 2 7
 * 2 8
 * 2 9
 * 4 5
 * 4 6
 */
public class 촌수계산 {
    private static int start;
    private static int end;
    private static List<List<Integer>> adList = new ArrayList<>();
    private static Set<Integer> isVisit = new HashSet<>();
    private static int result = -1;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = Integer.parseInt(sc.nextLine());
        String[] inputs = sc.nextLine().split(" ");
        start = Integer.parseInt(inputs[0]);
        end = Integer.parseInt(inputs[1]);
        int n = Integer.parseInt(sc.nextLine());

        for(int i=0; i<=a; i++) {
            adList.add(new ArrayList<>());
        }

        for(int i=1; i<=n; i++) {
            String[] ads = sc.nextLine().split(" ");
            int x = Integer.parseInt(ads[0]);
            int y = Integer.parseInt(ads[1]);
            adList.get(x).add(y);
            adList.get(y).add(x);
        }

        isVisit.add(start);
        dfs(start, 0);
        System.out.println(result);
    }

    private static void dfs(int node, int count) {
        if(node == end) {
            result = count;
            return;
        }

        for(Integer nextNode : adList.get(node)) {
            if(!isVisit.contains(nextNode)) {
                isVisit.add(nextNode);
                count++;
                dfs(nextNode, count);
                count--;
                isVisit.remove(nextNode);
            }
        }
    }
}
