package new2025.goorm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TEST2 {
    public static void main(String[] args) throws IOException {
        String firstInput;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            firstInput = br.readLine();
            br.readLine();
        }

        String[] firstInputs = firstInput.split(" ");
        int N = Integer.parseInt(firstInputs[0]);
        int K = Integer.parseInt(firstInputs[1]);

        int mod = (N - 1) % (K - 1);
        int mock = (N - 1) / (K - 1);

        if (mod > 0) {
            mock++;
        }

        System.out.println(mock);
    }
}
