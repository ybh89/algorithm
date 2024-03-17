package kurlypay;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Objects;
import java.util.SortedSet;
import java.util.TreeSet;

public class Solution2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(br.readLine());
        int[] eatTime = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] cookTime = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        SortedSet<Lunch> lunches = new TreeSet<>((o1, o2) -> {
            if (o2.getEatTime() == o1.getEatTime()) {
                return o1.getId() - o2.getId();
            }
            return o2.getEatTime() - o1.getEatTime();
        });
        for (int i = 0; i < number; i++) {
            lunches.add(new Lunch(i + 1, eatTime[i], cookTime[i]));
        }

        int maxTime = 0;
        int startCookTime = 0;
        for (Lunch lunch : lunches) {
            int endCookTime = startCookTime + lunch.getCookTime();
            int endEatTime = startCookTime + lunch.getCookTime() + lunch.getEatTime();

            if (maxTime < endEatTime) {
                maxTime = endEatTime;
            }
            startCookTime = endCookTime;
        }

        System.out.print(maxTime);
    }

    static class Lunch {
        private int id;
        private int eatTime;
        private int cookTime;

        public Lunch(int id, int eatTime, int cookTime) {
            this.id = id;
            this.eatTime = eatTime;
            this.cookTime = cookTime;
        }

        public int getId() {
            return id;
        }

        public int getEatTime() {
            return eatTime;
        }

        public int getCookTime() {
            return cookTime;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Lunch lunch = (Lunch) o;
            return id == lunch.id;
        }

        @Override
        public int hashCode() {
            return Objects.hash(id);
        }
    }
}
