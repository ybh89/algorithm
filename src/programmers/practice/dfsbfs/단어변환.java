package programmers.practice.dfsbfs;

public class 단어변환 {
    private String target;
    private String[] words;
    private int minCount = Integer.MAX_VALUE;
    private boolean[] visited;

    public int solution(String begin, String target, String[] words) {
        this.target = target;
        this.words = words;
        visited = new boolean[words.length];
        backtracking(begin, 0);
        if (minCount == Integer.MAX_VALUE) {
            return 0;
        }
        return this.minCount;
    }

    private void backtracking(String currentWord, int count) {
        if (currentWord.equals(target)) {
            if (minCount > count) {
                minCount = count;
            }
            return;
        }

        for (int i = 0; i < words.length; i++) {
            if (!visited[i] && isChangeable(currentWord, words[i])) {
                visited[i] = true;
                backtracking(words[i], count + 1);
                visited[i] = false;
            }
        }
    }

    private boolean isChangeable(String currentWord, String nextWord) {
        int differentCount = 0;
        for (int i = 0; i < currentWord.length(); i++) {
            if (differentCount > 1) {
                return false;
            }
            if (currentWord.charAt(i) != nextWord.charAt(i)) {
                differentCount++;
            }
        }
        return differentCount == 1;
    }

    public static void main(String[] args) {
        단어변환 solution = new 단어변환();
        String begin = "hit";
        String target = "cog";
        String[] words = new String[]{"cog", "log", "lot", "dog", "dot", "hot"};
        System.out.println(solution.solution(begin, target, words));
    }
}
