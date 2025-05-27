package new2025.programers.bruteforcesearch;

public class 모음사전84512 {
    private static final char[] MO = new char[]{'A', 'E', 'I', 'O', 'U'};
    private int sum = 0;
    private int count = 0;

    public static void main(String[] args) {
        모음사전84512 sol = new 모음사전84512();
        System.out.println(sol.solution("AAAAE"));
    }

    public int solution(String word) {
        dfs(0, new StringBuilder(), word);
        return sum;
    }

    public void dfs(int depth, StringBuilder result, String target) {
        if (sum != 0) {
            return;
        }
        if (result.toString().equals(target)) {
            System.out.println(result);
            sum = count;
            return;
        }
        if (depth == 5) {
            return;
        }

        for (int i = 0; i < MO.length; i++) {
            char c = MO[i];
            result.append(c);
            count++;
            dfs(depth+1, result, target);
            result.deleteCharAt(result.length() - 1);
        }
    }
}
