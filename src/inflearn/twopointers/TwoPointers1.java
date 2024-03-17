package inflearn.twopointers;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TwoPointers1 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        List<String> data1 = List.of(scanner.nextLine().split(" "));
        scanner.nextLine();
        List<String> data2 = List.of(scanner.nextLine().split(" "));

        solution(data1, data2);
    }

    public static void solution(List<String> data1, List<String> data2) {
        List<String> result = new ArrayList<>();
        int data1Index = 0;
        int data2Index = 0;

        while (data1Index < data1.size() && data2Index < data2.size()) {
            if (data1.get(data1Index).compareTo(data2.get(data2Index)) <= 0) {
                result.add(data1.get(data1Index));
                data1Index++;
                continue;
            }

            if (data1.get(data1Index).compareTo(data2.get(data2Index)) >= 0) {
                result.add(data2.get(data2Index));
                data2Index++;
                continue;
            }
        }

        if (data1Index > data1.size() -1) {
            result.addAll(data2.subList(data2Index, data2.size()));
        }
        if (data2Index > data2.size() - 1) {
            result.addAll(data1.subList(data1Index, data1.size()));
        }

        for (String s : result) {
            System.out.print(s + " ");
        }
    }
}
