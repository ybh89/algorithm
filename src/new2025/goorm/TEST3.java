package new2025.goorm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TEST3 {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int t = Integer.parseInt(br.readLine());

            for (int i = 0; i < t; i++) {
                String input = br.readLine();
                String[] inputs = input.split(" ");
                long N = Long.parseLong(inputs[0]);
                long M = Long.parseLong(inputs[1]);

                long minN = N / 5;
                long minSum = (N + M) / 12;

                System.out.println(Math.min(minN, minSum));
            }
        }
    }
}
