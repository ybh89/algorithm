package testdome.elevenst;

import java.util.ArrayDeque;
import java.util.Queue;

public class Veterinarian {
    private Queue<String> waitingLine = new ArrayDeque<>();

    public void accept(String petName) {
        waitingLine.offer(petName);
    }

    public String heal() {
        return waitingLine.poll();
    }

    public static void main(String[] args) {
        Veterinarian veterinarian = new Veterinarian();
        veterinarian.accept("Barkley");
        veterinarian.accept("Mittens");
        System.out.println(veterinarian.heal());
        System.out.println(veterinarian.heal());
    }
}
