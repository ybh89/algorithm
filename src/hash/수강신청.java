package hash;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 백준 - 13414
 */
public class 수강신청 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] inputs = sc.nextLine().split(" ");
        int K = Integer.parseInt(inputs[0]); // 수강 가능 인원수
        int L = Integer.parseInt(inputs[1]); // 수강 신청 대기 인원수
        Set<String> set = new LinkedHashSet<>();

        for(int i=0; i<L; i++) {
            String seq = sc.nextLine();
            if(set.contains(seq)) {
                set.remove(seq);
            }
            set.add(seq);
        }

        StringBuilder sb = new StringBuilder();
        int index = 0;
        for(String seq : set) {
            if(index >= K) {
                break;
            }
            sb.append(seq+"\n");
            index++;
        }
        System.out.println(sb);
    }
}
