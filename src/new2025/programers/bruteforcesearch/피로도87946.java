package new2025.programers.bruteforcesearch;

public class 피로도87946 {
    private int maxDistance = -1;
    public static void main(String[] args) {
        피로도87946 sol = new 피로도87946();
        System.out.println(sol.solution(80, new int[][]{{80,20}, {50,40}, {30,10}}));
    }

    public int solution(int k, int[][] dungeons) {
        dfs(0, k, dungeons, new boolean[dungeons.length]);
        return maxDistance;
    }

    public void dfs(int distance, int k, int[][] dungeons, boolean[] visited) {
        maxDistance = Math.max(maxDistance, distance);

        for (int i = 0; i < dungeons.length; i++) {
            if (visited[i]) {
                continue;
            }

            if (k >= dungeons[i][0]) {
                visited[i] = true;
                dfs(distance + 1, k - dungeons[i][1], dungeons, visited);
                visited[i] = false;
            }
        }
    }
}
