package kakaomobility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution3 {
    public static void main(String[] args) {
        System.out.println(solution(1, "1H"));
    }
    public static int solution(int N, String S) {
        int count = 0;
        /**
         * index 0 -> 왼쪽 가족 좌석
         * index 1 -> 중앙 가족 좌석
         * index 2 -> 오른쪽 가족 좌석
         */
        List<boolean[]> availableFamilySide = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            availableFamilySide.add(new boolean[3]);
        }


        if (!S.equals("")) {
            String[] reservedSeats = S.split(" ");
            for (String reservedSeat : reservedSeats) {
                char seatCode = reservedSeat.substring(reservedSeat.length() - 1).toCharArray()[0];
                int seatRow = Integer.parseInt(reservedSeat.substring(0, reservedSeat.length() - 1));

                if ('B' == seatCode || seatCode == 'C') {
                    availableFamilySide.get(seatRow)[0] = true;
                    continue;
                }

                if ('D' == seatCode || seatCode == 'E') {
                    availableFamilySide.get(seatRow)[0] = true;
                    availableFamilySide.get(seatRow)[1] = true;
                    continue;
                }

                if ('F' == seatCode || seatCode == 'G') {
                    availableFamilySide.get(seatRow)[1] = true;
                    availableFamilySide.get(seatRow)[2] = true;
                    continue;
                }

                if ('H' == seatCode || seatCode == 'J') {
                    availableFamilySide.get(seatRow)[2] = true;
                    continue;
                }
            }
        }

        for (int i = 1; i < availableFamilySide.size(); i++) {
            boolean[] side = availableFamilySide.get(i);
            System.out.println(Arrays.toString(side));

            if (side[0] && side[1] && side[2]) {
                continue;
            }

            if (!side[0] && !side[2]) {
                count += 2;
                continue;
            }

            count++;
        }

        return count;

    }
}
