package sort;

import java.util.stream.IntStream;

public class H_Index {
    public static void main(String[] args) {
        H_Index o = new H_Index();
        System.out.println(o.solution(new int[]{3, 0, 6, 1, 5}));
        System.out.println(o.solution(new int[]{1}));
        System.out.println(o.solution(new int[]{0,0,0,0}));
    }
    public int solution(int[] citations) {
        int[] sortedCitations = IntStream.of(citations)
                .map(i -> -i)
                .sorted()
                .map(i -> -i)
                .toArray();

        return IntStream.iterate(1, i -> i+1)
                .limit(sortedCitations.length)
                .filter(i -> i == sortedCitations[i-1])
                .findFirst()
                .orElse(0);
    }
}
