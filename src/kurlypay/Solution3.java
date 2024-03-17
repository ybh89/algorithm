package kurlypay;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(br.readLine());
        List<Integer> positive = new ArrayList<>();
        List<Integer> negative = new ArrayList<>();

        for (int i = 0; i < number; i++) {
            int container = Integer.parseInt(br.readLine());
            if (container > 0) {
                positive.add(container);
                continue;
            }

            negative.add(container);
        }

        if (positive.isEmpty() && negative.isEmpty()) {
            System.out.print(0);
            return;
        }

        if (positive.isEmpty() || negative.isEmpty()) {
            System.out.print(1);
            return;
        }

        if (positive.size() == negative.size()) {
            System.out.print(positive.size() * 2);
            return;
        }

        if (positive.size() > negative.size()) {
            System.out.print((negative.size() * 2) + 1);
            return;
        }

        System.out.print((positive.size() * 2) + 1);
    }
}
