package realmytrip;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NM = br.readLine().split(" ");
        Stream<Integer> arrayA = Arrays.stream(br.readLine().split(" ")).map(Integer::valueOf);
        Stream<Integer> arrayB = Arrays.stream(br.readLine().split(" ")).map(Integer::valueOf);
        List<Integer> arrayAB = Stream.concat(arrayA, arrayB).collect(Collectors.toList());

        SortedSet<Integer> set1 = new TreeSet<>();
        Set<Integer> set2 = new HashSet<>();

        for (int i = 0; i < arrayAB.size(); i++) {
            if (set1.contains(arrayAB.get(i))) {
                set1.remove(arrayAB.get(i));
                set2.add(arrayAB.get(i));
                continue;
            }

            if (set2.contains(arrayAB.get(i))) {
                continue;
            }

            set1.add(arrayAB.get(i));
        }

        StringBuilder sb = new StringBuilder();
        for (Integer result : set1) {
            sb.append(result + " ");
        }
        System.out.println(sb.toString().trim());
    }
}
