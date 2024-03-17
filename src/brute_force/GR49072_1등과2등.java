package brute_force;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class GR49072_1등과2등 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        if (input.contains("121") || input.contains("122") || input.contains("212") || input.contains("211")) {
            System.out.println("No");
            return;
        }

        if (!input.contains("12") && !input.contains("21")) {
            System.out.println("No");
            return;
        }

        System.out.println("Yes");
    }
}
