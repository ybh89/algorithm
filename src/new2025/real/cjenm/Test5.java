package new2025.real.cjenm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test5 {
    List<Integer> result = new ArrayList<>();

    public static void main(String[] args) {
        Test5 test5 = new Test5();
        System.out.println(Arrays.toString(test5.solution(5)));
    }

    public int[] solution(int n) {
        List<Integer> array = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            array.add(i);
        }
        int p = getP(array.size());

        divide(array, p);
        return result.stream().mapToInt(i -> i).toArray();
    }

    public void divide(List<Integer> array, int p) {
        if (array.size() == 1) {
            result.add(array.get(0));
            return;
        }
        int left;
        int right = array.size() / p - 1;

        for (int i = 0; i < p; i++) {
            List<Integer> subArray = new ArrayList<>();
            for (int j = i; j < array.size(); j+=p) {
                subArray.add(array.get(j));
            }
            int nextP = getP(subArray.size());
            divide(subArray, nextP);
            left = right + 1;
            right = left + (array.size() / p) - 1;
        }
    }

    // 가장 작은 소수 구하기
    public int getP(int n) {
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return i;
            }
        }

        return n;
    }
}
