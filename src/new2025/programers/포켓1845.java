package new2025.programers;

import java.util.HashSet;
import java.util.Set;

public class 포켓1845 {
    public static void main(String[] args) {
        포켓1845 sol = new 포켓1845();
        System.out.println(sol.solution(new int[]{3,1,2,3}));
    }

    public int solution(int[] nums) {
        int choiceNum = nums.length / 2;
        Set<Integer> set = new HashSet();
        for (int num : nums) {
            set.add(num);
        }

        return Math.min(choiceNum, set.size());
    }
}
