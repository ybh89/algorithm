package ssocar;

import java.util.*;

public class Solution1 {
    private static List<List<Destination>> map = new ArrayList<>();
    private static int seconds;
    private static SortedSet<Integer> results = new TreeSet<>();

    public static void main(String[] args) {
        //System.out.println(Arrays.toString(solution(6, 17, new int[][]{{5,4,6}, {5,2,5}, {0,4,2}, {2,3,3}, {1,2,7}, {0,1,3}})));
        //System.out.println(Arrays.toString(solution(4, 10, new int[][]{{0,1,2}, {0,2,3}})));
        System.out.println(Arrays.toString(solution(4, 11, new int[][]{{0,1,2}, {1,2,7}, {2,3,10}, {3,0,9}})));
    }

    public static int[] solution(int n, int k, int[][] roads) {
        seconds = k;
        for (int i = 0; i < n; i++) {
            map.add(new ArrayList<>());
        }

        for (int[] road : roads) {
            map.get(road[0]).add(new Destination(road[1], road[2]));
            map.get(road[1]).add(new Destination(road[0], road[2]));
        }

        bt(0, 0);
        if (results.isEmpty()) {
            return new int[]{-1};
        }

        return results.stream()
                .mapToInt(value -> value)
                .toArray();
    }

    public static void bt(int totalSeconds, int currentNode) {
        if (totalSeconds > seconds) {
            return;
        }
        if (totalSeconds == seconds) {
            results.add(currentNode);
            return;
        }

        List<Destination> nextNodes = map.get(currentNode);
        for (int i = 0; i < nextNodes.size(); i++) {
            Destination destination = nextNodes.get(i);
            bt(totalSeconds + destination.getWeight(), destination.getNode());
        }
    }

    static class Destination {
        private int node;
        private int weight;

        public Destination(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }

        public int getNode() {
            return node;
        }

        public int getWeight() {
            return weight;
        }
    }
}
