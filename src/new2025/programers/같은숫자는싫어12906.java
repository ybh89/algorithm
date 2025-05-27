package new2025.programers;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class 같은숫자는싫어12906 {
    public static void main(String[] args) {

    }

    public int[] solution(int []arr) {
        int[] current = new int[]{-1};
        return Arrays.stream(arr)
                .filter(value -> {
                    boolean result = value != current[0];
                    if (result) {
                        current[0] = value;
                    }
                    return result;
                }).toArray();
    }
}
