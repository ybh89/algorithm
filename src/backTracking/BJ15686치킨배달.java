package backTracking;

import java.util.*;

public class BJ15686치킨배달 {
    private static List<List<Integer>> distances = new ArrayList<>();
    private static List<int[]> chickenHouses = new ArrayList<>();
    private static List<int[]> houses = new ArrayList<>();
    private static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] inputs = scanner.nextLine().split(" ");
        int n = Integer.parseInt(inputs[0]);
        int m = Integer.parseInt(inputs[1]);

        for (int i = 0; i < n; i++) {
            int[] input = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < n; j++) {
                if (input[j] == 1) {
                    houses.add(new int[]{i + 1, j + 1});
                    continue;
                }
                if (input[j] == 2) {
                    chickenHouses.add(new int[]{i + 1, j + 1});
                }
            }
        }

        for (int i = 0; i <= chickenHouses.size(); i++) {
            distances.add(new ArrayList<>());
            for (int j = 0; j <= houses.size(); j++) {
                distances.get(i).add(0);
            }
        }

        calculateDistance(houses, chickenHouses);
        for (int i = 1; i <= m; i++) {
            bt(i, 0, 0, new HashSet<>());
        }

        System.out.println(min);
    }

    private static void bt(int pick, int depth, int start,  Set<int[]> combination) {
        if (depth == pick) {
            int distance = 0;
            for (int i = 0; i < houses.size(); i++) {
                int minDistance = Integer.MAX_VALUE;
                for (int[] ints : combination) {
                    int j = chickenHouses.indexOf(ints);
                    minDistance = Math.min(distances.get(j).get(i), minDistance);
                }
                distance += minDistance;
            }
            min = Math.min(distance, min);
            return;
        }

        for (int i = start; i < chickenHouses.size(); i++) {
            if (!combination.contains(i)) {
                combination.add(chickenHouses.get(i));
                bt(pick, depth + 1, i + 1, combination);
                combination.remove(chickenHouses.get(i));
            }
        }
    }

    private static void calculateDistance(List<int[]> houses, List<int[]> chickenHouses) {
        for (int i = 0; i < houses.size(); i++) {
            for (int j = 0; j < chickenHouses.size(); j++) {
                int[] house = houses.get(i);
                int[] chickenHouse = chickenHouses.get(j);

                int distance = Math.abs(house[0] - chickenHouse[0]) + Math.abs(house[1] - chickenHouse[1]);
                distances.get(j).set(i, distance);
            }
        }
    }
}
